//
//  MedicationViewController.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "MedicineDetailsViewController.h"

@interface MedicationViewController : UITableViewController<MedicationViewControllerDelegate>
{
    NSMutableArray *jsonData;
    NSMutableData *data;
    UserAccount *ua;
}
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property(nonatomic,strong)NSMutableArray *jsonData;
@property(nonatomic,strong)NSMutableData *data;
@property(nonatomic,strong)UserAccount *ua;
@end
