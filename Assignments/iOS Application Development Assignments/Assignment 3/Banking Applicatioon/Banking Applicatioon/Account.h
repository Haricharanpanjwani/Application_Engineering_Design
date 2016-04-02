//
//  Account.h
//  Banking Applicatioon
//
//  Created by Hari Panjwani on 2/12/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <Foundation/Foundation.h>

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation. 
 You typically split the interface and implementation into two separate files—the 
 header file and the implementation file.
 */
@interface Account : NSObject {

    //  Declaring a variable accountNumber of datatype int to store the account number of the customer.
    int accountNumber;
    
    //  Declaring a variable balance of datatype double to store the starting balance of customer.
    double balance;
    
    //  Declaring a mutuable array to store the transactions done by the customer.
    NSMutableArray *transaction;
}

/*  @property provides a syntactical shorthand for declaring a class’s 
    accessor methods and, optionally, implementing them. */

/*  We are declaring property for all the instance variable like
    account number, balance and mutuable array transaction */
@property int accountNumber;
@property double balance;
@property NSMutableArray *transaction;

/* Method declaration is done here. A class method is a method that
    operates on class objects rather than instances of the class. */

/* A method is declared for setting up a account number
    of the user which will have return type as void */
- (void) setAccountNumber;

/* A method is declared for getting a account number
    of the user which will have return type as int */
- (int) getAccountNumber;

/* A method is declared for getting a current balance
    of the user which will have return type as double */
- (double) getBalance;

/* A method is declared for withdrawing a amount, whenever user
    will make the transaction, it has return type as double and
    it take the argument as double  */
- (double) withdraw: (double)amount;

/* A method is declared for depositing a amount, whenever user
 will make the transaction, it has return type as double and
 it take the argument as double  */
- (double) deposit: (double)amount;

@end
/*  This defines an end of the interface, where all the instance variable
 and method declaration has happened. */