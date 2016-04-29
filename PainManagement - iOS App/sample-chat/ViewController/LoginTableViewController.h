//
//  LoginTableViewController.h
//  sample-chat
//
//  Created by Anton Sokolchenko on 5/26/15.
//  Copyright (c) 2015 Igor Khomenko. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"

@interface LoginTableViewController : UITableViewController

@property UserAccount *userAccount;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *sideBarButton;

@end
