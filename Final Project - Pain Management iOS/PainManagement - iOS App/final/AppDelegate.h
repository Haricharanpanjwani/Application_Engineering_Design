//
//  AppDelegate.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/28/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "DecisionViewController.h"
#import "UserAccount.h"

//@class DropDownDemoViewController;

@interface AppDelegate : UIResponder <UIApplicationDelegate>{
     //DropDownDemoViewController *viewController;
    UserAccount *loginDetails;
}

@property (strong, nonatomic) UIWindow *window;
//@property (nonatomic, retain) IBOutlet DropDownDemoViewController *viewController;
@property(strong,nonatomic)UserAccount *loginDetails;

@end

