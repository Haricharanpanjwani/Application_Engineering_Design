//
//  ViewController.m
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/26/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@property DBManager *dbManager;

@end

@implementation ViewController

@synthesize hospital;
@synthesize dbManager;


- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
    // Retriving data from database
    dbManager = [DBManager sharedSingleton];
    
    NSString *name = [dbManager retrieveHospital];
    
    if(name == nil) {
        self.createButton.enabled = YES;
        self.listButton.enabled = NO;
    }
    else {
        hospital = [[Hospital alloc] init];
        NSMutableArray *tempList = [dbManager createPatientList:name];
        
        for(Patient *p in tempList) {
            [hospital.patientList addObject:p];
        }
        
        hospital.hospitalName = name;
        self.createButton.enabled = NO;
        self.listButton.enabled = YES;
    }
    
}

-(void) viewWillAppear:(BOOL)animated {
    NSLog(@"Hospital Name View Controller: %@", self.hospital.hospitalName);
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    if ([[segue identifier] isEqualToString:@"showPatientList"]) {        
        
        PatientsView *view = segue.destinationViewController;
        view.hospital = self.hospital;
    }
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
