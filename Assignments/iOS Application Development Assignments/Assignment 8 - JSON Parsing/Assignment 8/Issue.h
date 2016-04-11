//
//  Issue.h
//  Assignment 8
//
//  Created by Hari Panjwani on 4/8/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Issue : NSObject

@property (nonatomic) NSString *createdAt;
@property (nonatomic) NSString *updatedAt;
@property (nonatomic) NSString *closedAt;

@property (nonatomic) NSString *url;
@property (nonatomic) NSString *repository_url;

@property (nonatomic) NSString *issueID;
@property (nonatomic) NSString *number;
@property (nonatomic) NSString *title;
@property (nonatomic) NSString *state;
@property (nonatomic) NSString *body;
@property (nonatomic) NSString *comments;
@property (nonatomic) NSString *comments_url;


@end
