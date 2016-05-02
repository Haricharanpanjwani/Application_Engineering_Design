//
//  Instrcutions.h
//  final
//
//  Created by 谢菊萍 on 11/9/15.
//  Copyright © 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Instrcutions : NSObject
{
    NSInteger instructionId;
    NSInteger answerId;
    NSString *instructionDetail;
}

@property(nonatomic,strong) NSString *instructionDetail;
@property(nonatomic) NSInteger instructionId;
@property(nonatomic) NSInteger answerId;

@end
