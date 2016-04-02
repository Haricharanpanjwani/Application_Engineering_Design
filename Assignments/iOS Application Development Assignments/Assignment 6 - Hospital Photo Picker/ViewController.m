//
//  ViewController.m
//  Assignment 6
//
//  Created by Hari Panjwani on 3/16/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize createHospitalView;
@synthesize patientListView;
@synthesize hospital;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    
    
    self.patientListButton.enabled = YES;
    self.addPatient.enabled = NO;
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentPath = [paths objectAtIndex:0];
    NSString *filePath = [documentPath stringByAppendingPathComponent:@"assignment6.txt"];
    NSURL *fileURL = [[NSURL alloc] initFileURLWithPath:filePath];
    NSLog(@"%@", fileURL);
    NSData *data = [NSData dataWithContentsOfURL:fileURL];
    
    if(data) {
        
        NSKeyedUnarchiver *unarchiver = [[NSKeyedUnarchiver alloc] initForReadingWithData:data];
        // Customize the unarchiver.
        hospital = [unarchiver decodeObjectForKey:@"hospital"];
        [unarchiver finishDecoding];
        
    }
    else if(hospital.hospitalName == nil) {
        hospital = [[Hospital alloc] init];
        self.patientListButton.enabled = NO;
        self.addPatient.enabled = YES;
    }    
}

- (CreateHospitalView *) createHospitalView {
    
    if(!createHospitalView) {
        createHospitalView = [[CreateHospitalView alloc] initWithNibName:nil bundle: nil];
        createHospitalView.title = @"Hospital";
    }
    return createHospitalView;
}

- (IBAction)createHospitalForm:(id)sender
{
    self.createHospitalView.hospital = self.hospital;
    [self.navigationController pushViewController:self.createHospitalView animated:YES];
}

- (PatientListView *) patientListView {
    
    if(!patientListView) {
        patientListView = [[PatientListView alloc] initWithNibName:nil bundle: nil];        
        patientListView.title = @"All Patients";
    }
    return patientListView;
}


- (IBAction)patientListForm:(id)sender {
    
    self.patientListView.hospital = self.hospital;
    [self.navigationController pushViewController:self.patientListView animated:YES];
    
}

- (IBAction)exit:(id)sender {
    exit(0);
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
