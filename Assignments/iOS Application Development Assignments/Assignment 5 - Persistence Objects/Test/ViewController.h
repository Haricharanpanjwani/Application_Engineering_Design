//
//  ViewController.h
//  Test
//
//  Created by Hari Panjwani on 2/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"

@interface ViewController : UIViewController

@property (strong, nonatomic) Hospital *hospital;

@property (strong, nonatomic) UITapGestureRecognizer *tap;

@property (strong, nonatomic) UIButton *addButton;
@property (strong, nonatomic) UIButton *searchButton;
@property (strong, nonatomic) UIButton *listButton;
@property (strong, nonatomic) UIButton *addRecordButton;
@property (strong, nonatomic) UIButton *viewRecordButton;
@property (strong, nonatomic) UIButton *quitButton;
@property (strong, nonatomic) UIButton *nextButton;
@property (strong, nonatomic) UIButton *backButton;
@property (strong, nonatomic) UIButton *submitButton;
@property (strong, nonatomic) UIButton *secondBackButton;
@property (strong, nonatomic) UIButton *searchSearchButton;
@property (strong, nonatomic) UIButton *backSearchButton;
@property (strong, nonatomic) UIButton *backSearchResultButton;
@property (strong, nonatomic) UIButton *backListButton;
@property (strong, nonatomic) UIButton *searchRecordButton;
@property (strong, nonatomic) UIButton *backRecordButton;

@property (strong, nonatomic) UIView *addPatientFirstView;
@property (strong, nonatomic) UIView *addPatientSecondView;
@property (strong, nonatomic) UIView *searchPatientView;
@property (strong, nonatomic) UIView *addMedicalRecordView;
@property (strong, nonatomic) UIView *vitalSignView;
@property (strong, nonatomic) UIView *searchResultView;
@property (strong, nonatomic) UIView *patientListView;
@property (strong, nonatomic) UIView *viewMedicalRecordView;
@property (strong, nonatomic) UIView *displayRecordView;

@property (strong, nonatomic) UITextField *firstNameText;
@property (strong, nonatomic) UITextField *lastNameText;
@property (strong, nonatomic) UITextField *streetNumText;
@property (strong, nonatomic) UITextField *streetNameText;
@property (strong, nonatomic) UITextField *cityText;
@property (strong, nonatomic) UITextField *stateText;
@property (strong, nonatomic) UITextField *zipCodeText;
@property (strong, nonatomic) UITextField *contactNumText;

@property (strong, nonatomic) UILabel *addFirstName;
@property (strong, nonatomic) UILabel *dob;
@property(nonatomic,retain) UIDatePicker *dobPicker;

@property (strong, nonatomic) UITextField *ssnText;
@property (strong, nonatomic) UITextField *primaryPhysicianText;


@property (strong, nonatomic) UISearchBar *searchText;
@property (strong, nonatomic) UISearchBar *patientSearchText;

@property (strong, nonatomic) UITextField *respRateText;
@property (strong, nonatomic) UITextField *heartRateText;
@property (strong, nonatomic) UITextField *bpRateText;
@property (strong, nonatomic) UITextField *pulseRateText;
@property (strong, nonatomic) UITextField *weightText;
@property (strong, nonatomic) UITextField *prescriptionText;


@end