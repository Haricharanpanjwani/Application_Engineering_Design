//
//  UserAccount.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "UserAccount.h"

@implementation UserAccount
@synthesize userId,username,password;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n userId : %li \nUsername: %@", (long)self.userId,self.username];
}

@end
