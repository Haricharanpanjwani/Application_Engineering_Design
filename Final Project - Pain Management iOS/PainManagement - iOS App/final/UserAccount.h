//
//  UserAccount.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface UserAccount : NSObject
{
    NSInteger userId;
    NSString *username;
    NSString *password;
}

@property(nonatomic)NSInteger userId;
@property(nonatomic,strong)NSString *username;
@property(nonatomic,strong)NSString *password;


@end
