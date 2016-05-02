//
//  EditProfileViewController.h
//  final
//
//  Created by apple on 5/15/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "PatientProfile.h"
#import "UserAccount.h"
#import "MyProfileViewController.h"

@protocol EditProfileViewControllerDelegate;

@interface EditProfileViewController : UIViewController

@property (nonatomic, weak) id<EditProfileViewControllerDelegate> delegate;

@property (strong,nonatomic) UserAccount *ua;
@property (strong,nonatomic) PatientProfile *profile;

@property (weak, nonatomic) IBOutlet UITextField *fname;
@property (weak, nonatomic) IBOutlet UITextField *lname;
@property (weak, nonatomic) IBOutlet UITextField *gender;
@property (strong, nonatomic) IBOutlet UITextField *language;
@property (strong, nonatomic) IBOutlet UITextField *hispaniclatin;
@property (strong, nonatomic) IBOutlet UITextField *enthnicity;
@property (strong, nonatomic) IBOutlet UITextField *currentlyworking;
@property (strong, nonatomic) IBOutlet UITextField *weight;
@property (strong, nonatomic) IBOutlet UITextField *startdate;
@property (strong, nonatomic) IBOutlet UITextField *height;

@property (weak, nonatomic) IBOutlet UIButton *saveButton;

- (IBAction)Save:(id)sender;


@end
@protocol EditProfileViewControllerDelegate <NSObject>

-(void)editProfileViewController:(EditProfileViewController *)epvc didChooseValue:(PatientProfile *)profile;

@end