//
//  SubCategory.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "SubCategory.h"

@implementation SubCategory
@synthesize programDetailsList,subCategoryname;

-(id)init
{
    self = [super init];
    if(self)
    {
        programDetailsList = [[NSMutableArray alloc]init];
    }
    
    return self;
}


-(void)addContact:(ProgramDetails *)programDetails{
    [self.programDetailsList addObject:programDetails];
}
-(NSMutableArray*)returnProgramDetailsList{
    return programDetailsList;
}

@end
