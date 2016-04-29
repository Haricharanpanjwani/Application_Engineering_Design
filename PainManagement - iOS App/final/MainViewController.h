//
//  ViewController.h
//  SidebarDemo
//
//  Created by Simon on 28/6/13.
//  Copyright (c) 2013 Appcoda. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "PatientProfile.h"
#import "EditProfileViewController.h"

@interface MainViewController : UIViewController<EditProfileViewControllerDelegate>{
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
