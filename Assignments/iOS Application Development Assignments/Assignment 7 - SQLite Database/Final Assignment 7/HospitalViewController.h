//
//  HospitalViewController.h
//  Assignment 7
//
//  Created by Hari Panjwani on 3/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"
#import "ViewController.h"
#import "DBManager.h"

@interface HospitalViewController : UIViewController

@property (strong, nonatomic) UITapGestureRecognizer *tap;

@property Hospital *hospital;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *doneButton;

@property (weak, nonatomic) IBOutlet UITextField *hospitalName;

@property (weak, nonatomic) IBOutlet UIButton *createButton;

- (IBAction)createHospital:(id)sender;

@end
