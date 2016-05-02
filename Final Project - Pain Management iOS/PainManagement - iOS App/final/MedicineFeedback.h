//
//  MedicineFeedback.h
//  final
//
//  Created by apple on 5/31/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface MedicineFeedback : NSObject
{
    NSString *date;
    NSInteger mpId;
    NSString *timestamp;
    NSString *mHistory;
    NSInteger totalAmount;
}
@property(nonatomic,retain)NSString *date;
@property(nonatomic,retain)NSString *timestamp;
@property(nonatomic,retain)NSString *mHistory;
@property(nonatomic)NSInteger mpId;
@property(nonatomic)NSInteger totalAmounts;

@end
