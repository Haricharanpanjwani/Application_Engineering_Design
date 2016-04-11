//
//  Assignee.h
//  Assignment 8
//
//  Created by Hari Panjwani on 4/8/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Assignee : NSObject

@property (nonatomic) NSString *login;
@property (nonatomic) NSString *gitID;
@property (nonatomic) NSString *avtarURL;

- (NSMutableArray *)assigneeFromJSONData:(NSData *)jsonData;

@end
