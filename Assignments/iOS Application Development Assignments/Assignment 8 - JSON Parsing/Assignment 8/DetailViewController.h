//
//  DetailViewController.h
//  Assignment 8
//
//  Created by Hari Panjwani on 4/7/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Issue.h"
#import "User.h"

@interface DetailViewController : UIViewController<UITableViewDelegate,UITableViewDataSource>

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UITableView *detailTableView;

@property Issue *issue;

@property User *user;

@end

