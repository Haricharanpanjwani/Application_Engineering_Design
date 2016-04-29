//
//  ProgramViewController.m
//  final
//
//  Created by apple on 5/15/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "ProgramViewController.h"
#import "SWRevealViewController.h"
#import "ProgramDetailViewController.h"

@interface ProgramViewController ()

@end

@implementation ProgramViewController
@synthesize content,filteredContent,programDetails,ua;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    //self.content = content;
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sidebarButton setTarget:self.revealViewController];
        [self.sidebarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
    }
    
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    self.tableView.backgroundView = imageview;
    
    self.title = @"Programs";
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
    return [content count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *cell_id = @"cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:cell_id forIndexPath:indexPath];
    
    if(cell == nil){
        cell = [[UITableViewCell alloc]initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:cell_id];
        cell.accessoryType = UITableViewCellAccessoryDetailDisclosureButton;
    }
    
    programDetails = [content objectAtIndex:indexPath.row];
    
    cell.textLabel.text = programDetails.programName;
    cell.textLabel.numberOfLines = 0;
    cell.detailTextLabel.text = programDetails.programUrl;
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



#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    if([segue.identifier isEqualToString:@"programDetails"]){
    ProgramDetailViewController *pdvc = (ProgramDetailViewController*)[segue destinationViewController];
    pdvc.data = [content objectAtIndex:self.tableView.indexPathForSelectedRow.row];
    pdvc.ua = self.ua;
        pdvc.delegate = self;
        
    }
}

-(void)programViewController:(ProgramDetailViewController *)mvc didChooseValue:(UserAccount *)ua1{
    self.ua = ua1;
    [self.navigationController popViewControllerAnimated:YES];
    
}


@end
