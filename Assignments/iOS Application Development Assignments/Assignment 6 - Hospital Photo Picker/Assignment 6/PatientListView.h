//
//  PatientListView.h
//  Assignment 6
//
//  Created by Hari Panjwani on 3/17/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"
#import "PatientDetailView.h"
#import "AddPatientFirstFormViewController.h"

@class AddPatientFirstFormViewController;

@interface PatientListView : UIViewController<UITableViewDelegate,UITableViewDataSource, UISearchControllerDelegate, UISearchBarDelegate, UISearchResultsUpdating>

@property (weak, nonatomic) IBOutlet UIButton *exitButton;

@property (weak, nonatomic) IBOutlet UITableView *tableListView;

@property (strong, nonatomic) IBOutlet UIBarButtonItem *addButton;

@property (strong, nonatomic) IBOutlet UIBarButtonItem *editButton;

@property (strong, nonatomic) IBOutlet UIBarButtonItem *doneButton;

@property (weak, nonatomic) IBOutlet UISearchBar *searchResultView;

@property (strong, nonatomic) UISearchController *searchController;

@property (nonatomic, strong) PatientDetailView *patientDetailView;

@property (nonatomic, strong) AddPatientFirstFormViewController *addPatientFirstView;

@property (nonatomic, strong) Hospital *hospital;

@property (nonatomic, strong) NSMutableArray *patientList;

@property (nonatomic, strong) NSMutableArray * filteredItems;

@property (nonatomic, weak) NSArray * displayedItems;

- (IBAction)exit:(id)sender;

@end
