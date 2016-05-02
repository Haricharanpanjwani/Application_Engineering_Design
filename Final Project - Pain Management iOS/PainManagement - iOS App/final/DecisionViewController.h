//
//  DecisionViewController.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/28/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "EmailViewController.h"

@interface DecisionViewController : UIViewController<UIPickerViewDataSource, UIPickerViewDelegate,DoctorViewControllerDelegate>{
    UIButton *button;
    NSArray *arrayData;
    NSInteger selectedRow;
    NSMutableArray *somearray;
    NSArray *jsonarray;
}

@property (nonatomic,retain) IBOutlet UIButton *button;
@property (weak, nonatomic) IBOutlet UIPickerView *picker;
@property (strong,nonatomic)NSMutableArray *somearray;
@property(strong,nonatomic) UserAccount *ua;
@property (strong,nonatomic) NSArray *jsonarray;
@property (strong,nonatomic) NSMutableData *data;

- (IBAction)optionSelected:(id)sender;

@end
