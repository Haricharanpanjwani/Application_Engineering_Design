//
//  LoginController.m
//  sample-chat
//
//  Created by Hari Panjwani on 4/14/16.
//  Copyright © 2016 Quickblox. All rights reserved.
//

#import "LoginController.h"

@implementation LoginController

@synthesize loginButton;

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    if ([[segue identifier] isEqualToString:@"showTable"]) {
        
        LoginTableViewController *view = segue.destinationViewController;
    }
}



@end
