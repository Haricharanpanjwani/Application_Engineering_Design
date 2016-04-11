//
//  Issue.m
//  Assignment 8
//
//  Created by Hari Panjwani on 4/8/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "Issue.h"

@implementation Issue

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
        
        [issues addObject:issue];
    }

    return issues;
}

@end
