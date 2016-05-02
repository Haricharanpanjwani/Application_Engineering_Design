//
//  Feedback.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "Feedback.h"

@implementation Feedback
@synthesize feedbackId,questionId,answerType,answerValue,userId;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n questionId : %li, \nAnswer value: %@, \nAnswer type: %@, \nUserid: %li,\nFeedbackid: %@", (long)self.questionId,self.answerValue,self.answerType,(long)self.userId,self.feedbackId];
}

@end
