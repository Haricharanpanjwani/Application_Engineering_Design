//
//  ProgramDetails.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ProgramDetails : NSObject
{
    NSInteger programId;
    NSString *programName;
    NSString *programDetails;
    NSString *programUrl;
    NSInteger subCategory;
    
}

@property(nonatomic)NSInteger programId;
@property(nonatomic,strong)NSString *programName;
@property(nonatomic,strong)NSString *programDetails;
@property(nonatomic,strong)NSString *programUrl;
@property(nonatomic)NSInteger subCategory;

@end
