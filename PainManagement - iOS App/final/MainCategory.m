//
//  MainCategory.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "MainCategory.h"

@implementation MainCategory
@synthesize subcategoryModelList,categoryName;

-(id)init
{
    self = [super init];
    if(self)
    {
        subcategoryModelList = [[NSMutableArray alloc]init];
    }
    
    return self;
}


-(void)addContact:(SubCategory *)subCategory{
    [self.subcategoryModelList addObject:subCategory];
}
-(NSMutableArray*)returnSubcategoryModelList{
    return self.subcategoryModelList;
}

@end
