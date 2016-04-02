//
//  Person.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "Person.h"
#import "NSString+Read.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@implementation Person

/*  This line tells the compiler to create a setter and getter for firstName or all the instance variable for which you will write it, and that they should use the firstName for those method. Without the = firstName part, the compiler would assume that the property and use _firstName.
 */
@synthesize firstName;
@synthesize lastName;
@synthesize ssn;
@synthesize dob;
@synthesize phoneNumber;
@synthesize streetNumber;
@synthesize streetName;
@synthesize aptNo;
@synthesize city;
@synthesize state;
@synthesize zipCode;


//  Descriptor method is define which is going to return the person's profile
- (NSString *) description    {
    return [NSString stringWithFormat:@"This is a person class. It is going to display the detail of person%@", [self firstName]];
}

@end