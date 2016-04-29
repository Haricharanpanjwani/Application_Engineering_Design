//
//  Answer.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Answer : NSObject
{
    NSInteger answerid;
    NSString *answertype;
    NSString *answerdetail;
}


@property(nonatomic)NSInteger answerid;
@property(nonatomic,strong)NSString *answertype;
@property(nonatomic,strong)NSString *answerdetail;

@end
