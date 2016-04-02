//
//  ViewController.h
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"
#import "DBManager.h"
#import "PatientsView.h"

@interface ViewController : UIViewController

@property Hospital *hospital;

@property (weak, nonatomic) IBOutlet UIButton *createButton;

@property (weak, nonatomic) IBOutlet UIButton *listButton;

@end

