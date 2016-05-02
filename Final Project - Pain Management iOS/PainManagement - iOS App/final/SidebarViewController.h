//
//  SidebarViewController.h
//  SidebarDemo
//
//  Created by Simon on 29/6/13.
//  Copyright (c) 2013 Appcoda. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "AppDelegate.h"

@interface SidebarViewController : UITableViewController
{
    UserAccount *ua;
    NSArray* menuitems;

}
@property (nonatomic, strong) NSArray *menuItems;
@property(strong,nonatomic) UserAccount *ua;


@end
