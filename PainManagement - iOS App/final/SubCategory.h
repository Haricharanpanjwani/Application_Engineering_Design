//
//  SubCategory.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ProgramDetails.h"

@interface SubCategory : NSObject
{
    NSMutableArray *programDetailsList;
    NSString *subCategoryname;
}

@property(nonatomic,strong) NSMutableArray *programDetailsList;
@property(nonatomic,strong)NSString *subCategoryname;

-(void)addContact:(ProgramDetails *)programDetails;
-(NSMutableArray*)returnProgramDetailsList;

@end
