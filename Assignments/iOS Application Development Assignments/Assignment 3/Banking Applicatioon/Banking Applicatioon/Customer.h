//
//  Customer.h
//  Banking Applicatioon
//
//  Created by Hari Panjwani on 2/12/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Account.h"     //Importing a Account class so that we can use it in the customer class. '<>' angular brackets are used for importing the pre-definie class in Objective-C and "" quotes are use for importing the user defined classes.

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
 */

@interface Customer : NSObject {
    
    /*  Declaring a variable firstName of object type 
        NSString to store the first name of the customer. */
    NSString *fristName;
    
    /*  Declaring a variable firstName of object type
     NSString to store the last name of the customer. */
    NSString *lastName;
    
    //  Declaring a Account class, which is unique to every customer
    Account *account;
    
}

/*  @property provides a syntactical shorthand for declaring a class’s
 accessor methods and, optionally, implementing them. */

/*  We are declaring property for all the instance variable like
    first name, last name and account class which we define in the 
    upper part of the interface     */
@property NSString *firstName;
@property NSString *lastName;
@property Account* account;

@end
/*  This defines an end of the interface, where all the instance variable
 and method declaration has happened. */
