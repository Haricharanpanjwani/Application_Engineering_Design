//
//  EmailViewController.h
//  final
//
//  Created by Manali Rajesh Chheda on 4/30/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MessageUI/MFMailComposeViewController.h>
#import "UserAccount.h"
#import "DoctorProfile.h"

@protocol DoctorViewControllerDelegate;

@interface EmailViewController : UIViewController<MFMailComposeViewControllerDelegate>
{
    UserAccount *ua;
    DoctorProfile *doctor;
     NSArray *arrayData;
}
@property (weak, nonatomic) IBOutlet UILabel *email;
@property (weak, nonatomic) IBOutlet UILabel *phonedoc;
@property (weak, nonatomic) IBOutlet UILabel *docInfo;
@property (weak, nonatomic) IBOutlet UILabel *specialist;
@property (strong, nonatomic) IBOutlet UINavigationBar *navigationBar;
@property (weak, nonatomic) IBOutlet UILabel *titlelabel;

@property(strong,nonatomic)UserAccount *ua;
@property(strong,nonatomic)DoctorProfile *doctor;
@property(nonatomic,weak) id<DoctorViewControllerDelegate> delegate;

- (IBAction)showEmail:(id)sender;

- (IBAction)call:(id)sender;
//- (IBAction)back:(id)sender;

@end

@protocol DoctorViewControllerDelegate <NSObject>

-(void)doctorViewController:(EmailViewController *)evc didChooseValue:(NSMutableArray *)profile;

@end
