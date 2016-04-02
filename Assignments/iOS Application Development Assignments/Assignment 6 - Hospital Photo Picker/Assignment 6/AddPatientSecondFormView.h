//
//  AddPatientSecondFormView.h
//  Assignment 6
//
//  Created by Hari Panjwani on 3/16/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "PatientListView.h"
#import "Hospital.h"
#import "Patient.h"
#define kOFFSET_FOR_KEYBOARD 60.0

@class PatientListView;

@interface AddPatientSecondFormView : UIViewController<UITextFieldDelegate, UITextViewDelegate>

@property (strong, nonatomic) UITapGestureRecognizer *tap;

@property Hospital* hospital;

@property NSString *firstName;
@property NSString *lastName;
@property NSString *city;
@property NSString *state;
@property UIImage *imageName;

@property (strong, nonatomic) PatientListView *patientListView;

@property (weak, nonatomic) IBOutlet UITextField *zipCodeText;

@property (weak, nonatomic) IBOutlet UITextField *contactNumberText;

@property (weak, nonatomic) IBOutlet UIDatePicker *dobPicker;

@property (weak, nonatomic) IBOutlet UITextField *ssnText;

@property (weak, nonatomic) IBOutlet UITextField *primaryPhysicianText;

@property (weak, nonatomic) IBOutlet UIButton *submitButton;

@property NSMutableArray *captureImages;

@end
