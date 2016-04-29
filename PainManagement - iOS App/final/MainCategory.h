//
//  MainCategory.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//


#import <Foundation/Foundation.h>
#import "SubCategory.h"

@interface MainCategory : NSObject
{
    NSMutableArray *subcategoryModelList;
    NSString *categoryName;
}

@property(nonatomic,strong)NSMutableArray *subcategoryModelList;
@property(nonatomic,strong)NSString *categoryName;

-(void)addContact:(SubCategory *)subCategory;
-(NSMutableArray*)returnSubcategoryModelList;


@end


