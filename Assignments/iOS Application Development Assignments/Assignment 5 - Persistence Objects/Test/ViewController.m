//
//  ViewController.m
//  Test
//
//  Created by Hari Panjwani on 2/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize hospital;

@synthesize tap;

@synthesize addButton;
@synthesize searchButton;
@synthesize listButton;
@synthesize addRecordButton;
@synthesize quitButton;
@synthesize nextButton;
@synthesize backButton;
@synthesize submitButton;
@synthesize secondBackButton;
@synthesize searchSearchButton;
@synthesize backSearchButton;
@synthesize backSearchResultButton;
@synthesize backListButton;
@synthesize backRecordButton;
@synthesize searchRecordButton;

@synthesize addPatientFirstView;
@synthesize addPatientSecondView;
@synthesize searchPatientView;
@synthesize patientListView;
@synthesize addMedicalRecordView;
@synthesize vitalSignView;
@synthesize searchResultView;
@synthesize viewMedicalRecordView;
@synthesize displayRecordView;

@synthesize firstNameText;
@synthesize lastNameText;
@synthesize streetNumText;
@synthesize streetNameText;
@synthesize cityText;
@synthesize stateText;
@synthesize zipCodeText;
@synthesize contactNumText;
@synthesize dobPicker;
@synthesize ssnText;
@synthesize primaryPhysicianText;

//add medical record label, searched patient
@synthesize addFirstName;
@synthesize dob;

@synthesize searchText;
@synthesize patientSearchText;

@synthesize respRateText;
@synthesize heartRateText;
@synthesize bpRateText;
@synthesize pulseRateText;
@synthesize weightText;
@synthesize prescriptionText;


- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.    
    
    hospital = nil;
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentPath = [paths objectAtIndex:0];
    NSString *filePath = [documentPath stringByAppendingPathComponent:@"list.txt"];
    NSURL *fileURL = [[NSURL alloc] initFileURLWithPath:filePath];
    
    NSData *data = [NSData dataWithContentsOfURL:fileURL];
    
    if(data) {
    
        NSKeyedUnarchiver *unarchiver = [[NSKeyedUnarchiver alloc] initForReadingWithData:data];
        // Customize the unarchiver.
        hospital = [unarchiver decodeObjectForKey:@"hospital"];
        [unarchiver finishDecoding];
    }
    else {
        hospital = [[Hospital alloc] init];
    }
    
    self.tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];

    //Create Add Patient Button
    self.addButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.addButton.frame= CGRectMake(85, 60, 200, 60);
    [self.addButton setBackgroundColor:[UIColor whiteColor]];
    [self.addButton setTitle:@"ADD PATIENT" forState:UIControlStateNormal];
    [self.addButton addTarget:self action:@selector(addPatientFirstForm) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:self.addButton];
    
    //Create Search Patient Button
    self.searchButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.searchButton.frame= CGRectMake(85, 140, 200, 60);
    [self.searchButton setBackgroundColor:[UIColor whiteColor]];
    [self.searchButton setTitle:@"SEARCH PATIENT" forState:UIControlStateNormal];
    [self.searchButton addTarget:self action:@selector(searchPatientForm) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:self.searchButton];

    //Create List of Patient Button
    self.listButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.listButton.frame= CGRectMake(85, 220, 200, 60);
    [self.listButton setBackgroundColor:[UIColor whiteColor]];
    [self.listButton setTitle:@"LIST OF PATIENTS" forState:UIControlStateNormal];
    [self.listButton addTarget:self action:@selector(listPatientForm) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:self.listButton];
    
    //Create Add Medical Record for Patient Button
    self.addRecordButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.addRecordButton.frame= CGRectMake(85, 300, 200, 60);
    [self.addRecordButton setBackgroundColor:[UIColor whiteColor]];
    [self.addRecordButton setTitle:@"ADD MEDICAL RECORD" forState:UIControlStateNormal];
    [self.addRecordButton addTarget:self action:@selector(addRecordForm) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:self.addRecordButton];
    
    //  Create View Medical Record Button
    self.viewRecordButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.viewRecordButton.frame= CGRectMake(85, 380, 200, 60);
    [self.viewRecordButton setBackgroundColor:[UIColor whiteColor]];
    [self.viewRecordButton setTitle:@"VIEW MEDICAL RECORD" forState:UIControlStateNormal];
    [self.viewRecordButton addTarget:self action:@selector(viewRecordForm) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:self.viewRecordButton];
    
    //Create Quit Patient Button
    self.quitButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.quitButton.frame= CGRectMake(85, 460, 200, 60);
    [self.quitButton setBackgroundColor:[UIColor whiteColor]];
    [self.quitButton setTitle:@"QUIT" forState:UIControlStateNormal];
    [self.quitButton addTarget:self action:@selector(handleExit) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:self.quitButton];
}


//  Dismiss the keyboard on tap out
-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

//  Exiting the application on pressing quit button
- (void) handleExit
{
    [self.view removeFromSuperview];
    exit(0);
}

//Adding Patient First Form View
- (void) addPatientFirstForm
{

    self.addPatientFirstView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.addPatientFirstView setBackgroundColor:[UIColor greenColor]];
    
    // Create First Name Label
    UILabel *firstName = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 200, 30)];
    [firstName setText:@"First Name"];
    [firstName setTextColor:[UIColor blackColor]];
    [firstName setBackgroundColor:[UIColor clearColor]];
    [self.addPatientFirstView addSubview:firstName];

    // Create Text Field for first name
    self.firstNameText = [[UITextField alloc] initWithFrame:CGRectMake(40, 70, 250.0, 30)];
    self.firstNameText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.firstNameText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.firstNameText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.firstNameText.borderStyle = UITextBorderStyleRoundedRect;
    self.firstNameText.keyboardType = UIKeyboardTypeASCIICapable;
    self.firstNameText.text=@"";
    [self.addPatientFirstView addSubview:firstNameText];
    
    // Create Last Name Label
    UILabel *lastName = [[UILabel alloc]initWithFrame:CGRectMake(40, 110, 200, 30)];
    [lastName setText:@"Last Name"];
    [lastName setTextColor:[UIColor blackColor]];
    [lastName setBackgroundColor:[UIColor clearColor]];
    [self.addPatientFirstView addSubview:lastName];
    
    // Create Text Field for last name
    self.lastNameText = [[UITextField alloc] initWithFrame:CGRectMake(40, 140, 250.0, 30)];
    self.lastNameText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.lastNameText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.lastNameText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.lastNameText.borderStyle = UITextBorderStyleRoundedRect;
    self.lastNameText.text=@"";
    [self.addPatientFirstView addSubview:lastNameText];
    
    // Create Street Number Label
    UILabel *streetNum = [[UILabel alloc]initWithFrame:CGRectMake(40, 180, 200, 30)];
    [streetNum setText:@"Street Number"];
    [streetNum setTextColor:[UIColor blackColor]];
    [streetNum setBackgroundColor:[UIColor clearColor]];
    [self.addPatientFirstView addSubview:streetNum];
    
    // Create Text Field for street number
    self.streetNumText = [[UITextField alloc] initWithFrame:CGRectMake(40, 210, 250.0, 30)];
    self.streetNumText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.streetNumText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.streetNumText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.streetNumText.borderStyle = UITextBorderStyleRoundedRect;
    self.streetNumText.keyboardType = UIKeyboardTypeNumberPad;
    self.streetNumText.text=@"";
    [self.addPatientFirstView addSubview:streetNumText];
    
    // Create Street Name Label
    UILabel *streetName = [[UILabel alloc]initWithFrame:CGRectMake(40, 250, 200, 30)];
    [streetName setText:@"Street Name"];
    [streetName setTextColor:[UIColor blackColor]];
    [streetName setBackgroundColor:[UIColor clearColor]];
    [self.addPatientFirstView addSubview:streetName];
    
    // Create Text Field for street name
    self.streetNameText = [[UITextField alloc] initWithFrame:CGRectMake(40, 280, 250.0, 30)];
    self.streetNameText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.streetNameText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.streetNameText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.streetNameText.borderStyle = UITextBorderStyleRoundedRect;
    self.streetNameText.text=@"";
    [self.addPatientFirstView addSubview:streetNameText];
    
    // Create City Label
    UILabel *city = [[UILabel alloc]initWithFrame:CGRectMake(40, 320, 200, 30)];
    [city setText:@"City"];
    [city setTextColor:[UIColor blackColor]];
    [city setBackgroundColor:[UIColor clearColor]];
    [self.addPatientFirstView addSubview:city];
    
    // Create Text Field for city
    self.cityText = [[UITextField alloc] initWithFrame:CGRectMake(40, 350, 250.0, 30)];
    self.cityText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.cityText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.cityText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.cityText.borderStyle = UITextBorderStyleRoundedRect;
    self.cityText.text=@"";
    [self.addPatientFirstView addSubview:cityText];
    
    // Create State Label
    UILabel *state = [[UILabel alloc]initWithFrame:CGRectMake(40, 390, 200, 30)];
    [state setText:@"State"];
    [state setTextColor:[UIColor blackColor]];
    [state setBackgroundColor:[UIColor clearColor]];
    [self.addPatientFirstView addSubview:state];
    
    // Create Text Field for state
    self.stateText = [[UITextField alloc] initWithFrame:CGRectMake(40, 430, 250.0, 30)];
    self.stateText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.stateText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.stateText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.stateText.borderStyle = UITextBorderStyleRoundedRect;
    self.stateText.text=@"";
    [self.addPatientFirstView addSubview:stateText];
    
    
    //Create Next Button to go to previous form
    self.nextButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.nextButton.frame= CGRectMake(70, 480, 200, 40);
    [self.nextButton setBackgroundColor:[UIColor whiteColor]];
    [self.nextButton setTitle:@"NEXT" forState:UIControlStateNormal];
    [self.nextButton addTarget:self action:@selector(addPatientSecondForm) forControlEvents:UIControlEventTouchUpInside];
    [self.addPatientFirstView addSubview:self.nextButton];
    
    //Create Back Button to go to previous form
    self.backButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backButton.frame= CGRectMake(70, 540, 200, 40);
    [self.backButton setBackgroundColor:[UIColor whiteColor]];
    [self.backButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backButton addTarget:self action:@selector(quitFirstForm) forControlEvents:UIControlEventTouchUpInside];
    [self.addPatientFirstView addSubview:self.backButton];
    
    [self.view addSubview:self.addPatientFirstView];
}

- (void)changeDateInLabel:(id)sender{
    //Use NSDateFormatter to write out the date in a friendly format
    NSDateFormatter *df = [[NSDateFormatter alloc] init];
    df.dateStyle = NSDateFormatterMediumStyle;
    dob.text = [NSString stringWithFormat:@"%@",
                  [df stringFromDate:self.dobPicker.date]];
}

// going back to the to the list of options view
- (void)quitFirstForm {
    [self.addPatientFirstView removeFromSuperview];
}

//  Second Page for the Adding the Patient View
-(void)addPatientSecondForm {
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    NSString *rawFirstName = self.firstNameText.text;
    NSString *trimmedFirstName = [rawFirstName stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawLastName = self.lastNameText.text;
    NSString *trimmedLastName = [rawLastName stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawStreetNum = self.streetNumText.text;
    NSString *trimmedStreetNum = [rawStreetNum stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawStreetName = self.streetNameText.text;
    NSString *trimmedStreetName = [rawStreetName stringByTrimmingCharactersInSet:whitespace];
    
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
    else if (!([trimmedStreetNum length] > 0) || [trimmedStreetNum isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"Street Number Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedStreetName length] > 0) || [trimmedStreetName isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"Street Name Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
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
    else
    {
    self.addPatientSecondView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.addPatientSecondView setBackgroundColor:[UIColor greenColor]];
    
    // Create Zip Code Label
    UILabel *zipCode = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 200, 30)];
    [zipCode setText:@"Zip Code"];
    [zipCode setTextColor:[UIColor blackColor]];
    [zipCode setBackgroundColor:[UIColor clearColor]];
    [self.addPatientSecondView addSubview:zipCode];
    
    // Create Text Field for zip code
    self.zipCodeText = [[UITextField alloc] initWithFrame:CGRectMake(40, 70, 250.0, 30)];
    self.zipCodeText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.zipCodeText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.zipCodeText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.zipCodeText.borderStyle = UITextBorderStyleRoundedRect;
    self.zipCodeText.keyboardType = UIKeyboardTypeNumberPad;
    self.zipCodeText.text=@"";
    [self.addPatientSecondView addSubview:zipCodeText];
    
    // Create Contact Number Label
    UILabel *contactNum = [[UILabel alloc]initWithFrame:CGRectMake(40, 110, 200, 30)];
    [contactNum setText:@"Contact Number"];
    [contactNum setTextColor:[UIColor blackColor]];
    [contactNum setBackgroundColor:[UIColor clearColor]];
    [self.addPatientSecondView addSubview:contactNum];
    
    // Create Text Field for contact number
    self.contactNumText = [[UITextField alloc] initWithFrame:CGRectMake(40, 140, 250.0, 30)];
    self.contactNumText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.contactNumText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.contactNumText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.contactNumText.borderStyle = UITextBorderStyleRoundedRect;
    self.contactNumText.keyboardType = UIKeyboardTypePhonePad;
    self.contactNumText.text=@"";
    [self.addPatientSecondView addSubview:contactNumText];
    
    // Create Date of birth Name Label
    self.dob = [[UILabel alloc]initWithFrame:CGRectMake(40, 180, 200, 30)];
    [self.dob setText:@"Date of Birth"];
    [self.dob setTextColor:[UIColor blackColor]];
    [self.dob setBackgroundColor:[UIColor clearColor]];
    [self.addPatientSecondView addSubview:dob];
    
    // Create Text Field for Date of Birth
    //    self.streetNameText = [[UITextField alloc] initWithFrame:CGRectMake(40, 340, 250.0, 30)];
    //    self.streetNameText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    //    self.streetNameText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    //    [self.streetNameText.layer setBorderColor:[UIColor grayColor].CGColor];
    //    self.streetNameText.borderStyle = UITextBorderStyleRoundedRect;
    //    self.streetNameText.text=@"";
    //    [self.addPatientView addSubview:streetNameText];
    
    //    NSDateFormatter *df = [[NSDateFormatter alloc] init];
    //    df.dateStyle = NSDateFormatterMediumStyle;
    //    //self.dob.text = [NSString stringWithFormat:@"%@",
    //      //            [df stringFromDate:[NSDate date]]];
    
    //dobSelector.keyboardType = self.dobPicker;
    self.dobPicker = [[UIDatePicker alloc] initWithFrame:CGRectMake(40, 240, 250.0, 100)];
    self.dobPicker.datePickerMode = UIDatePickerModeDate;
    self.dobPicker.hidden = NO;
    self.dobPicker.date = [NSDate date];
//    [self.dobPicker addTarget:self
//                       action:@selector(changeDateInLabel:)
//             forControlEvents:UIControlEventValueChanged];
    [self.addPatientSecondView addSubview:self.dobPicker];
    
    // Create SSN Label
    UILabel *ssn = [[UILabel alloc]initWithFrame:CGRectMake(40, 350, 200, 30)];
    [ssn setText:@"Social Security Number"];
    [ssn setTextColor:[UIColor blackColor]];
    [ssn setBackgroundColor:[UIColor clearColor]];
    [self.addPatientSecondView addSubview:ssn];
    
    // Create Text Field for ssn
    self.ssnText = [[UITextField alloc] initWithFrame:CGRectMake(40, 390, 250.0, 30)];
    self.ssnText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.ssnText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.ssnText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.ssnText.borderStyle = UITextBorderStyleRoundedRect;
    self.ssnText.keyboardType = UIKeyboardTypeNumberPad;
    self.ssnText.text=@"";
    [self.addPatientSecondView addSubview:ssnText];
    
    // Create Primary Physician Label
    UILabel *primaryPhys = [[UILabel alloc]initWithFrame:CGRectMake(40, 440, 200, 30)];
    [primaryPhys setText:@"Primary Physician"];
    [primaryPhys setTextColor:[UIColor blackColor]];
    [primaryPhys setBackgroundColor:[UIColor clearColor]];
    [self.addPatientSecondView addSubview:primaryPhys];
    
    // Create Text Field for Primary Physician
    self.primaryPhysicianText = [[UITextField alloc] initWithFrame:CGRectMake(40, 480, 250.0, 30)];
    self.primaryPhysicianText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.primaryPhysicianText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.primaryPhysicianText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.primaryPhysicianText.borderStyle = UITextBorderStyleRoundedRect;
    self.primaryPhysicianText.text=@"";
    [self.addPatientSecondView addSubview:primaryPhysicianText];
    
    //Create Next Button to go to previous form
    self.submitButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.submitButton.frame= CGRectMake(70, 520, 200, 40);
    [self.submitButton setBackgroundColor:[UIColor whiteColor]];
    [self.submitButton setTitle:@"SUBMIT" forState:UIControlStateNormal];
    [self.submitButton addTarget:self action:@selector(submitPatientForm) forControlEvents:UIControlEventTouchUpInside];
    [self.addPatientSecondView addSubview:self.submitButton];
    
    //Create Back Button to go to previous form
    self.secondBackButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.secondBackButton.frame= CGRectMake(70, 580, 200, 40);
    [self.secondBackButton setBackgroundColor:[UIColor whiteColor]];
    [self.secondBackButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.secondBackButton addTarget:self action:@selector(quitSecondForm) forControlEvents:UIControlEventTouchUpInside];
    [self.addPatientSecondView addSubview:self.secondBackButton];
    
    [self.addPatientFirstView addSubview:self.addPatientSecondView];
        
    }

}

// Submit the patient detais;
-(void) submitPatientForm {
 
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    NSString *rawZipCode = self.zipCodeText.text;
    NSString *trimmedZipCode = [rawZipCode stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawContact = self.contactNumText.text;
    NSString *trimmedContact = [rawContact stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawSSN = self.ssnText.text;
    NSString *trimmedSSN = [rawSSN stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawPhysician = self.primaryPhysicianText.text;
    NSString *trimmedPhysician = [rawPhysician stringByTrimmingCharactersInSet:whitespace];
    
    if (!([trimmedZipCode length] > 0) || [trimmedZipCode isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"Zip Code Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedContact length] > 0) || [trimmedContact isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"Contact Number Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedSSN length] > 0) || [trimmedSSN isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"SSN Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedPhysician length] > 0) || [trimmedPhysician isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                       message:@"Primary Physician name Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else
    {
    Patient *patient = [[Patient alloc] init];
    
    patient.firstName = self.firstNameText.text;
    patient.lastName = self.lastNameText.text;
    patient.streetNumber = [self.streetNumText.text intValue];
    patient.streetName = self.streetNameText.text;
    patient.city = self.cityText.text;
    patient.state = self.stateText.text;
    patient.zipCode = [self.zipCodeText.text intValue];
    patient.phoneNumber = [self.contactNumText.text longLongValue];
    patient.ssn = [self.ssnText.text intValue];
    patient.primaryPhysician = self.primaryPhysicianText.text;
    patient.dob = self.dobPicker.date;
    
    [hospital addPatient: patient];
        
        NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
        NSString *documentPath = [paths objectAtIndex:0];
        NSString *filePath = [documentPath stringByAppendingPathComponent:@"list.txt"];

        NSMutableData *data = [NSMutableData data];
        NSKeyedArchiver *archiver = [[NSKeyedArchiver alloc] initForWritingWithMutableData:data];
        [archiver encodeObject:hospital forKey:@"hospital"];
        [archiver finishEncoding];
        
        NSURL *archiveURL = [[NSURL alloc] initFileURLWithPath:filePath];
        BOOL result = [data writeToURL:archiveURL atomically:YES];
        
        if(result) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Added Successfully"
                message:[patient.firstName stringByAppendingString:@" has been successfully added to the database!"]preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
        
            [self.addPatientFirstView removeFromSuperview];
            [self.addPatientSecondView removeFromSuperview];
        }
    }
    
}

// going back to the to the first form
- (void)quitSecondForm {
    [self.addPatientSecondView removeFromSuperview];
}

//  Adding List of Patient Form to the View
// Giving the list of all patients who are available
-(void) listPatientForm {
    
    self.patientListView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.patientListView setBackgroundColor:[UIColor yellowColor]];
    
    // Displaying the list of Patient
    UILabel *label = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [label setText:@"List of Patient in the hospital are: "];
    [label setTextColor:[UIColor blackColor]];
    [label setBackgroundColor:[UIColor clearColor]];
    [self.patientListView addSubview:label];
    
    NSString *list;
    CGRect textViewFrame = CGRectMake(40, 80, 300, 500);
    UITextView *textView = [[UITextView alloc] initWithFrame:textViewFrame];
    
    for(Patient *p in hospital.patientList) {
            
        list = [p.firstName stringByAppendingString:@"\n \n"];
            
        textView.text = [textView.text stringByAppendingString:list];
        textView.editable = NO;
        textView.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
        [textView.layer setBorderColor:[UIColor grayColor].CGColor];
        [self.patientListView addSubview:textView];
    }
    
    //Create Back Button on search view
    self.backListButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backListButton.frame= CGRectMake(85, 600, 200, 40);;
    [self.backListButton setBackgroundColor:[UIColor whiteColor]];
    [self.backListButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backListButton addTarget:self action:@selector(quitPatientListForm) forControlEvents:UIControlEventTouchUpInside];
    [self.patientListView addSubview:self.backListButton];
    
    [self.view addSubview:patientListView];
}

-(void) quitPatientListForm {
    [self.patientListView removeFromSuperview];
}

//  Adding the Search Patient form to the View
-(void) searchPatientForm {

    self.searchPatientView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.searchPatientView setBackgroundColor:[UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0]];
    
    // Enter the Patient Name
    UILabel *search = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [search setText:@"Enter the Patient First or Last Name"];
    [search setTextColor:[UIColor colorWithRed:155/255.0 green:0/255.0 blue:0/255.0 alpha:1.0]];
    [search setBackgroundColor:[UIColor clearColor]];
    [self.searchPatientView addSubview:search];

    // Create Search Text Field for the name
    self.searchText = [[UISearchBar alloc] initWithFrame:CGRectMake(40, 80, 300, 60)];
    [self.searchText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.searchText.placeholder = @"Search";
    [self.searchPatientView addSubview:searchText];
    
    //Create Search Patient Button
    self.searchSearchButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.searchSearchButton.frame= CGRectMake(85, 160, 200, 60);
    [self.searchSearchButton setBackgroundColor:[UIColor whiteColor]];
    [self.searchSearchButton setTitle:@"SEARCH" forState:UIControlStateNormal];
    [self.searchSearchButton addTarget:self action:@selector(searchPatientFuc) forControlEvents:UIControlEventTouchUpInside];
    [self.searchPatientView addSubview:self.searchSearchButton];
    
    //Create Back Button on search view
    self.backSearchButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backSearchButton.frame= CGRectMake(85, 240, 200, 60);
    [self.backSearchButton setBackgroundColor:[UIColor whiteColor]];
    [self.backSearchButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backSearchButton addTarget:self action:@selector(quitSearchForm) forControlEvents:UIControlEventTouchUpInside];
    [self.searchPatientView addSubview:self.backSearchButton];
    
    [self.view addSubview:searchPatientView];
}


// Removing the searchPatientView from the View
-(void) quitSearchForm {

    [self.searchPatientView removeFromSuperview];
}

//  message which is calling the search patient method from hospital class
-(void) searchPatientFuc {
    
    NSString *search = searchText.text;
    Patient *searchedPatient = nil;
    
    searchedPatient = [self.hospital searchPatient: search];
    
    if(searchedPatient == nil) {
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"No Patient Found"                                                                       message:@"There is no patient with this description!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
    }
    else
    {
    // Creating View for displaying result
    self.searchResultView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.searchResultView setBackgroundColor:[UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0]];
    
    // Enter the Patient Name
    UILabel *lab = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [lab setText:@"Searched Patient details are: "];
    [lab setTextColor:[UIColor colorWithRed:155/255.0 green:0/255.0 blue:0/255.0 alpha:1.0]];
    [lab setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:lab];
    
    // Create Label Field for first name
    UILabel *searchFirstName = [[UILabel alloc]initWithFrame:CGRectMake(40, 80, 300, 30)];
    [searchFirstName setText:[@"First Name: " stringByAppendingString:searchedPatient.firstName]];
    [searchFirstName setTextColor:[UIColor whiteColor]];
    [searchFirstName setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchFirstName];
    
    // Create Label Field for last name
    UILabel *searchLastName = [[UILabel alloc]initWithFrame:CGRectMake(40, 120, 300, 30)];
    [searchLastName setText:[@"Last Name: " stringByAppendingString:searchedPatient.lastName]];
    [searchLastName setTextColor:[UIColor whiteColor]];
    [searchLastName setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchLastName];
    
    // Create Label Field for street number
    UILabel *searchStreet = [[UILabel alloc]initWithFrame:CGRectMake(40, 160, 300, 30)];
    NSString *street = [NSString stringWithFormat:@"%d", searchedPatient.streetNumber];
    [searchStreet setText:[@"Street Number: " stringByAppendingString:street]];
    [searchStreet setTextColor:[UIColor whiteColor]];
    [searchStreet setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchStreet];
    
    // Create Label Field for street name
    UILabel *searchStreetName = [[UILabel alloc]initWithFrame:CGRectMake(40, 200, 300, 30)];
    [searchStreetName setText:[@"Street Name: " stringByAppendingString:searchedPatient.streetName]];
    [searchStreetName setTextColor:[UIColor whiteColor]];
    [searchStreetName setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchStreetName];
    
    // Create Label Field for city
    UILabel *searchCity = [[UILabel alloc]initWithFrame:CGRectMake(40, 240, 300, 30)];
    [searchCity setText:[@"City: " stringByAppendingString:searchedPatient.city]];
    [searchCity setTextColor:[UIColor whiteColor]];
    [searchCity setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchCity];
    
    // Create Label Field for state
    UILabel *searchState = [[UILabel alloc]initWithFrame:CGRectMake(40, 280, 300, 30)];
    [searchState setText:[@"State: " stringByAppendingString:searchedPatient.state]];
    [searchState setTextColor:[UIColor whiteColor]];
    [searchState setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchState];

    // Create Label Field for Date of birth
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init];
    [formatter setDateFormat:@"MM/dd/yyyy"];
    NSString *date = [formatter stringFromDate:searchedPatient.dob];
    
    UILabel *searchDob = [[UILabel alloc]initWithFrame:CGRectMake(40, 320, 300, 30)];
    [searchDob setText:[@"Date of Birth: " stringByAppendingString:date]];
    [searchDob setTextColor:[UIColor whiteColor]];
    [searchDob setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchDob];
    
    // Create Label Field for contact
    UILabel *searchContact = [[UILabel alloc]initWithFrame:CGRectMake(40, 360, 300, 30)];
    NSString *contact = [NSString stringWithFormat:@"%ld", searchedPatient.phoneNumber];
    [searchContact setText:[@"Contact Number: " stringByAppendingString:contact]];
    [searchContact setTextColor:[UIColor whiteColor]];
    [searchContact setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchContact];
    
    // Create Label Field for primary physicina
    UILabel *searchPrimary = [[UILabel alloc]initWithFrame:CGRectMake(40, 400, 300, 30)];
    [searchPrimary setText:[@"Primary Phsyician: " stringByAppendingString:searchedPatient.primaryPhysician]];
    [searchPrimary setTextColor:[UIColor whiteColor]];
    [searchPrimary setBackgroundColor:[UIColor clearColor]];
    [self.searchResultView addSubview:searchPrimary];
    
    //Create Back Button on search view
    self.backSearchResultButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backSearchResultButton.frame= CGRectMake(85, 450, 200, 60);
    [self.backSearchResultButton setBackgroundColor:[UIColor whiteColor]];
    [self.backSearchResultButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backSearchResultButton addTarget:self action:@selector(quitSearchResultForm) forControlEvents:UIControlEventTouchUpInside];
    [self.searchResultView addSubview:self.backSearchResultButton];
    
    [self.view addSubview:searchResultView];
    }
    
}

// Removing the searchResultView form from the VIEW
-(void) quitSearchResultForm {
    
        [self.searchResultView removeFromSuperview];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


-(void) addRecordForm {
    
    self.addMedicalRecordView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.addMedicalRecordView setBackgroundColor:[UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0]];
    
    // Enter the Patient Name
    UILabel *search = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [search setText:@"Enter the Patient First or Last Name"];
    [search setTextColor:[UIColor colorWithRed:155/255.0 green:0/255.0 blue:0/255.0 alpha:1.0]];
    [search setBackgroundColor:[UIColor clearColor]];
    [self.addMedicalRecordView addSubview:search];
    
    // Create Search Text Field for the name
    self.patientSearchText = [[UISearchBar alloc] initWithFrame:CGRectMake(40, 80, 300, 60)];
    [self.patientSearchText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.patientSearchText.placeholder = @"Search";
    [self.addMedicalRecordView addSubview:patientSearchText];
    
    //Create Search Patient Button
    self.searchRecordButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.searchRecordButton.frame= CGRectMake(85, 160, 200, 60);
    [self.searchRecordButton setBackgroundColor:[UIColor whiteColor]];
    [self.searchRecordButton setTitle:@"SEARCH" forState:UIControlStateNormal];
    [self.searchRecordButton addTarget:self action:@selector(vitalSignForm) forControlEvents:UIControlEventTouchUpInside];
    [self.addMedicalRecordView addSubview:self.searchRecordButton];
    
    //Create Back Button on search view
    self.backRecordButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backRecordButton.frame= CGRectMake(85, 240, 200, 60);
    [self.backRecordButton setBackgroundColor:[UIColor whiteColor]];
    [self.backRecordButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backRecordButton addTarget:self action:@selector(quitRecordForm) forControlEvents:UIControlEventTouchUpInside];
    [self.addMedicalRecordView addSubview:self.backRecordButton];
    
    [self.view addSubview:addMedicalRecordView];
}

// Removing the AddMedicalRecord view from the View
-(void) quitRecordForm {
    
    [self.addMedicalRecordView removeFromSuperview];
}

// Form for displaying the vital Sign
-(void) vitalSignForm {
    
    NSString *search = patientSearchText.text;
    
    Patient *searchedPatient = nil;
    searchedPatient = [self.hospital searchPatient: search];
    
    if(searchedPatient == nil) {
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"No Patient Found"                                                                       message:@"There is no patient with this description!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
    }
    else
    {
    self.vitalSignView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.vitalSignView setBackgroundColor:[UIColor greenColor]];
    
    // storing the first name of the patient
    addFirstName = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [addFirstName setText:searchedPatient.firstName];
    [addFirstName setTextColor:[UIColor whiteColor]];
    [addFirstName setBackgroundColor:[UIColor clearColor]];
       
    // Create Label Field for displaying first name
    UILabel *searchFirstName = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [searchFirstName setText:[@"Name: " stringByAppendingString:searchedPatient.firstName]];
    [searchFirstName setTextColor:[UIColor whiteColor]];
    [searchFirstName setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:searchFirstName];
    
    // Create Label Field for displaying primary physician
    UILabel *searchPrimary = [[UILabel alloc]initWithFrame:CGRectMake(40, 80, 300, 30)];
    [searchPrimary setText:[@"Primary Phsyician: " stringByAppendingString:searchedPatient.primaryPhysician]];
    [searchPrimary setTextColor:[UIColor whiteColor]];
    [searchPrimary setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:searchPrimary];
    
    // Create Respiratory Rate Label
    UILabel *respRate = [[UILabel alloc]initWithFrame:CGRectMake(40, 120, 200, 30)];
    [respRate setText:@"Respiratory Rate"];
    [respRate setTextColor:[UIColor blackColor]];
    [respRate setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:respRate];
    
    // Create Text Field for respiratory rate
    self.respRateText = [[UITextField alloc] initWithFrame:CGRectMake(40, 150, 250.0, 30)];
    self.respRateText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.respRateText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.respRateText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.respRateText.borderStyle = UITextBorderStyleRoundedRect;
    self.respRateText.keyboardType = UIKeyboardTypeDecimalPad;
    self.respRateText.text=@"";
    [self.vitalSignView addSubview:respRateText];
    
    // Create Heart Rate Label
    UILabel *heartRate = [[UILabel alloc]initWithFrame:CGRectMake(40, 190, 200, 30)];
    [heartRate setText:@"Heart Rate"];
    [heartRate setTextColor:[UIColor blackColor]];
    [heartRate setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:heartRate];
    
    // Create Text Field for heart rate
    self.heartRateText = [[UITextField alloc] initWithFrame:CGRectMake(40, 220, 250.0, 30)];
    self.heartRateText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.heartRateText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.heartRateText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.heartRateText.borderStyle = UITextBorderStyleRoundedRect;
    self.heartRateText.keyboardType = UIKeyboardTypeDecimalPad;
    self.heartRateText.text=@"";
    [self.vitalSignView addSubview:heartRateText];

    // Create Blood Pressure Label
    UILabel *bp = [[UILabel alloc]initWithFrame:CGRectMake(40, 260, 200, 30)];
    [bp setText:@"Blood Pressure"];
    [bp setTextColor:[UIColor blackColor]];
    [bp setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:bp];
    
    // Create Text Field for blood pressure
    self.bpRateText = [[UITextField alloc] initWithFrame:CGRectMake(40, 290, 250.0, 30)];
    self.bpRateText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.bpRateText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.bpRateText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.bpRateText.borderStyle = UITextBorderStyleRoundedRect;
    self.bpRateText.keyboardType = UIKeyboardTypeDecimalPad;
    self.bpRateText.text=@"";
    [self.vitalSignView addSubview:bpRateText];
    
    // Create Pulse Label
    UILabel *pulse = [[UILabel alloc]initWithFrame:CGRectMake(40, 330, 200, 30)];
    [pulse setText:@"Pulse"];
    [pulse setTextColor:[UIColor blackColor]];
    [pulse setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:pulse];
    
    // Create Text Field for pulse
    self.pulseRateText = [[UITextField alloc] initWithFrame:CGRectMake(40, 360, 250.0, 30)];
    self.pulseRateText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.pulseRateText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.pulseRateText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.pulseRateText.borderStyle = UITextBorderStyleRoundedRect;
    self.pulseRateText.keyboardType = UIKeyboardTypeDecimalPad;
    self.pulseRateText.text=@"";
    [self.vitalSignView addSubview:pulseRateText];

    // Create Weight Label
    UILabel *weight = [[UILabel alloc]initWithFrame:CGRectMake(40, 400, 200, 30)];
    [weight setText:@"Weight"];
    [weight setTextColor:[UIColor blackColor]];
    [weight setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:weight];
    
    // Create Text Field for weight
    self.weightText = [[UITextField alloc] initWithFrame:CGRectMake(40, 430, 250.0, 30)];
    self.weightText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.weightText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.weightText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.weightText.borderStyle = UITextBorderStyleRoundedRect;
    self.weightText.keyboardType = UIKeyboardTypeDecimalPad;
    self.weightText.text=@"";
    [self.vitalSignView addSubview:weightText];

    // Create prescription Label
    UILabel *prescription = [[UILabel alloc]initWithFrame:CGRectMake(40, 470, 200, 30)];
    [prescription setText:@"Prescription"];
    [prescription setTextColor:[UIColor blackColor]];
    [prescription setBackgroundColor:[UIColor clearColor]];
    [self.vitalSignView addSubview:prescription];
    
    // Create Text Field for prescription
    self.prescriptionText = [[UITextField alloc] initWithFrame:CGRectMake(40, 500, 250.0, 30)];
    self.prescriptionText.textColor = [UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0];
    self.prescriptionText.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
    [self.prescriptionText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.prescriptionText.borderStyle = UITextBorderStyleRoundedRect;
    self.prescriptionText.keyboardType = UIKeyboardTypeASCIICapable;
    self.prescriptionText.text=@"";
    [self.vitalSignView addSubview:prescriptionText];
    
    //Create Next Button to go to previous form
    self.nextButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.nextButton.frame= CGRectMake(70, 550, 200, 40);
    [self.nextButton setBackgroundColor:[UIColor whiteColor]];
    [self.nextButton setTitle:@"ADD" forState:UIControlStateNormal];
    [self.nextButton addTarget:self action:@selector(addMedicalRecord) forControlEvents:UIControlEventTouchUpInside];
    [self.vitalSignView addSubview:self.nextButton];
    
    //Create Back Button to go to previous form
    self.backButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backButton.frame= CGRectMake(70, 610, 200, 40);
    [self.backButton setBackgroundColor:[UIColor whiteColor]];
    [self.backButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backButton addTarget:self action:@selector(quitVitalSignForm) forControlEvents:UIControlEventTouchUpInside];
    [self.vitalSignView addSubview:self.backButton];
        
    [self.addMedicalRecordView addSubview:vitalSignView];
        
    }
}

// Adding the medical record to the the patient array list of medical record
-(void) addMedicalRecord {
    
    NSString *name = self.addFirstName.text;
    
    Patient *patient = [self.hospital searchPatient:name];
    
    // Empty Field Validations
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];

    NSString *rawRespRate = self.respRateText.text;
    NSString *trimmedRespRate = [rawRespRate stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawHeartRate = self.heartRateText.text;
    NSString *trimmedHeartRate = [rawHeartRate stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawBp = self.bpRateText.text;
    NSString *trimmedBp = [rawBp stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawPulse = self.pulseRateText.text;
    NSString *trimmedPulse = [rawPulse stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawWeight = self.weightText.text;
    NSString *trimmedWeight = [rawWeight stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawPrescription = self.prescriptionText.text;
    NSString *trimmedPrescription = [rawPrescription stringByTrimmingCharactersInSet:whitespace];
    
    if (!([trimmedRespRate length] > 0) || [trimmedRespRate isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                        message:@"Respiratory rate Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedHeartRate length] > 0) || [trimmedHeartRate isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                    message:@"Heart Rate Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedBp length] > 0) || [trimmedBp isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                message:@"Blood Pressure Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedPulse length] > 0) || [trimmedPulse isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                        message:@"Pulse Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedWeight length] > 0) || [trimmedWeight isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                            message:@"Weight Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else if (!([trimmedPrescription length] > 0) || [trimmedPrescription isEqual:@""] == TRUE) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                        message:@"Prescription Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else
    {
    [self.addMedicalRecordView removeFromSuperview];
    [self.vitalSignView removeFromSuperview];
    
    MedicalRecord *record = [[MedicalRecord alloc] init];
    
    record.respRate = [self.respRateText.text floatValue];
    record.heartRate = [self.heartRateText.text floatValue];
    record.bp = [self.bpRateText.text floatValue];
    record.pulse = [self.pulseRateText.text intValue];
    record.weight = [self.weightText.text floatValue];
    record.prescription = self.prescriptionText.text;
    
    [patient.medicalRecord addObject:record];
    
    UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Added Successfully"
        message:[patient.firstName stringByAppendingString:@"'s medical Record has been successfully added to the database!"] preferredStyle:UIAlertControllerStyleAlert];
    
    UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                          handler:^(UIAlertAction * action) {}];
    [alert addAction:defaultAction];
    [self presentViewController:alert animated:YES completion:nil];
    
    [self.addMedicalRecordView removeFromSuperview];
    [self.vitalSignView removeFromSuperview];
    }
}

// Quit the form for Vital Sign from the View
-(void) quitVitalSignForm {
    [self.vitalSignView removeFromSuperview];
}

-(void) viewRecordForm {
    
    self.viewMedicalRecordView = [[UIView alloc] initWithFrame:self.view.bounds];
    [self.viewMedicalRecordView setBackgroundColor:[UIColor colorWithRed:0/255.0 green:84/255.0 blue:129/255.0 alpha:1.0]];
    
    // Enter the Patient Name
    UILabel *search = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
    [search setText:@"Enter the Patient First or Last Name"];
    [search setTextColor:[UIColor colorWithRed:155/255.0 green:0/255.0 blue:0/255.0 alpha:1.0]];
    [search setBackgroundColor:[UIColor clearColor]];
    [self.viewMedicalRecordView addSubview:search];
    
    // Create Search Text Field for the name
    self.patientSearchText = [[UISearchBar alloc] initWithFrame:CGRectMake(40, 80, 300, 60)];
    [self.patientSearchText.layer setBorderColor:[UIColor grayColor].CGColor];
    self.patientSearchText.placeholder = @"Search";
    [self.viewMedicalRecordView addSubview:patientSearchText];
    
    //Create Search Patient Button
    self.searchRecordButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.searchRecordButton.frame= CGRectMake(85, 160, 200, 60);
    [self.searchRecordButton setBackgroundColor:[UIColor whiteColor]];
    [self.searchRecordButton setTitle:@"SEARCH" forState:UIControlStateNormal];
    [self.searchRecordButton addTarget:self action:@selector(vitalSignDisplay) forControlEvents:UIControlEventTouchUpInside];
    [self.viewMedicalRecordView addSubview:self.searchRecordButton];
    
    //Create Back Button on search view
    self.backRecordButton=[UIButton buttonWithType:UIButtonTypeRoundedRect];
    self.backRecordButton.frame= CGRectMake(85, 240, 200, 60);
    [self.backRecordButton setBackgroundColor:[UIColor whiteColor]];
    [self.backRecordButton setTitle:@"BACK" forState:UIControlStateNormal];
    [self.backRecordButton addTarget:self action:@selector(quitDisplayForm) forControlEvents:UIControlEventTouchUpInside];
    [self.viewMedicalRecordView addSubview:self.backRecordButton];
    
    [self.view addSubview:viewMedicalRecordView];
    
}

-(void) vitalSignDisplay {
    
    NSString *search = patientSearchText.text;
    
    Patient *searchedPatient = nil;
    searchedPatient = [self.hospital searchPatient: search];
    
    if(searchedPatient == nil) {
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"No Patient Found"                                                                       message:@"There is no patient with this description!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
    }
    else
    {
        self.displayRecordView = [[UIView alloc] initWithFrame:self.view.bounds];
        [self.displayRecordView setBackgroundColor:[UIColor greenColor]];
        
        // storing the first name of the patient
        addFirstName = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
        [addFirstName setText:searchedPatient.firstName];
        [addFirstName setTextColor:[UIColor whiteColor]];
        [addFirstName setBackgroundColor:[UIColor clearColor]];
        
        // Create Label Field for displaying first name
        UILabel *searchFirstName = [[UILabel alloc]initWithFrame:CGRectMake(40, 40, 300, 30)];
        [searchFirstName setText:[@"Name: " stringByAppendingString:searchedPatient.firstName]];
        [searchFirstName setTextColor:[UIColor whiteColor]];
        [searchFirstName setBackgroundColor:[UIColor clearColor]];
        [self.displayRecordView addSubview:searchFirstName];
        
        // Create Label Field for displaying primary physician
        UILabel *searchPrimary = [[UILabel alloc]initWithFrame:CGRectMake(40, 80, 300, 30)];
        [searchPrimary setText:[@"Primary Phsyician: " stringByAppendingString:searchedPatient.primaryPhysician]];
        [searchPrimary setTextColor:[UIColor whiteColor]];
        [searchPrimary setBackgroundColor:[UIColor clearColor]];
        [self.displayRecordView addSubview:searchPrimary];
        
        NSString *list;
        CGRect textViewFrame = CGRectMake(40, 80, 300, 500);
        UITextView *textView = [[UITextView alloc] initWithFrame:textViewFrame];
        
        for(MedicalRecord *record in searchedPatient.medicalRecord) {
            
//            list = [searchedPatient.firstName stringByAppendingString:@"\n \n"];
//            
//            NSString *list = [NSString stringWithformat:@"%.3f", [[record.respRate] stringValue]];
//            
//            textView.text = [textView.text stringByAppendingString:[record.respRate stringValue]];
//            textView.editable = NO;
//            textView.font = [UIFont fontWithName:@"Helvetica-Bold" size:25];
//            [textView.layer setBorderColor:[UIColor grayColor].CGColor];
//            [self.patientListView addSubview:textView];
        }
        
        [self.viewMedicalRecordView addSubview:displayRecordView];
    }
    
}

-(void) quitDisplayForm {
    [self.viewMedicalRecordView removeFromSuperview];
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
