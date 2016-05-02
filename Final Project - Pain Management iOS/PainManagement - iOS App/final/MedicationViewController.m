//
//  MedicationViewController.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "MedicationViewController.h"
#import "SWRevealViewController.h"
#import "PatientMedicine.h"
#import "Constants.h"

@interface MedicationViewController ()

@end

@implementation MedicationViewController
@synthesize jsonData,data,ua;

- (void)viewDidLoad {
    [super viewDidLoad];
    jsonData = [[NSMutableArray alloc]init];
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sidebarButton setTarget:self.revealViewController];
        [self.sidebarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
        self.ua = revealViewController.ua;
    }
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithLong:self.ua.userId],@"userid",self.ua.username,@"username",self.ua.password,nil];
    NSData *  dataVal = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];
    NSString *stringUrl = [NSString stringWithFormat:@"%@medicine",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[dataVal length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:dataVal];
    
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:dataVal encoding:NSUTF8StringEncoding]);
    
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    
    if ([response statusCode] >= 200 && [response statusCode] < 300)
    {
    id object = [NSJSONSerialization JSONObjectWithData:result options:kNilOptions error:nil];
    
    for(id obj in object){
        PatientMedicine *pm = [[PatientMedicine alloc]init];
        pm.mpId = [[obj objectForKey:@"mpid"]integerValue];
        pm.userId = [[obj objectForKey:@"userid"]integerValue];
        pm.medicineId = [[obj objectForKey:@"medicineid"]integerValue];
        pm.medicineName = [obj objectForKey:@"medicinename"];
        pm.medicineDes = [obj objectForKey:@"medicinedes"];
        pm.maxquantity = [[obj objectForKey:@"maxquatity"]integerValue];
        pm.mdpertime = @([[obj objectForKey:@"mdpertime"]integerValue]);//[[NSNumber numberWithInt:[obj objectForKey:@"mdpertime"]];
        
        [jsonData addObject:pm];
    }
    
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    self.tableView.backgroundView = imageview;
    self.title = @"Medicines";
    } else {
        
        [self alertStatus:@"Connection Failed" :@"ry connecting after sometimes!" :0];
    }
}

- (void) alertStatus:(NSString *)msg :(NSString *)title :(int) tag
{
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:title
                                                        message:msg
                                                       delegate:self
                                              cancelButtonTitle:@"Ok"
                                              otherButtonTitles:nil, nil];
    alertView.tag = tag;
    [alertView show];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    // Return the number of rows in the section.
    if(tableView == self.tableView){
        // profile = [NSKeyedUnarchiver unarchiveObjectWithFile:[DatabaseFile getPath]];
        return [jsonData count];
    }
    return [jsonData count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    static NSString *cell_id = @"name";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:cell_id forIndexPath:indexPath];
    
    if (cell == nil) {
        cell = [[UITableViewCell alloc]initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:cell_id];
        cell.accessoryType = UITableViewCellAccessoryDetailDisclosureButton;
    }
    PatientMedicine *pm = [jsonData objectAtIndex:indexPath.row];
    cell.textLabel.text = pm.medicineName;
    cell.textLabel.numberOfLines=0;
    cell.detailTextLabel.text = pm.medicineDes;
    cell.textLabel.textColor = [UIColor brownColor];
    cell.textLabel.font = [UIFont boldSystemFontOfSize:18.0f];
    cell.textLabel.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    // Configure the cell...
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.backgroundView = imageview;
    return cell;
}



// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}


// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}



// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}


-(void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
   // profile.contactList = [profile returnContactList];
    [self.tableView reloadData];
}
/*
-(BOOL)searchDisplayController:(UISearchDisplayController *)controller shouldReloadTableForSearchString:(NSString *)searchString{
    //[self filterContentForSearchText:searchString scope:[[self.searchDisplayController.searchBar scopeButtonTitles] objectAtIndex:[self.searchDisplayController.searchBar selectedScopeButtonIndex]]];
    [self filterContentForSearchText:searchString];
    return YES;
}
*/


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    if([segue.identifier isEqualToString:@"medicineDetails"]){
        MedicineDetailsViewController *mdvc = (MedicineDetailsViewController *)[segue destinationViewController];
        mdvc.delegate = self;
        mdvc.data = [jsonData objectAtIndex:self.tableView.indexPathForSelectedRow.row];
        mdvc.ua = self.ua;
        
    }
    
}

-(void)medicationViewController:(MedicineDetailsViewController *)mvc didChooseValue:(UserAccount *)ua1{
    self.ua = ua1;
    [self.navigationController popViewControllerAnimated:YES];
    //[self viewDidLoad];
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
