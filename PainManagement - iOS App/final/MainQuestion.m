//
//  Questions.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "MainQuestion.h"

@implementation MainQuestion
@synthesize questionId,questionDetails,answerId,instructionList,answertype,answerdetail;

-(id)init
{
    self = [super init];
    if(self){
        instructionList =[[NSMutableArray alloc]init];
    }
    return self;
}

-(void)addInstruction:(Instrcutions *)instructions{
    [self.instructionList addObject:instructions];
}

-(NSMutableArray*) returninstructionList{
    return self.instructionList;
}

-(NSString *)description{
    return [NSString stringWithFormat:@"\n questionId : %li \nQuestion details: %@", (long)self.questionId,self.questionDetails];
}

@end
