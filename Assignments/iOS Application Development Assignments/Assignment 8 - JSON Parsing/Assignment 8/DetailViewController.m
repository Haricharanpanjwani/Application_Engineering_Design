//
//  DetailViewController.m
//  Assignment 8
//
//  Created by Hari Panjwani on 4/7/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "DetailViewController.h"

@interface DetailViewController ()

@end

@implementation DetailViewController

@synthesize detailTableView;

@synthesize issue;

@synthesize user;

//@synthesize userDeatailTextView;
//
//@synthesize issueDetailTextView;
//
//@synthesize commentsTextField;

#pragma mark - Managing the detail item

- (void)setDetailItem:(id)newDetailItem {
    if (_detailItem != newDetailItem) {
        _detailItem = newDetailItem;
            
        // Update the view.
        [self configureView];
    }
}

- (void)configureView {
    // Update the user interface for the detail item.
    if (self.detailItem) {
        //self.detailDescriptionLabel.text = self.detailItem;
    }
}

-(void) viewWillAppear: (BOOL)animated {
    [super viewWillAppear:YES];
    
    [detailTableView reloadData];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    [self configureView];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table View

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 10;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return 1;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    switch (indexPath.section) {
        case 0:
        {
            UITableViewCell *userLogin = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            userLogin.textLabel.text = @"User Login";
            userLogin.detailTextLabel.text = [NSString stringWithFormat:@"%@", user.login];
            userLogin.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return userLogin;
        }
        case 1:
        {
            UITableViewCell *userID = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            userID.textLabel.text = @"User ID";
            userID.detailTextLabel.text = [NSString stringWithFormat:@"%@", user.gitID];
            userID.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return userID;
        }
        case 2:
        {
            UITableViewCell *issueTitle = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            issueTitle.textLabel.text = @"Issue Title";
            issueTitle.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.title];
            issueTitle.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return issueTitle;
        }
        case 3:
        {
            UITableViewCell *url = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            url.textLabel.text = @"GitHub URL";
            url.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.url];
            url.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return url;
        }
        case 4:
        {
            UITableViewCell *body = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            body.textLabel.text = @"Body";
            body.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.body];
            body.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return body;
        }
        case 5:
        {
            UITableViewCell *commentURL = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            commentURL.textLabel.text = @"Comment URL";
            commentURL.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.comments_url];
            commentURL.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return commentURL;
        }
        case 6:
        {
            UITableViewCell *comment = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            comment.textLabel.text = @"Number of Comment";
            comment.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.comments];
            comment.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return comment;
        }
        case 7:
        {
            UITableViewCell *createdAt = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            createdAt.textLabel.text = @"Issue Create Date";
            createdAt.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.createdAt];
            createdAt.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return createdAt;
        }
        case 8:
        {
            UITableViewCell *updatedAt = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            updatedAt.textLabel.text = @"Issue Update Date";
            updatedAt.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.updatedAt];
            updatedAt.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return updatedAt;
        }
        case 9:
        {
            UITableViewCell *closedAt = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
            
            closedAt.textLabel.text = @"Issue Closed Date";
            closedAt.detailTextLabel.text = [NSString stringWithFormat:@"%@", issue.closedAt];
            closedAt.accessoryType=UITableViewCellAccessoryDisclosureIndicator;
            
            return closedAt;
        }

        default:
            break;
    }
    return 0;
    
//    UITableViewCell *cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:NSLocaleIdentifier];
//    
//    Issue *issue = [self.issues objectAtIndex:indexPath.row];
//    cell.textLabel.text = [NSString stringWithFormat:@"%@",issue.number];
//    cell.detailTextLabel.text = [NSString stringWithFormat:@"%@",issue.title];
//    cell.imageView.image = [UIImage imageNamed:@"<YourImage.png>"];
//    cell.textLabel.numberOfLines = 0;
//    
//    return cell;
}

@end
