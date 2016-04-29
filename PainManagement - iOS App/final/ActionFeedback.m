//
//  ActionFeedback.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "ActionFeedback.h"

@implementation ActionFeedback
@synthesize actionId,programId,userId,answerValue;


-(NSString *)description{
    return [NSString stringWithFormat:@"\n programId : %li, \answerValue: %@, \nactionId: %@ , \nuserId: %li", (long)self.programId,self.answerValue,self.actionId, (long)self.userId];
}
@end
