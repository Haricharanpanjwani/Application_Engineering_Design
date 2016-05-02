//
//  Questions.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Instrcutions.h"

@interface MainQuestion : NSObject
{
    NSInteger questionId;
    NSString *questionDetails;
    NSInteger answerId;
    NSString *answertype;
    NSString *answerdetail;
    NSMutableArray *instructionList;
}

@property(nonatomic) NSInteger questionId;
@property(nonatomic, strong) NSString *questionDetails;
@property(nonatomic) NSInteger answerId;
@property(atomic,strong)NSMutableArray *instructionList;
@property(nonatomic,strong)NSString *answertype;
@property(nonatomic,strong)NSString *answerdetail;

-(void)addInstruction:(Instrcutions *)instructions;
-(NSMutableArray*) returninstructionList;

@end
