//
//  MasterViewController.m
//  Assignment 8
//
//  Created by Hari Panjwani on 4/7/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "MasterViewController.h"
#import "DetailViewController.h"

#define JSON_FILE_URL @"https://api.github.com/repos/rails/rails/issues?state=all"

@interface MasterViewController ()

@property NSMutableArray *issues;

@property NSMutableArray *users;

@property NSMutableArray *assignees;

//this array is for storing titles
@property NSMutableArray *objects;

@property NSArray *data;

@end

@implementation MasterViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Do any additional setup after loading the view, typically from a nib.
//    self.navigationItem.leftBarButtonItem = self.editButtonItem;

//    UIBarButtonItem *addButton = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemAdd target:self action:@selector(insertNewObject:)];
//    self.navigationItem.rightBarButtonItem = addButton;
//    self.detailViewController = (DetailViewController *)[[self.splitViewController.viewControllers lastObject] topViewController];
    
    NSLog(@"Welcome to JSON Data Serialization Application");
    
    // Reading the JSON url
    NSString *urlString = [NSString stringWithFormat: JSON_FILE_URL];
    
    NSURL *url = [NSURL URLWithString:urlString];
    
    NSData *data = [NSData dataWithContentsOfURL:url];
    
    self.users = [self usersFromJSONData:data];
    
    self.issues = [self issuesFromJSONData:data];
    
    NSMutableArray *jsonResult = [NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
    
    self.data = jsonResult;
    
}

- (void)viewWillAppear:(BOOL)animated {
    self.clearsSelectionOnViewWillAppear = self.splitViewController.isCollapsed;
    [super viewWillAppear:animated];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)insertNewObject:(id)sender {
    if (!self.objects) {
        self.objects = [[NSMutableArray alloc] init];
    }
    [self.objects insertObject:[NSDate date] atIndex:0];
    NSIndexPath *indexPath = [NSIndexPath indexPathForRow:0 inSection:0];
    [self.tableView insertRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationAutomatic];
}

#pragma mark - Segues

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    if ([[segue identifier] isEqualToString:@"showDetail"]) {
        
        NSIndexPath *indexPath = [self.tableView indexPathForSelectedRow];
        
        DetailViewController *controller = (DetailViewController *)[[segue destinationViewController] topViewController];
        
        controller.issue = [self.issues objectAtIndex:indexPath.row];
        controller.user = [self.users objectAtIndex:indexPath.row];
        controller.navigationItem.leftBarButtonItem = self.splitViewController.displayModeButtonItem;
        controller.navigationItem.leftItemsSupplementBackButton = YES;
    }
}

#pragma mark - Table View

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.issues.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    UITableViewCell *cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];

    Issue *issue = [self.issues objectAtIndex:indexPath.row];
    cell.textLabel.text = [NSString stringWithFormat:@"%@",issue.number];
    cell.detailTextLabel.text = [NSString stringWithFormat:@"%@",issue.title];
    cell.textLabel.numberOfLines = 0;
    
    NSString *state = [NSString stringWithFormat:@"%@",issue.state];
    
    if([state isEqualToString:@"closed"])
        cell.imageView.image = [UIImage imageNamed:@"locked.jpg"];
    else
        cell.imageView.image = [UIImage imageNamed:@"unlocked.jpg"];
    
    return cell;
}

- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        [self.objects removeObjectAtIndex:indexPath.row];
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.
    }
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    [self performSegueWithIdentifier:@"showDetail" sender:self];
}

- (NSMutableArray *)usersFromJSONData:(NSData *)jsonData {
    
    NSError *error;
    
    NSDictionary *json = [NSJSONSerialization JSONObjectWithData:jsonData options:kNilOptions error:nil];
    
    NSMutableArray *users = [[NSMutableArray alloc] init];
    
    for (id item in json) {
        
        id userObj = [item objectForKey:@"user"];
        
        if (userObj == (id)[NSNull null]) {
            NSLog(@"User not found");
        } else {
            
            User *user = [[User alloc] init];
            
            user.login = userObj[@"login"];
            user.gitID= userObj[@"id"];
            user.avtarURL = userObj[@"avatar_url"];
            
            [users addObject:user];
        }
    }
    
    return users;
}

- (NSMutableArray *)issuesFromJSONData:(NSData *)jsonData {
    
    NSError *error;
    
    NSDictionary *json = [NSJSONSerialization JSONObjectWithData:jsonData options:kNilOptions error:nil];
    
    NSMutableArray *issues = [[NSMutableArray alloc] init];
    
    for (id item in json) {
        
        Issue *issue = [[Issue alloc] init];
        
        issue.issueID = item[@"id"];
        issue.number  = item[@"number"];
        issue.title   = item[@"title"];
        issue.state   = item[@"state"];
        issue.body    = item[@"body"];
        issue.comments   = item[@"comments"];
        issue.comments_url   = item[@"commets_url"];
        issue.url   = item[@"url"];
        issue.createdAt   = item[@"created_at"];
        issue.updatedAt   = item[@"updated_at"];
        issue.closedAt   = item[@"closed_at"];
        
        [issues addObject:issue];
    }
    
    return issues;
}

@end
