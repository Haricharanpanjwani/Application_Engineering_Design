//
//  AddPatientFirstFormViewController.m
//  Assignment 6
//
//  Created by Hari Panjwani on 3/16/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "AddPatientFirstFormViewController.h"

@interface AddPatientFirstFormViewController ()

@end

@implementation AddPatientFirstFormViewController

@synthesize tap;
@synthesize addPatientSecondView;
@synthesize imageView;
@synthesize insertImageButton;
@synthesize capturedImages;

- (void)viewDidLoad {
    [super viewDidLoad];
    capturedImages = [[NSMutableArray alloc] init];
    // Do any additional setup after loading the view from its nib.
    
    self.tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];
    
    self.firstNameText.delegate = self;
    self.lastNameText.delegate = self;
    self.cityText.delegate = self;
    self.stateText.delegate = self;
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
    else if (self.view.frame.origin.y > -100 & self.view.frame.origin.y < 100)
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


- (AddPatientSecondFormView *) addPatientSecondView {
    
    if(!addPatientSecondView) {
        addPatientSecondView = [[AddPatientSecondFormView alloc] initWithNibName:nil bundle: nil];
        addPatientSecondView.title = @"PATIENT SECOND FORM";
    }
    return addPatientSecondView;
}


- (IBAction)addPatientSecondForm:(id)sender {
    
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
    else
    {
    
    self.addPatientSecondView.hospital = self.hospital;
    
    self.addPatientSecondView.firstName = self.firstNameText.text;
    self.addPatientSecondView.lastName = self.lastNameText.text;
    self.addPatientSecondView.city = self.cityText.text;
    self.addPatientSecondView.state = self.stateText.text;
    self.addPatientSecondView.imageName = self.imageView.image;
    
    [self.navigationController pushViewController:self.addPatientSecondView animated:NO];
    }
}

- (IBAction)insertImage:(id)sender {
    
    UIImagePickerController *imagePicker = [[UIImagePickerController alloc] init];
    imagePicker.modalPresentationStyle = UIModalPresentationCurrentContext;
    imagePicker.sourceType = UIImagePickerControllerSourceTypePhotoLibrary;
    imagePicker.delegate = self;
    
    self.imagePickerController = imagePicker;
    [self presentViewController:self.imagePickerController animated:YES completion:nil];
    
    
    // Show image picker
    //[self presentViewController:imagePicker animated:YES completion:nil];
    //        UIImage *image = [NSDictionary objectForKey:@"UIImagePickerControllerOriginalImage"];
    //
    //        // Save image
    //        UIImageWriteToSavedPhotosAlbum(image, self, @selector(image:didFinishSavingWithError:contextInfo:), nil);
}

- (void) imagePickerController:(UIImagePickerController *)picker didFinishPickingMediaWithInfo:(NSDictionary *)info
{
    // Access the uncropped image from info dictionary 
    UIImage *image = [info objectForKey:@"UIImagePickerControllerOriginalImage"];
    
    [self.capturedImages removeAllObjects];
    [self.capturedImages addObject:image];
    
    [self.imageView setImage:[self.capturedImages objectAtIndex:0]];
    
    insertImageButton.enabled = NO;
    
    
    //    UIAlertController *alert = [UIAlertController alertControllerWithTitle:@"Error" message:@"Image saved to Photo Photo Album." preferredStyle:UIAlertControllerStyleAlert];
    //
    //    UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:
    //                                    UIAlertActionStyleDefault handler:^(UIAlertAction * action) {}];
    //
    //    [alert addAction:defaultAction];
    //    [self presentViewController:alert animated:YES completion:nil];
    
    //Save image
    //UIImageWriteToSavedPhotosAlbum(image, self, @selector(image:didFinishSavingWithError:contextInfo:), nil);
    
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


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

//  Dismiss the keyboard on tap out
-(void)dismissKeyboard {
    [self.view endEditing:YES];
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
