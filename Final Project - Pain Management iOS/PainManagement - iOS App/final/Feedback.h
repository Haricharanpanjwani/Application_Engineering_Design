//
//  Feedback.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Feedback : NSObject
{
    NSString *feedbackId;
    NSInteger questionId;
    NSString *answerValue;
    NSInteger userId;
    NSString *answerType;
}

@property(nonatomic,retain)NSString *feedbackId;
@property(nonatomic)NSInteger questionId;
@property(nonatomic,strong)NSString *answerValue;
@property(nonatomic)NSInteger userId;
@property(nonatomic,strong)NSString *answerType;


@end
