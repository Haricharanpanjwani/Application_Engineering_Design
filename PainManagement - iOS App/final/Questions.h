//
//  Questions.h
//  final
//
//  Created by 谢菊萍 on 11/9/15.
//  Copyright © 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Questions : NSObject
{
    NSInteger questionId;
    NSString *questionDetails;
    NSInteger answerId;
}

@property(nonatomic) NSInteger questionId;
@property(nonatomic, strong) NSString *questionDetails;
@property(nonatomic) NSInteger answerId;

@end
