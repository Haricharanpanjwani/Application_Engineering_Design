//
//  AccordionViewControllerTableViewController.h
//  SidebarDemo
//
//  Created by Priya Dilipkumar Poptani on 4/30/15.
//  Copyright (c) 2015 Appcoda. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "AccordionGenericobject.h"
#import "MedicationViewController.h"

@interface AccordionViewControllerTableViewController : UITableViewController
{
    NSMutableArray *dataArray;
    NSMutableArray *dataArray2;
    NSMutableArray *childArray;
    NSArray *filteredChildArray;
    NSInteger indentationlevel;
    CGFloat indendationWidth;
    NSArray *jsonData;
    NSMutableData *data;
    UserAccount *ua;
    AccordionGenericobject *obj;
}

@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property(nonatomic,strong)NSArray *jsonData;
@property(nonatomic,strong)NSMutableData *data;
@property(nonatomic,strong)UserAccount *ua;
@end
