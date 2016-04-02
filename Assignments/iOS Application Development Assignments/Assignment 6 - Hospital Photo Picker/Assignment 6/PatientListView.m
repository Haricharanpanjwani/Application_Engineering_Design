//
//  PatientListView.m
//  Assignment 6
//
//  Created by Hari Panjwani on 3/17/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "PatientListView.h"

@interface PatientListView ()

@end

@implementation PatientListView

@synthesize tableListView;
@synthesize patientDetailView;
@synthesize addPatientFirstView;
@synthesize addButton;
@synthesize editButton;
@synthesize doneButton;
@synthesize hospital;
@synthesize patientList;
@synthesize searchController;
@synthesize filteredItems;
@synthesize displayedItems;

- (AddPatientFirstFormViewController *) addPatientFirstView {
    
    if(!addPatientFirstView) {
        addPatientFirstView = [[AddPatientFirstFormViewController alloc] initWithNibName:nil bundle: nil];
        addPatientFirstView.title = @"Add Patient";
    }
    return addPatientFirstView;
}

-(PatientDetailView *) patientDetailView {
    
    if(!patientDetailView) {
        patientDetailView = [[PatientDetailView alloc] initWithNibName:nil bundle: nil];
        patientDetailView.title = @"Patient Detail";
    }
    return patientDetailView;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
//    [tableListView reloadData];
//    
//    // Add Patient Button is added
//    addButton = [[UIBarButtonItem alloc]
//    initWithBarButtonSystemItem:UIBarButtonSystemItemAdd target:self action:@selector(addPatientFirstForm)];
//    
//    // Edit Patient Button is added
//    editButton = [[UIBarButtonItem alloc]
//    initWithBarButtonSystemItem:UIBarButtonSystemItemEdit target:self action:@selector(editPatientList)];
//    
//    // Adding to the navigation bar
//    self.navigationItem.rightBarButtonItems = [NSArray arrayWithObjects:addButton,editButton,nil];
//    
////    patientList = [[NSMutableArray alloc]init];
////
////    for(Patient *patient in hospital.patientList) {
////        
////        NSString *name = patient.firstName;
////        name = [name stringByAppendingFormat:@" %@", patient.lastName];
////
////        [patientList addObject:name];
////    }
//    
//    
//    // Create a list to hold search results (filtered list)
//    self.filteredItems = [[NSMutableArray alloc] init];
//    
//    // Initially display the full list.  This variable will toggle between the full and the filtered lists.
//    self.displayedItems = self.hospital.patientList;
//    
//    // Here's where we create our UISearchController
//    
//    self.searchController = [[UISearchController alloc] initWithSearchResultsController:nil];
//    self.searchController.searchResultsUpdater = self;
//    self.searchController.searchBar.delegate = self;
//    self.searchController.dimsBackgroundDuringPresentation = NO;
////    self.searchController.searchBar.scopeButtonTitles = @[NSLocalizedString(@"ScopeButtonCountry",@"Country"),                                                          NSLocalizedString(@"ScopeButtonCapital",@"Capital")];
//    
//    [self.searchController.searchBar sizeToFit];
//    
//    // Add the UISearchBar to the top header of the table view
//    self.tableListView.tableHeaderView = self.searchController.searchBar;
    
    // Hides search bar initially.  When the user pulls down on the list, the search bar is revealed.
    //[self.tableListView setContentOffset:CGPointMake(0, self.searchController.searchBar.frame.size.height)];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void) viewWillAppear:(BOOL)animated {
    
    [super viewWillAppear:YES];
    
    // Do any additional setup after loading the view from its nib.
    [tableListView reloadData];
    
    // Add Patient Button is added
    addButton = [[UIBarButtonItem alloc]
                 initWithBarButtonSystemItem:UIBarButtonSystemItemAdd target:self action:@selector(addPatientFirstForm)];
    
    // Edit Patient Button is added
    editButton = [[UIBarButtonItem alloc]
                  initWithBarButtonSystemItem:UIBarButtonSystemItemEdit target:self action:@selector(editPatientList)];
    
    // Adding to the navigation bar
    self.navigationItem.rightBarButtonItems = [NSArray arrayWithObjects:addButton,editButton,nil];
    
        patientList = [[NSMutableArray alloc]init];
    
        for(Patient *patient in hospital.patientList) {
    
            NSString *name = patient.firstName;
            name = [name stringByAppendingFormat:@" %@", patient.lastName];
    
            [patientList addObject:name];
        }
    
    
    // Create a list to hold search results (filtered list)
    self.filteredItems = [[NSMutableArray alloc] init];
    
    // Initially display the full list.  This variable will toggle between the full and the filtered lists.
    self.displayedItems = self.hospital.patientList;
    
    // Here's where we create our UISearchController
    
    self.searchController = [[UISearchController alloc] initWithSearchResultsController:nil];
    self.searchController.searchResultsUpdater = self;
    self.searchController.searchBar.delegate = self;
    self.searchController.dimsBackgroundDuringPresentation = NO;
    //    self.searchController.searchBar.scopeButtonTitles = @[NSLocalizedString(@"ScopeButtonCountry",@"Country"),                                                          NSLocalizedString(@"ScopeButtonCapital",@"Capital")];
    
    [self.searchController.searchBar sizeToFit];
    
    // Add the UISearchBar to the top header of the table view
    self.tableListView.tableHeaderView = self.searchController.searchBar;
    
    // Hides search bar initially.  When the user pulls down on the list, the search bar is revealed.
    //[self.tableListView setContentOffset:CGPointMake(0, self.searchController.searchBar.frame.size.height)];
}

// When the user types in the search bar, this method gets called.
- (void)updateSearchResultsForSearchController:(UISearchController *)aSearchController {
    NSLog(@"updateSearchResultsForSearchController");
    
    NSString *searchString = searchController.searchBar.text;
    NSLog(@"searchString=%@", searchString);
    
    // Check if the user cancelled or deleted the search term so we can display the full list instead.
    if (![searchString isEqual:nil]) {
        [self.filteredItems removeAllObjects];
        for (Patient *patient in self.hospital.patientList) {
            if ([searchString isEqualToString:@""] || [patient.firstName
                localizedCaseInsensitiveContainsString:searchString] == YES ||
               [patient.lastName localizedCaseInsensitiveContainsString:searchString] == YES) {
                NSLog(@"str=%@", patient.firstName);
                [self.filteredItems addObject:patient];
            }
        }
        self.displayedItems = self.filteredItems;
    }
    else {
        self.displayedItems = self.patientList;
    }
    
    [self.tableListView reloadData];
}

// Display the number of rows
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
        return [displayedItems count];
}

// Content within the cell for each row
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {

    static NSString *simpleTableIdentifier = @"Name of the Patient";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
    
    if (cell == nil) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:
                simpleTableIdentifier];
    }
    
    Patient *patient = [displayedItems objectAtIndex:indexPath.row];
    
    NSString *name = patient.firstName;
    name = [name stringByAppendingFormat:@" %@", patient.lastName];
    
    cell.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
    cell.textLabel.text = name;
    cell.imageView.image = patient.imageName;
    
    //cell.imageView.image = [UIImage imageNamed:@"minion.jpg"];
    
    return cell;
}

// Pass the row to another view controller to display the details
-(void) tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell=[tableView cellForRowAtIndexPath:indexPath];
    
    NSString *name=cell.textLabel.text;
    NSArray *names = [name componentsSeparatedByString: @" "];
    
    Patient *searchPatient = nil;
    searchPatient =[self.hospital searchPatient:[names objectAtIndex:0]];
    
    if(searchPatient == nil) {
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"No Patient Found"                                                                       message:@"Please select appropriate row!" preferredStyle:UIAlertControllerStyleAlert];
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                              handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
        [self presentViewController:alert animated:YES completion:nil];
    }
    else
    {
        self.patientDetailView.hospital=self.hospital;
        self.patientDetailView.displayItems = self.displayedItems;
        //self.patientDetailView.patient = [displayedItems objectAtIndex:indexPath.row];
        self.patientDetailView.index = indexPath.row;
        
        NSLog(@"%ld", indexPath.row);
        
        [self.navigationController pushViewController:self.patientDetailView animated:YES];
    }
    
}

- (void)addPatientFirstForm
{
    self.addPatientFirstView.hospital = self.hospital;
    [self.navigationController pushViewController:self.addPatientFirstView animated:YES];
}

-(void) editPatientList {
    
    // Done Patient Button is added
    doneButton = [[UIBarButtonItem alloc]
                 initWithBarButtonSystemItem:UIBarButtonSystemItemDone target:self action:@selector(editingDone)];
    
    // Adding to the navigation bar
    self.navigationItem.rightBarButtonItems = [NSArray arrayWithObjects:addButton,doneButton,nil];
    
     [self.tableListView setEditing:YES animated:YES];
}

-(void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        
        // Delete the row from the data source.
        [hospital.patientList removeObjectAtIndex:indexPath.row];
        [self.patientList removeObjectAtIndex:indexPath.row];
        
        [tableListView deleteRowsAtIndexPaths:[NSArray arrayWithObject:indexPath] withRowAnimation:UITableViewRowAnimationFade];
        
        NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
        NSString *documentPath = [paths objectAtIndex:0];
        NSString *filePath = [documentPath stringByAppendingPathComponent:@"assignment6.txt"];
        
        NSMutableData *data = [NSMutableData data];
        NSKeyedArchiver *archiver = [[NSKeyedArchiver alloc] initForWritingWithMutableData:data];
        [archiver encodeObject:self.hospital forKey:@"hospital"];
        [archiver finishEncoding];
        
        NSURL *archiveURL = [[NSURL alloc] initFileURLWithPath:filePath];
        BOOL result = [data writeToURL:archiveURL atomically:YES];
        
        if(result) {
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Deleted Successfully"
                    message:[@"Patient" stringByAppendingString:@" has been deleted successfully!"]preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
        }
    }
}

-(void) editingDone {
        [self.tableListView setEditing:NO animated:YES];
    // Adding to the navigation bar
    self.navigationItem.rightBarButtonItems = [NSArray arrayWithObjects:addButton,editButton,nil];
}

- (IBAction)exit:(id)sender {
    exit(0);
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
