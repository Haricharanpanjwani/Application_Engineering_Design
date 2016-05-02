//
//  ProfileViewController.h
//  final
//
//  Created by apple on 5/30/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "UserAccount.h"
#import "PatientProfile.h"
#import "EditProfileViewController.h"

@interface ProfileViewController : UIViewController<EditProfileViewControllerDelegate>{
    UserAccount *ua;
    NSArray *arrayData;
    PatientProfile *profile;
}

@property(strong,nonatomic)NSArray *arrayData;
@property(strong,nonatomic)PatientProfile *profile;
@property(strong,nonatomic)UserAccount *ua;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property (weak, nonatomic) IBOutlet UILabel *fname;
@property (weak, nonatomic) IBOutlet UILabel *lname;
@property (weak, nonatomic) IBOutlet UILabel *gender;

@end
