//
//  PatientsView.h
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/27/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Hospital.h"
#import "AddPatientFirstFormViewController.h"
#import "PatientDetailView.h"
#import "DBManager.h"

@interface PatientsView : UIViewController<UITableViewDelegate,UITableViewDataSource, UISearchControllerDelegate, UISearchBarDelegate, UISearchResultsUpdating>

@property (weak, nonatomic) IBOutlet UITableView *tableListView;

@property (weak, nonatomic) IBOutlet UISearchBar *searchResultView;

@property (strong, nonatomic) UISearchController *searchController;

//@property (nonatomic, strong) PatientDetailView *patientDetailView;

@property (nonatomic, strong) NSMutableArray *patientList;

@property (nonatomic, strong) NSMutableArray * filteredItems;

@property (nonatomic, weak) NSArray * displayedItems;

@property Hospital *hospital;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *addButton;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *editButton;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *doneButton;

@end
