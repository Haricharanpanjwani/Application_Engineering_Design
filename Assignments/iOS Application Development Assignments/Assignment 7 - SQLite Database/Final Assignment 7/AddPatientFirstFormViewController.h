//
//  AddPatientFirstFormViewController.h
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CoreDataEngine.h"
#import "PatientsView.h"
#import "Hospital.h"
#import "DBManager.h"

@interface AddPatientFirstFormViewController : UIViewController<UIImagePickerControllerDelegate, UINavigationControllerDelegate, UITextFieldDelegate, UITextViewDelegate>

@property (strong, nonatomic) UITapGestureRecognizer *tap;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *doneButton;

@property Hospital *hospital;

@property Patient *patient;

@property (weak, nonatomic) IBOutlet UIImageView *imageView;

@property (weak, nonatomic) IBOutlet UIButton *insertButton;

@property (weak, nonatomic) IBOutlet UIButton *saveButton;

@property (weak, nonatomic) IBOutlet UITextField *firstNameText;

@property (weak, nonatomic) IBOutlet UITextField *lastNameText;

@property (weak, nonatomic) IBOutlet UITextField *cityText;

@property (weak, nonatomic) IBOutlet UITextField *stateText;

@property (nonatomic) UIImagePickerController *imagePickerController;

- (IBAction)insertImage:(id)sender;

- (IBAction)save:(id)sender;

- (void) savePatientToDB:(Patient *)patient;

@end
