//
//  SidebarViewController.m
//  SidebarDemo
//
//  Created by Simon on 29/6/13.
//  Copyright (c) 2013 Appcoda. All rights reserved.
//

#import "SidebarViewController.h"
#import "PhotoViewController.h"
#import "SWRevealViewController.h"
#import "LoginTableViewController.h"
#import "UserAccount.h"
#import "AppDelegate.h"

@interface SidebarViewController ()


@end

@implementation SidebarViewController
@synthesize ua,menuItems;


- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    AppDelegate *delegate = (AppDelegate*)[[UIApplication sharedApplication] delegate];
    [delegate loginDetails];
    self.ua.userId = delegate.loginDetails.userId;
    self.ua.username = delegate.loginDetails.username;
    
    
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    self.tableView.backgroundView = imageview;

    menuitems = @[@"toolbox",@"report",@"myprofile",@"medication",@"aboutus",@"chat"];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    return menuitems.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    NSString *CellIdentifier = [menuitems objectAtIndex:indexPath.row];
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier forIndexPath:indexPath];
    
    cell.textLabel.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.backgroundView = imageview;
    return cell;
}

-(void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    
    NSIndexPath* indexPath = [self.tableView indexPathForSelectedRow];
    UINavigationController* destViewController = (UINavigationController*)segue.destinationViewController;
    destViewController.title =[[menuitems objectAtIndex:indexPath.row]capitalizedString];
    
    if([segue.identifier isEqualToString:@"showPhoto"]){
        UINavigationController* navController = segue.destinationViewController;
        PhotoViewController *photoController = [navController childViewControllers].firstObject;
        NSString *photoFilename = [NSString stringWithFormat:@"%@_photo", [menuitems objectAtIndex:indexPath.row]];
        photoController.photoFilename = photoFilename;
    }
    
    if([segue.identifier isEqualToString:@"chatTable"]){
        UINavigationController* navController = segue.destinationViewController;
        LoginTableViewController *loginController = [navController childViewControllers].firstObject;
        //loginController.userAccount = self.ua;
    }
}

@end
