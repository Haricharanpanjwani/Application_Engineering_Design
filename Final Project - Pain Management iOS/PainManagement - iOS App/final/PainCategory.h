//
//  PainCategory.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PainCategory : NSObject
{
    NSInteger painId;
    NSString *painName;
    NSString *painDescription;
}

@property(nonatomic) NSInteger painId;
@property(nonatomic,strong) NSString *painName;
@property(nonatomic,strong) NSString *painDescription;


@end
