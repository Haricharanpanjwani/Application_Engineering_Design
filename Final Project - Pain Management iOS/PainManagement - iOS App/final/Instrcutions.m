//
//  Instrcutions.m
//  final
//
//  Created by 谢菊萍 on 11/9/15.
//  Copyright © 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "Instrcutions.h"

@implementation Instrcutions
@synthesize instructionDetail,instructionId,answerId;


-(NSString *)description{
    return [NSString stringWithFormat:@"\n instructionId : %li, \n instructionDetail: %@, \n answerId: %li", (long)self.instructionId,self.instructionDetail, (long)self.answerId];
}

@end
