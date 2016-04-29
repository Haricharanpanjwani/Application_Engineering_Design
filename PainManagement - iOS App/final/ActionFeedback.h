//
//  ActionFeedback.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ActionFeedback : NSObject{
    NSString *actionId;
    NSInteger programId;
    NSInteger userId;
    NSString *answerValue;
}

@property(nonatomic,strong) NSString *actionId;
@property(nonatomic) NSInteger programId;
@property(nonatomic) NSInteger userId;
@property(nonatomic,strong) NSString *answerValue;

@end
