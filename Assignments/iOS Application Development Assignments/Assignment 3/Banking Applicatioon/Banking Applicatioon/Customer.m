//
//  Customer.m
//  Banking Applicatioon
//
//  Created by Hari Panjwani on 2/12/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "Customer.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
 */

@implementation Customer

/* Method definition is given for withdraw function, It is going to minus the
 amount withdrawn by the user which is passed as argument and the function
 is goint to return the updated balance in the account   */
-(id)init
{
    self = [super init];
    /* This part is initializing the account class, the purpose of initializing it over 
        here is, as soon as customer class is initialized account class will also be initialized     */
    account = [[Account alloc]init];
    return self;
}

/*  This line tells the compiler to create a setter and getter for firstName or all the instance variable for which you will write it, and that they should use the firstName for those method. Without the = firstName part, the compiler would assume that the property and use _firstName.
 */
@synthesize firstName;
@synthesize lastName;
@synthesize account;

@end
