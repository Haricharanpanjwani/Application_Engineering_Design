//
//  ProgramViewController.h
//  final
//
//  Created by apple on 5/15/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ProgramDetails.h"
#import "UserAccount.h"
#import "ProgramDetailViewController.h"

@interface ProgramViewController : UITableViewController<UISearchBarDelegate,UISearchDisplayDelegate,UIPickerViewDelegate,programViewControllerDelegate>
{
    
    NSMutableArray *content;
    NSMutableArray *filteredContent;
    ProgramDetails *programDetails;
    UserAccount *ua;
}

@property(nonatomic,strong) NSMutableArray *content;
@property(nonatomic,strong) NSMutableArray *filteredContent;
@property(nonatomic,strong) ProgramDetails *programDetails;
@property(nonatomic,strong) UserAccount *ua;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;

@end
