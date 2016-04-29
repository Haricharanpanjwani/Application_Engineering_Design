//
//  AccordionGenericobject.m
//  SidebarDemo
//
//  Created by Priya Dilipkumar Poptani on 4/30/15.
//  Copyright (c) 2015 Appcoda. All rights reserved.
//

#import "AccordionGenericobject.h"

@implementation AccordionGenericobject
@synthesize children;

-(NSMutableArray*)children{
    if(!children){
        children = [[NSMutableArray alloc] init];
    }
    return children;
}

@end
