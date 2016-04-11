//
//  MasterViewController.h
//  Assignment 8
//
//  Created by Hari Panjwani on 4/7/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Issue.h"
#import "User.h"

@class DetailViewController;

@interface MasterViewController : UITableViewController

@property (strong, nonatomic) DetailViewController *detailViewController;

- (NSMutableArray *) usersFromJSONData:(NSData *)jsonData;

- (NSMutableArray *)issuesFromJSONData:(NSData *)jsonData;


@end

