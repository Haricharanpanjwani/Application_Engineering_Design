//
//  PainCategory.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "PainCategory.h"

@implementation PainCategory
@synthesize painDescription,painId,painName;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n pain Id : %li, \npain Description: %@, \npainName: %@", (long)self.painId,self.painDescription,self.painName];
}

@end
