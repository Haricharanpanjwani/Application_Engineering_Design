//
//  Account.m
//  Banking Applicatioon
//
//  Created by Hari Panjwani on 2/12/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "Account.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
 */

@implementation Account

/*  This line tells the compiler to create a setter and getter for accountNumber or all the instance variable for which you will write it, and that they should use the accountNumber for those method. Without the = accountNumber part, the compiler would assume that the property and use _accountNumber. 
 */
@synthesize accountNumber;
@synthesize balance;
@synthesize transaction;

/* Initialization sets the instance variables of an object to reasonable and useful initial values.
 It can also allocate and prepare other global resources needed by the object, loading them if 
 necessary from an external source such as a file. Every object that declares instance variables
 should implement an initializing method—unless the default set-everything-to-zero initialization 
 is sufficient. If an object does not implement an initializer, Cocoa invokes the initializer 
 of the nearest ancestor instead.   */
- (id) init {
    
    self = [super init];
    // Initializing the mutuable array which was declared in the interface file.
    transaction = [NSMutableArray array];
    return self;
}

/*  Method definiton for setAccountNumber is given, It is
    using a ARC4random function to generate a 10 digit random number
    for setting up a account number */
- (void) setAccountNumber {
    accountNumber = arc4random() % 500000000 + 1000000000;
}

/* Method definition is given for getAccountNumber,
    It is going to return the account number of the user */
- (int) getAccountNumber {
    return accountNumber;
}

/* Method definition is given for getBalance,
 It is going to return the current balance of the user */
- (double) getBalance {
    return balance;
}

/* Method definition is given for withdraw function, It is going to minus the
    amount withdrawn by the user which is passed as argument and the function
    is goint to return the updated balance in the account   */
- (double) withdraw:(double)amount {
    
    //  this condition is going to check if the amount withdrawn
    //  is less than the amount present in the account.
    if(amount <= balance) {
        balance  = balance - amount;
        return balance;
    } else {
        NSLog(@"There is no sufficient balance to withdraw!!");
        return 0;
    }
}

/* Method definition is given for deposit function, It is going to add the
 amount deposited by the user which is passed as argument and the function
 is goint to return the updated balance in the account   */
- (double) deposit:(double)amount {
    balance  = balance + amount;
    return balance;
}

@end
