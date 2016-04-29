//
//  Profile.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 10/8/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "Profile.h"

@implementation Profile
@synthesize question,answer;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n question : %@, \nanswer: %@", self.question,self.answer];
}


@end
