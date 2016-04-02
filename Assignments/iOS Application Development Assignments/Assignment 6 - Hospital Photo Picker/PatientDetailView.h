//
//  PatientDetailView.h
//  Assignment 6
//
//  Created by Hari Panjwani on 3/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"

@interface PatientDetailView : UIViewController<UITableViewDelegate,UITableViewDataSource, UIImagePickerControllerDelegate, UINavigationControllerDelegate>

@property (weak, nonatomic) IBOutlet UIView *headerView;

@property (weak, nonatomic) IBOutlet UIImageView *imageView;

@property (weak, nonatomic) IBOutlet UILabel *patientName;
@property (weak, nonatomic) IBOutlet UITableView *detailTableView;

@property (weak, nonatomic) IBOutlet UIButton *insertPhoto;

@property Hospital *hospital;

@property Patient *patient;

@property NSInteger index;

@property (nonatomic) UIImagePickerController *imagePickerController;

@property (nonatomic) NSMutableArray *displayItems;

- (IBAction)takePhoto:(id)sender;

@end
