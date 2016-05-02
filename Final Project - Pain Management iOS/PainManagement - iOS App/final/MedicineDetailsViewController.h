//
//  MedicineDetailsViewController.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "PatientMedicine.h"

@protocol MedicationViewControllerDelegate ;

@interface MedicineDetailsViewController : UIViewController

{
    //NSString *jsonData;
    PatientMedicine *data;
    UserAccount *ua;
    NSInteger responseData;
}

@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property (weak, nonatomic) IBOutlet UILabel *jsonData;
@property(nonatomic,strong)PatientMedicine *data;
@property(nonatomic,strong)UserAccount *ua;
@property(nonatomic)NSInteger mpid;
@property (weak, nonatomic) IBOutlet UILabel *medicineName;
@property (weak, nonatomic) IBOutlet UITextView *medicineDes;
@property (weak, nonatomic) IBOutlet UILabel *totalNoOfPils;
@property (weak, nonatomic) IBOutlet UILabel *noOfPilsTaken;
@property (weak, nonatomic) IBOutlet UIStepper *pilsStepper;
@property (weak, nonatomic) IBOutlet UILabel *quantity;

@property (nonatomic, weak) id<MedicationViewControllerDelegate> delegate;

- (IBAction)confirmAction:(id)sender;
- (IBAction)valueChanged:(UIStepper *)sender;
@end

@protocol MedicationViewControllerDelegate <NSObject>

-(void)medicationViewController:(MedicineDetailsViewController *)mvc didChooseValue:(UserAccount *)ua;

@end
