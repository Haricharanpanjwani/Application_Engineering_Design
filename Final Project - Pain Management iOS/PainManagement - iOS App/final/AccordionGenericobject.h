//
//  AccordionGenericobject.h
//  SidebarDemo
//
//  Created by Priya Dilipkumar Poptani on 4/30/15.
//  Copyright (c) 2015 Appcoda. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef enum{
    
    OBJECT_TYPE_PROGRAM=0,
    OBJECT_TYPE_SUBPROGRAM
    
}objectType;


@interface AccordionGenericobject : NSObject{
    NSMutableArray *children;
}

@property(nonatomic,strong) NSString *name;
@property(nonatomic,strong) NSString *parent;
@property(nonatomic) BOOL canBeExpanded;
@property(nonatomic) BOOL isExpanded;
@property(nonatomic) NSInteger level;
@property(nonatomic) int type;
@property(nonatomic, strong) NSMutableArray *children;

@end
