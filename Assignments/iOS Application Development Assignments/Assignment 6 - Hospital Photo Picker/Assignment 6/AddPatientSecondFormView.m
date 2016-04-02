//
//  AddPatientSecondFormView.m
//  Assignment 6
//
//  Created by Hari Panjwani on 3/16/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "AddPatientSecondFormView.h"

@interface AddPatientSecondFormView ()

@end

@implementation AddPatientSecondFormView

@synthesize tap;
@synthesize patientListView;
@synthesize captureImages;


- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    self.tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];
    
    self.zipCodeText.delegate = self;
    self.contactNumberText.delegate = self;
    self.ssnText.delegate = self;
    self.primaryPhysicianText.delegate = self;
}

-(BOOL) textFieldShouldReturn: (UITextField *) textField {
    [textField resignFirstResponder];
    return YES;
}

-(void)keyboardWillShow {
    // Animate the current view out of the way
    if (self.view.frame.origin.y >= 0)
    {
        [self setViewMovedUp:NO];
    }
    else if (self.view.frame.origin.y > -70 & self.view.frame.origin.y < -5e0)
    {
        [self setViewMovedUp:YES];
    }
}

-(void)keyboardWillHide {
    if (self.view.frame.origin.y >= 100)
    {
        [self setViewMovedUp:YES];
    }
    else if (self.view.frame.origin.y < 0)
    {
        [self setViewMovedUp:NO];
    }
}

-(void)textFieldDidBeginEditing:(UITextField *)sender
{
    //if ([sender isEqual:mailTf])
    //{
    //move the main view, so that the keyboard does not hide it.
    if  (self.view.frame.origin.y >= 0)
    {
        [self setViewMovedUp:YES];
    }
    //}
}

//method to move the view up/down whenever the keyboard is shown/dismissed
-(void)setViewMovedUp:(BOOL)movedUp
{
    [UIView beginAnimations:nil context:NULL];
    [UIView setAnimationDuration:0.3]; // if you want to slide up the view
    
    CGRect rect = self.view.frame;
    if (movedUp)
    {
        // 1. move the view's origin up so that the text field that will be hidden come above the keyboard
        // 2. increase the size of the view so that the area behind the keyboard is covered up.
        rect.origin.y -= kOFFSET_FOR_KEYBOARD;
        rect.size.height += kOFFSET_FOR_KEYBOARD;
    }
    else
    {
        // revert back to the normal state.
        rect.origin.y += kOFFSET_FOR_KEYBOARD;
        rect.size.height -= kOFFSET_FOR_KEYBOARD;
    }
    self.view.frame = rect;
    
    [UIView commitAnimations];
}


- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    // register for keyboard notifications
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(keyboardWillShow)
                                                 name:UIKeyboardWillShowNotification
                                               object:nil];
    
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(keyboardWillHide)
                                                 name:UIKeyboardWillHideNotification
                                               object:nil];
}

- (PatientListView *) patientListView {
    
    if(!patientListView) {
        patientListView = [[PatientListView alloc] initWithNibName:nil bundle: nil];
        patientListView.title = @"All Patients";
    }
    return patientListView;
}

- (IBAction)submit:(id)sender {
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    NSString *rawZipCode = self.zipCodeText.text;
    NSString *trimmedZipCode = [rawZipCode stringByTrimmingCharactersInSet:whitespace];
    
    NSString *rawContact = self.contactNumberText.text;
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
    Patient *p = [[Patient alloc] init];
    
    p.firstName = self.firstName;
    p.lastName = self.lastName;
    p.city = self.city;
    p.state = self.state;
    p.zipCode = [self.zipCodeText.text intValue];
    p.phoneNumber = [self.contactNumberText.text longLongValue];
    p.dob = self.dobPicker.date;    
    p.ssn = [self.ssnText.text intValue];
    p.primaryPhysician = self.primaryPhysicianText.text;
    p.imageName = self.imageName;
    
    [self.hospital addPatient:p];
    self.patientListView.hospital = self.hospital;
    [self.navigationController pushViewController:self.patientListView animated:YES];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentPath = [paths objectAtIndex:0];
    NSString *filePath = [documentPath stringByAppendingPathComponent:@"assignment6.txt"];
    
    NSMutableData *data = [NSMutableData data];
    NSKeyedArchiver *archiver = [[NSKeyedArchiver alloc] initForWritingWithMutableData:data];
    [archiver encodeObject:self.hospital forKey:@"hospital"];
    [archiver finishEncoding];
    
    NSURL *archiveURL = [[NSURL alloc] initFileURLWithPath:filePath];
    BOOL result = [data writeToURL:archiveURL atomically:YES];
    
    if(result) {
        
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Added Successfully"
        message:[p.firstName stringByAppendingString:@" has been successfully added to the database!"]preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
    }
    }

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

//  Dismiss the keyboard on tap out
-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

@end
