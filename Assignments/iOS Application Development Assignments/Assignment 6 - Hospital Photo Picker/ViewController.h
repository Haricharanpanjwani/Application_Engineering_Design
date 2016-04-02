//
//  ViewController.h
//  Assignment 6
//
//  Created by Hari Panjwani on 3/16/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "PatientListView.h"
#import "CreateHospitalView.h"
#import "Hospital.h"

@class CreateHospitalView;

@interface ViewController : UIViewController

@property Hospital *hospital;

@property (nonatomic, strong) CreateHospitalView *createHospitalView;

@property (nonatomic, strong) PatientListView *patientListView;

@property (weak, nonatomic) IBOutlet UIButton *addPatient;

@property (weak, nonatomic) IBOutlet UIButton *patientListButton;

@property (weak, nonatomic) IBOutlet UIButton *exitButton;

- (IBAction)createHospitalForm:(id)sender;

- (IBAction)patientListForm:(id)sender;

- (IBAction)exit:(id)sender;

@end
