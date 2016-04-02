//
//  NSString+Read.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "NSString+Read.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@implementation NSString (Read)

/*  Define a method readString, whoes function is to take
    input from user and return the value as NSString    */
- (NSString*) readString {
    
    char name[50];
    scanf("%s", name);
    return [NSString stringWithUTF8String:name];
}

@end