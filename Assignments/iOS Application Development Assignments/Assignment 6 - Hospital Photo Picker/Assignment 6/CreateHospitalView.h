//
//  CreateHospitalView.h
//  Assignment 6
//
//  Created by Hari Panjwani on 3/20/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"
#import "ViewController.h"

@class ViewController;

@interface CreateHospitalView : UIViewController

@property Hospital *hospital;

@property (nonatomic, strong) ViewController *viewController;
@property (weak, nonatomic) IBOutlet UITextField *hospitalName;
@property (weak, nonatomic) IBOutlet UIButton *enterButton;

@end
