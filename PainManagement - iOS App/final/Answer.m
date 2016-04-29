//
//  Answer.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "Answer.h"

@implementation Answer
@synthesize answerdetail, answerid, answertype;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n AnswerId : %li, \nAnswer Details: %@, \nAnswer Type: %@", (long)self.answerid,self.answerdetail,self.answertype];
}

@end
