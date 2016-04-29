//
//  MyProfileViewController.h
//  final
//
//  Created by apple on 7/18/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "AccordionGenericobject.h"
#import "PatientProfile.h"
#import "EditProfileViewController.h"

@interface MyProfileViewController : UITableViewController
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
    PatientProfile *profile;

}

@property (weak, nonatomic) IBOutlet UIBarButtonItem *editButton;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property(strong,nonatomic)PatientProfile *profile;
@property(nonatomic,strong)NSArray *jsonData;
@property(nonatomic,strong)NSMutableData *data;
@property(nonatomic,strong)UserAccount *ua;

@end