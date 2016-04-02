//
//  HospitalViewController.m
//  Assignment 7
//
//  Created by Hari Panjwani on 3/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "HospitalViewController.h"

@interface HospitalViewController ()


@property (nonatomic, strong) DBManager *dbManager;

@end

@implementation HospitalViewController

@synthesize tap;
@synthesize doneButton;
@synthesize hospital;
@synthesize dbManager;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Do any additional setup after loading the view.
    self.tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];
    
    self.navigationItem.rightBarButtonItems = [NSArray arrayWithObjects:doneButton,nil];
    //self.dbManager = [[DBManager alloc] initWithDatabaseFilename:@"hospitalDB.db"];
    
    dbManager = [DBManager sharedSingleton];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)createHospital:(id)sender {
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    NSString *rawHospitalName = self.hospitalName.text;
    NSString *trimmedHospitalName = [rawHospitalName stringByTrimmingCharactersInSet:whitespace];
    
    if (!([trimmedHospitalName length] > 0) || [trimmedHospitalName isEqual:@""] == TRUE) {
        
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Error" message:@"Hospital Name Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else {
        hospital = [[Hospital alloc] init];
        hospital.hospitalName = self.hospitalName.text;
        self.hospitalName.enabled = NO;
        self.createButton.enabled = NO;
        
        NSString *filePath = [dbManager getWritableDBPath];
        
        sqlite3 *database;
        //NSString * theU=self.hospitalName.text;
        
        if(sqlite3_open([filePath UTF8String], &database) == SQLITE_OK) {
            
            //NSString *temp = [NSString stringWithFormat:@"insert into allusers (user_id,user_name) VALUES (%@,%@)",user_id,user_name];
            
            const char *sqlStatement = "insert into Hospital (hospitalName) VALUES (?)";
            
            sqlite3_stmt *compiledStatement;
            
            if(sqlite3_prepare_v2(database, sqlStatement, -1, &compiledStatement, NULL) == SQLITE_OK)    {
                
                sqlite3_bind_text( compiledStatement, 1,[hospital.hospitalName UTF8String], -1, SQLITE_TRANSIENT);
                
            }
            
            if(sqlite3_step(compiledStatement) != SQLITE_DONE ) {
                NSLog( @"Save Error: %s", sqlite3_errmsg(database) );
            }
            else {
                
                UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Success" message:@"Hospital has been created Successfully!!" preferredStyle:UIAlertControllerStyleAlert];
                
                UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault handler:^(UIAlertAction * action) {}];
                [alert addAction:defaultAction];
                
                [self presentViewController:alert animated:YES completion:nil];
            }
            
            sqlite3_finalize(compiledStatement);                        
        }
        
        sqlite3_close(database);
    }
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    if ([segue.identifier isEqualToString:@"exitHospital"]) {
        
        ViewController *view = segue.destinationViewController;
        view.hospital = self.hospital;
    }
}

-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

@end
