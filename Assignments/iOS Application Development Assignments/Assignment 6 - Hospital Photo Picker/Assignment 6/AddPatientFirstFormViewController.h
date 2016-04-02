//
//  AddPatientFirstFormViewController.h
//  Assignment 6
//
//  Created by Hari Panjwani on 3/16/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AddPatientSecondFormView.h"
#define kOFFSET_FOR_KEYBOARD 60.0

@class AddPatientSecondFormView;

@interface AddPatientFirstFormViewController : UIViewController<UIImagePickerControllerDelegate, UINavigationControllerDelegate, UITextFieldDelegate, UITextViewDelegate>


@property (strong, nonatomic) UITapGestureRecognizer *tap;

@property Hospital *hospital;

@property (nonatomic, strong)AddPatientSecondFormView *addPatientSecondView;

@property (weak, nonatomic) IBOutlet UIImageView *imageView;

@property (weak, nonatomic) IBOutlet UITextField *firstNameText;

@property (weak, nonatomic) IBOutlet UITextField *lastNameText;

@property (weak, nonatomic) IBOutlet UITextField *cityText;

@property (weak, nonatomic) IBOutlet UITextField *stateText;

@property (weak, nonatomic) IBOutlet UIButton *nextButton;

@property (weak, nonatomic) IBOutlet UIButton *insertImageButton;

@property (nonatomic) UIImagePickerController *imagePickerController;

@property (nonatomic) NSMutableArray *capturedImages;

- (IBAction)addPatientSecondForm:(id)sender;

- (IBAction)insertImage:(id)sender;

@end
