//
//  AddPatientFirstFormViewController.m
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "AddPatientFirstFormViewController.h"

@interface AddPatientFirstFormViewController ()

@property DBManager *dbManager;

@end

@implementation AddPatientFirstFormViewController

@synthesize dbManager;
@synthesize tap;
@synthesize hospital;
@synthesize patient;
@synthesize imageView;
@synthesize imagePickerController;
@synthesize insertButton;
@synthesize saveButton;
@synthesize doneButton;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];
    
    self.navigationItem.rightBarButtonItems = [NSArray arrayWithObjects:doneButton,nil];
    
    dbManager = [DBManager sharedSingleton];
    
    NSLog(@"Add Patient View: %@", hospital.hospitalName);
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    if ([[segue identifier] isEqualToString:@"addedpatientList"]) {
        
        PatientsView *view = segue.destinationViewController;
        view.hospital = self.hospital;
    }
}

-(void) viewWillAppear:(BOOL)animated {
    
    [super viewWillAppear:YES];
    
    NSLog(@"Add Patient View Controller: %@", hospital.hospitalName);
    
    self.title = @"Add Patient";
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)insertImage:(id)sender {
    
    UIImagePickerController *imagePicker = [[UIImagePickerController alloc] init];
    imagePicker.modalPresentationStyle = UIModalPresentationCurrentContext;
    imagePicker.sourceType = UIImagePickerControllerSourceTypePhotoLibrary;
    imagePicker.delegate = self;
    
    self.imagePickerController = imagePicker;
    [self presentViewController:self.imagePickerController animated:YES completion:nil];
    
}

- (void) imagePickerController:(UIImagePickerController *)picker didFinishPickingMediaWithInfo:(NSDictionary *)info
{
    // Access the uncropped image from info dictionary
    UIImage *image = [info objectForKey:@"UIImagePickerControllerOriginalImage"];
    
    self.imageView.image = image;
    
    insertButton.enabled = NO;
    
    [self dismissViewControllerAnimated:YES completion:NULL];
}


- (void)image:(UIImage *)image didFinishSavingWithError:(NSError *)error contextInfo:(void *)contextInfo
{
    UIAlertController *alert;
    
    // Unable to save the image
    if (error) {
        alert = [UIAlertController alertControllerWithTitle:@"Error" message:@"Unable to save image to Photo Album." preferredStyle:UIAlertControllerStyleAlert];
    }
    // All is well
    else {
        alert = [UIAlertController alertControllerWithTitle:@"Error" message:@"Image saved to Photo Album." preferredStyle:UIAlertControllerStyleAlert];
        
    }
    
    UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:
                                    UIAlertActionStyleDefault handler:^(UIAlertAction * action) {}];
    
    [alert addAction:defaultAction];
    [self presentViewController:alert animated:YES completion:nil];
    
}

- (IBAction)save:(id)sender {
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    NSString *rawFirstName = self.firstNameText.text;
    NSString *trimmedFirstName = [rawFirstName stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawLastName = self.lastNameText.text;
    NSString *trimmedLastName = [rawLastName stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawCity = self.cityText.text;
    NSString *trimmedCity = [rawCity stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawState = self.stateText.text;
    NSString *trimmedState = [rawState stringByTrimmingCharactersInSet:whitespace];
    
    if (!([trimmedFirstName length] > 0) || [trimmedFirstName isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"First Name Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedLastName length] > 0) || [trimmedLastName isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"Last Name Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedCity length] > 0) || [trimmedCity isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"City Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedState length] > 0) || [trimmedState isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"State Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else {
    Patient *p = [[Patient alloc] init];
    p.firstName = self.firstNameText.text;
    p.lastName = self.lastNameText.text;
    p.city = self.cityText.text;
    p.state = self.stateText.text;
    p.imageName = self.imageView.image;
    
    [self.hospital.patientList addObject:p];
    
    [self savePatientToDB:p];
    
    UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Added Successfully"
                                message:[p.firstName stringByAppendingString:@" has been successfully added to the database!"]preferredStyle:UIAlertControllerStyleAlert];
    UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                          handler:^(UIAlertAction * action) {}];
    [alert addAction:defaultAction];
    [self presentViewController:alert animated:YES completion:nil];
    
    self.firstNameText.enabled = NO;
    self.lastNameText.enabled = NO;
    self.cityText.enabled = NO;
    self.stateText.enabled = NO;
    
    self.insertButton.enabled = NO;
    self.saveButton.enabled = NO;
    }
}

- (void) savePatientToDB: (Patient *) p {
    
    // Copy the database if needed
    //[dbManager createEditableCopyOfDatabaseIfNeeded];
    
    NSString *filePath = [dbManager getWritableDBPath];
    
    sqlite3 *database;
    //NSString * theU=self.hospitalName.text;
    
    if(sqlite3_open([filePath UTF8String], &database) == SQLITE_OK) {
        
        const char *sqlStatement = "insert into Person (firstName, lastName, city, state, hospital, Image) VALUES (?, ?, ?, ?, ?, ?)";
        
        sqlite3_stmt *compiledStatement;
        
        if(sqlite3_prepare_v2(database, sqlStatement, -1, &compiledStatement, NULL) == SQLITE_OK)    {
            
            NSData* data = UIImagePNGRepresentation(p.imageName);
            
            sqlite3_bind_text( compiledStatement, 1,[p.firstName UTF8String], -1, SQLITE_TRANSIENT);
            sqlite3_bind_text( compiledStatement, 2,[p.lastName UTF8String], -1, SQLITE_TRANSIENT);
            sqlite3_bind_text( compiledStatement, 3,[p.city UTF8String], -1, SQLITE_TRANSIENT);
            sqlite3_bind_text( compiledStatement, 4,[p.state UTF8String], -1, SQLITE_TRANSIENT);
            sqlite3_bind_text( compiledStatement, 5,[self.hospital.hospitalName UTF8String], -1, SQLITE_TRANSIENT);
            sqlite3_bind_blob(compiledStatement, 6, [data bytes], [data length], SQLITE_TRANSIENT);
        }
        
        if(sqlite3_step(compiledStatement) != SQLITE_DONE ) {
            NSLog( @"Save Error: %s", sqlite3_errmsg(database) );
        }
        
        sqlite3_finalize(compiledStatement);
    }
    
    sqlite3_close(database);
}

-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

@end
