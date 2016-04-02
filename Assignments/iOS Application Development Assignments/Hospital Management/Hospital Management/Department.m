//
//  Department.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/19/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "Department.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@implementation Department

/* Initialization sets the instance variables of an object to reasonable and useful initial values.
 It can also allocate and prepare other global resources needed by the object, loading them if
 necessary from an external source such as a file. Every object that declares instance variables
 should implement an initializing method—unless the default set-everything-to-zero initialization
 is sufficient. If an object does not implement an initializer, Cocoa invokes the initializer
 of the nearest ancestor instead.   */
- (id) init {
    
    self = [super init];
    // Initializing the mutuable array which was declared in the interface file.
    return self;
}
/*  This line tells the compiler to create a setter and getter for deptName or all the instance variable for which you will write it, and that they should use the deptName for those method. Without the = deptName part, the compiler would assume that the property and use _deptName.
 */
@synthesize deptName;

//  Descriptor method is define which is going to return the department name
- (NSString *)description    {
    
    return [NSString stringWithFormat:@"Department %@", self.deptName];
}


@end
