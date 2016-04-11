//
//  Assignee.m
//  Assignment 8
//
//  Created by Hari Panjwani on 4/8/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "Assignee.h"

@implementation Assignee

- (NSMutableArray *)assigneeFromJSONData:(NSData *)jsonData {
    
    NSError *error;
    
    NSDictionary *json = [NSJSONSerialization JSONObjectWithData:jsonData options:kNilOptions error:nil];
    
    NSMutableArray *assignees = [[NSMutableArray alloc] init];
    
    for (id item in json) {
        
        id assigneeObj = [item objectForKey:@"assignee"];
        
        if (assigneeObj == (id)[NSNull null]){
            NSLog(@"Assignee not found");
        }
        else {
            
            Assignee *assignee = [[Assignee alloc] init];
            
            assignee.login = assigneeObj[@"login"];
            assignee.gitID= assigneeObj[@"id"];
            assignee.avtarURL = assigneeObj[@"avatar_url"];
            
            [assignees addObject:assignee];
        }
    }
    
    return assignees;
}

@end
