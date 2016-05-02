//
//  Profile.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 10/8/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Profile : NSObject
{
    NSString *question;
    NSString *answer;
}

@property(nonatomic,strong) NSString *question;
@property(nonatomic,strong) NSString *answer;

@end
