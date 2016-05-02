//
//  QuestionType.m
//  final
//
//  Created by apple on 6/29/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "QuestionType.h"

@implementation QuestionType
@synthesize type;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n \nquestion type: %@",self.type];
}



@end
