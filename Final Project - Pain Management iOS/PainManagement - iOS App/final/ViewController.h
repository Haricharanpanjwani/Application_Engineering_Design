//
//  ViewController.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/28/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "AppDelegate.h"

@interface ViewController : UIViewController<UITextFieldDelegate,UIApplicationDelegate>
{
    UserAccount *ua;
    //AppDelegate *delegate;
}
@property (weak, nonatomic) IBOutlet UITextField *usernameTxt;
@property (weak, nonatomic) IBOutlet UITextField *pwdTxt;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property (strong, nonatomic)  UserAccount *ua;
//@property(strong,nonatomic) AppDelegate *delegate;
- (IBAction)signIn:(id)sender;
- (IBAction)backgroundTap:(id)sender;

@end

