//
//  PatientDetailView.m
//  Assignment 6
//
//  Created by Hari Panjwani on 3/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "PatientDetailView.h"

@interface PatientDetailView ()

@end

@implementation PatientDetailView

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
    return 7;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return 1;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    switch (indexPath.section) {
        case 0:
        {
            static NSString *simpleTableIdentifier = @"PhoneNumberDetail";
            
            UITableViewCell *contact = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (contact == nil) {
                contact = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *contactLabel = @"Contact: ";
            contactLabel = [contactLabel stringByAppendingFormat:@" %ld", patient.phoneNumber];
            
            contact.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            contact.textLabel.text = contactLabel;

            return contact;
        }
        case 1:
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
        case 2:
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
        case 3:
        {
            static NSString *simpleTableIdentifier = @"ZipCodeDetail";
            
            UITableViewCell *zip = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (zip == nil) {
                zip = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *zipcode = @"Zip Code: ";
            zipcode = [zipcode stringByAppendingFormat:@" %d", patient.zipCode];

            zip.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            zip.textLabel.text = zipcode;
            
            return zip;
        }
        case 4:
        {
            static NSString *simpleTableIdentifier = @"DateOfBirthDetails";
            
            UITableViewCell *dob = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (dob == nil) {
                dob = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *date = [patient.dob description];
            
            NSString *dateLabel = @"Date of Birth: ";
            dateLabel = [dateLabel stringByAppendingFormat:@"%@", date];
            
            dob.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            dob.textLabel.text = dateLabel;
            
            return dob;
        }
        case 5:
        {
            static NSString *simpleTableIdentifier = @"PrimaryPhysicianDetails";
            
            UITableViewCell *primaryPhysician = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (primaryPhysician == nil) {
                primaryPhysician = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *phyLabel = @"Primary Physician: ";
            phyLabel = [phyLabel stringByAppendingFormat:@"%@", patient.primaryPhysician];
            
            primaryPhysician.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            primaryPhysician.textLabel.text = phyLabel;
            
            return primaryPhysician;
        }
        case 6:
        {
            static NSString *simpleTableIdentifier = @"SSNDetails";
            
            UITableViewCell *ssn = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
            
            if (ssn == nil) {
                ssn = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:simpleTableIdentifier];
            }
            
            NSString *ssnLabel = @"SSN: ";
            ssnLabel = [ssnLabel stringByAppendingFormat:@"%d", patient.ssn];
            
            ssn.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            ssn.textLabel.text = ssnLabel;
            
            return ssn;
        }
        default:
            break;
    }
    return 0;
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

@end
