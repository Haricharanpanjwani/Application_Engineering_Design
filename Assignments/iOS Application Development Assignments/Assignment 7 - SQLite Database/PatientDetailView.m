//
//  PatientDetailView.m
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/27/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "PatientDetailView.h"

@interface PatientDetailView ()

@property DBManager *dbManager;

@end

@implementation PatientDetailView

@synthesize dbManager;
@synthesize headerView;
@synthesize imageView;
@synthesize detailTableView;
@synthesize patientName;
@synthesize hospital;
@synthesize patient;
@synthesize index;
@synthesize imagePickerController;
@synthesize displayItems;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    dbManager = [DBManager sharedSingleton];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void) viewWillAppear: (BOOL)animated {
    [super viewWillAppear:YES];
    
    [detailTableView reloadData];
    
    patient = [displayItems objectAtIndex:index];
    
    NSString *name = patient.firstName;
    name = [name stringByAppendingFormat:@" %@", patient.lastName];
    
    patientName.text = name;
    
    imageView.image = patient.imageName;
}

- (IBAction)takePhoto:(id)sender {
    
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
    
    patient.imageName = image;
    
    self.imageView.image = patient.imageName;
    
    [self saveImageToDB:patient forImage: image];
    
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

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 2;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return 1;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    switch (indexPath.section) {
        case 0:
        {
            static NSString *simpleTableIdentifier = @"CityDetails";
            
            UITableViewCell *city = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (city == nil) {
                city = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *cityLabel = @"City: ";
            cityLabel = [cityLabel stringByAppendingFormat:@" %@", patient.city];
            
            city.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            city.textLabel.text = cityLabel;
            
            return city;
        }
        case 1:
        {
            static NSString *simpleTableIdentifier = @"StateDetails";
            
            UITableViewCell *state = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (state == nil) {
                state = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *stateLabel = @"State: ";
            stateLabel = [stateLabel stringByAppendingFormat:@" %@", patient.state];
            
            state.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            state.textLabel.text = stateLabel;
            
            return state;
        }
        default:
            break;
    }
    return 0;
}

- (void) saveImageToDB: (Patient *) p forImage: (UIImage *) image{
    
    NSString *filePath = [dbManager getWritableDBPath];
    
    sqlite3 *database;
    //NSString * theU=self.hospitalName.text;
    
    if(sqlite3_open([filePath UTF8String], &database) == SQLITE_OK) {
        
        const char *sqlStatement = "UPDATE Person SET Image = ? where firstName = ? and lastName = ?";
        
        sqlite3_stmt *compiledStatement;
        
        if(sqlite3_prepare_v2(database, sqlStatement, -1, &compiledStatement, NULL) == SQLITE_OK)    {
            
            NSData* data = UIImagePNGRepresentation(image);
            
            sqlite3_bind_blob(compiledStatement, 1, [data bytes], [data length], SQLITE_TRANSIENT);
            sqlite3_bind_text( compiledStatement, 2,[p.firstName UTF8String], -1, SQLITE_TRANSIENT);
            sqlite3_bind_text( compiledStatement, 3,[p.lastName UTF8String], -1, SQLITE_TRANSIENT);
        }
        
        if(sqlite3_step(compiledStatement) != SQLITE_DONE ) {
            NSLog( @"Save Error: %s", sqlite3_errmsg(database) );
        }
        
        sqlite3_finalize(compiledStatement);
    }
    
    sqlite3_close(database);
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
