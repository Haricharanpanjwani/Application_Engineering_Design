//
//  main.m
//  Banking Applicatioon
//
//  Created by Hari Panjwani on 2/12/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import <Foundation/Foundation.h>
#import "Customer.h"   //Importing a Customer class so that we can use it in the main class. '<>' angular brackets are used for importing the pre-definie class in Objective-C and "" quotes are use for importing the user defined classes.

/*  int main() is the main function where program execution
 begins. This is the entry point for the application.    */
int main(int argc, const char * argv[]) {
    
    /*  This is an autorelease block. At the end of the autorelease pool block,
     objects that received an autorelease message within the block are sent
     a release message—an object receives a release message for each time it
     was sent an autorelease message within the block.   */
    @autoreleasepool {
        
        /*  input variable of datatype int is declare for taking the input from the user for
            which function he/she wants to perform.     */
        int input;
        /*  name  variable of datatype char and length 50 is declare for taking the
            input from the user for the firstName and lastName  */
        char name[50];
        /*  balance  variable of datatype double is declare for taking the
         current balance of the customer    */
        double balance;
        
        /*  type variable of datatype char and length 1 is declare for taking the
         input from the customer for what type oftransaction, he wants to perform (deposit/withdrawn)   */
        char type;
        
        /*  transactionAmount  variable of datatype double is declare for taking the
         transaction amount which customer entered for Withdrawing/Deposit.     */
        double transactionAmount;
        // NSNumber object is created for the transactionAmount, so that it can be stored in an Array.
        NSNumber* amount;
        
        /*  updatedBalance variable of datatype double is declare for taking the
         current updated balance of the customer after transaction    */
        double updatedBalance = 0;
        // NSNumber object is created for the updatedBalance, so that it can be stored in an Array.
        NSNumber* updateBalance;
        
        //  deposit and withdraw of dataype int is declared to keep track of number of deposit and withdrawn in any transaction.
        int deposit = 0;
        int withdraw = 0;
        
        //  Creating a object of customer class
        Customer *customer;
        
        //  Menu option for the customer, what action he wants to perform.
        // 1. enter the customer name
        // 2. Make Transactions
        // 3. Exit the application
        NSLog(@"\nWelcome to the Bank! \n What you want to do, Please select your option? \n 1. Enter new customer \n 2. Make Transaction \n 3. Exit");
        //  Taking the input for the same.
        scanf("%d", &input);
        
        /* While condition is put on the customer input, it will exist the application
            if the input is anything other than 1, 2 or 3   */
        while(input < 4) {
            
        // Switch statement is used based on the customer input, what he wants to do
        switch (input) {
            
            //  This case is to take the customer first and last name, setting up a account number and take the starting amount for the account.
            case 1:
                
                // Checking if customer name is nil, the below loop will run if only the name is not already setup
                if(customer.firstName == nil) {
                
                // Initiazing the customer class
                customer = [[Customer alloc] init];
                
                // Asking user to enter the first name
                NSLog(@"\nPlease enter your first name?");
                scanf("%s", name);
                //  Setting the input in the customer class, so that it can be retrieve later.
                customer.firstName = [NSString stringWithUTF8String:name];
                    
                // Asking user to enter the last name
                NSLog(@"\nPlease enter your last name?");
                scanf("%s", name);
                //  Setting the input in the customer class, so that it can be retrieve later.
                customer.lastName = [NSString stringWithUTF8String:name];
                
                // Asking user to enter the starting balance for account.
                NSLog(@"\nPlease enter customer balance?");
                scanf("%lf", &balance);
                
                /* This condition will check if user has input the balance is positiv or not.
                    If it is negative, it is going to ask the user to insert again  */
                if(balance <= 0) {
                    NSLog(@"\nInvalid Amount!! Please enter only integers!");
                    NSLog(@"\nPlease enter customer balance again?");
                    scanf("%lf", &balance);
                }
                
                /*  Setting the balance in the account class, which is accessed through
                    customer class so that it can be retrieve later.    */
                customer.account.balance = balance;
                
                //  balance is double type variable we are changing it to NSNumber type object, so that we can store it in array.
                amount = [NSNumber numberWithDouble:(balance)];
                //  Starting balance is stored in array so that we can use it while printing the statement.
                [customer.account.transaction addObject:amount];
                
                // updating the updatedBalance varaible which is used in case 2, for performing the transaction.
                updatedBalance = balance;
                
                //  Account number is set for the customer by calling setAccountNumber function.
                [customer.account setAccountNumber];
                NSLog(@"\nAccount Number: %d", [customer.account getAccountNumber]);
                
                
                NSLog(@"\nWelcome to the Bank! \n What you want to do, Please select your option? \n 1. Enter new customer \n 2. Make Transaction \n 3. Exit");
                scanf("%d", &input);
                }
                //  If the customer name is already there. The below loop is going to print the name of the customer, amount in the account and the account number.
                else {
                    NSLog(@"Customer is already entered.");
                    
                    NSLog(@"%@, %@ your current balance is: %f \n Account Number: %d", customer.firstName, customer.lastName, [customer.account getBalance], [customer.account getAccountNumber]);
                    NSLog(@"\nWelcome to the Bank! \n What you want to do, Please select your option? \n 1. Enter new customer \n 2. Make Transaction \n 3. Exit");
                    scanf("%d", &input);
                }
                break;
                
            case 2:
                
                //  If customer name is not set, this condition going to redirect to case 1.
                if(customer.firstName == nil) {
                    NSLog(@"Please enter customer details!! Try Again!!");
                    input = 1;
                }
                // If customer name is there, we can move forward and perform transaction.
                else {
                
                // Menu Item. Whether customer want to Deposit or Withdraw the amount or he can exit as well.
                NSLog(@"\nDo you want to depoist or withdraw? \n 1.Press W to Withdraw.\n 2. Press D to Deposit.\n 3. Press E to exit");
                //  Taking the input for the same.
                scanf("%s", &type);
                
                //transactionAmount is initialize to zero, so that transaction should be accurate
                transactionAmount = 0;
                
                //  This condition is to check whether use want to perform withdrawal
                if(type == 'w' || type == 'W') {
                    
                    //  Asking the customer for amount which he wants to withdraw
                    NSLog(@"\nEnter the amount you want to withdraw ?");
                    scanf("%lf", &transactionAmount);
                    
                    //If the amount entered is greater than zero and available balance in the account is also greater than zero, enter the loop
                    if(transactionAmount > 0 && updatedBalance > 0) {
                        //withdraw function from account class is called, which is going to perform the action and return the updatedBalance in the account.
                        updatedBalance = [customer.account withdraw: transactionAmount];
                        
                        
                        //  If the returned updatedBalance is greater than zero, enter the loop
                        if(updatedBalance >= 0) {
                            
                            //  transactionAmount is double type variable we are changing it to NSNumber type object, so that we can store it in array.
                            amount = [NSNumber numberWithDouble:(-transactionAmount)];
                            // adding the object to array, the amount which is withdrawn
                            [customer.account.transaction addObject:amount];
                            
                            //  updatedBalance is double type variable we are changing it to NSNumber type object, so that we can store it in array.
                            updateBalance = [NSNumber numberWithDouble:(updatedBalance)];
                            // adding the object to array, the updated balance of the account
                            [customer.account.transaction addObject:updateBalance];
                            
                            NSLog(@"\nYou have withdrawn the amount: %f", transactionAmount);
                            NSLog(@"\nBalance in your account is: %f", updatedBalance);
                        }
                        //  If transaction fails, it is going to print insufficient balance!!
                        else {
                             NSLog(@"There is no sufficient balance to withdraw!!");
                        }
                    }
                    //  If the amount entered is not greater than zero and available balance in the account is also not greater than zero, else condition will be executed
                    else {
                        NSLog(@"\nInvalid Amount!! Please enter only integers!");
                    }
                }
                //  This condition is to check whether use want to perform deposit
                else if(type == 'd' || type == 'D') {
                    
                    NSLog(@"Enter the amount you want to deposit ?");
                    scanf("%lf", &transactionAmount);
                    
                    //If the amount entered is greater than zero, enter the loop
                    if(transactionAmount > 0) {
                        //  deposit function from account class is called, which is going to perform the action and return the updatedBalance in the account.
                        updatedBalance = [customer.account deposit: transactionAmount];
                        
                        //  transactionAmount is double type variable we are changing it to NSNumber type object, so that we can store it in array.
                        amount = [NSNumber numberWithDouble:(transactionAmount)];
                        // adding the object to array, the amount which is deposited
                        [customer.account.transaction addObject:amount];
                        
                        //  updatedBalance is double type variable we are changing it to NSNumber type object, so that we can store it in array.
                        updateBalance = [NSNumber numberWithDouble:(updatedBalance)];
                        // adding the object to array, the updated balance of the account
                        [customer.account.transaction addObject:updateBalance];
                        
                        NSLog(@"You have successfully deposited the amount: %f", transactionAmount);
                        NSLog(@"Balance in your account is: %f", updatedBalance);
                    }
                    //  If the amount entered is not greater than zero, it will enter the else loop
                    else {
                        NSLog(@"Invalid Amount or you don't have sufficient balance in your account!!");
                    }

                }
                //  This condition is executed when customer is existed.
                else if(type == 'e' || type == 'E') {
                    input = 3;
                }
                else {
                    NSLog(@"\nInvalid Selection!!");
                }
                }
                break;
                
            case 3:
                
                //  If customer name is not set, this condition going to exist from the application.
                if(customer.firstName == nil) {
                    exit(0);
                }

                //  print the name of the customer, amount in the account and the account number.
                NSLog(@"%@, %@ your current balance is: %f \n Account Number: %d", customer.firstName, customer.lastName, [customer.account getBalance], [customer.account getAccountNumber]);

                transactionAmount = [[customer.account.transaction objectAtIndex: 0] doubleValue];
                
                //  Printing the bank statement of the customer.
                NSLog(@"Bank Statement");
                NSLog(@"---------------------------------------");
                //  Starting balance of the customer.
                NSLog(@"Starting balance: %f", transactionAmount);
                
                //  Printing the customer transaction from the transaction array.
                for(int i=1; i<customer.account.transaction.count; i = i+2) {
                    transactionAmount = 0;
                    transactionAmount = [[customer.account.transaction objectAtIndex: i] doubleValue];
                    double balanceAmount = [[customer.account.transaction objectAtIndex: (i+1)] doubleValue];;
                    //  This condition is going to print the deposited amount.
                    if(transactionAmount > 0) {
                        //  Transaction Amount
                        NSLog(@"Deposited Amount: %f", transactionAmount);
                        //  Amount after transaction
                        NSLog(@"Balance after transaction is: %f", balanceAmount);
                        deposit++;
                    }
                    //  This condition is going to print the withdraw amount.
                    else {
                        //  Transaction Amount
                        NSLog(@"Withdrwan Amount: %f", -transactionAmount);
                        //  Amount after transaction
                        NSLog(@"Balance after transaction is: %f", balanceAmount);
                        withdraw++;
                    }
                }
                //  This line is going to print the total number of desposited and withdrawn transaction
                NSLog(@"Total Number of Withdraw: %d \n Total Number of Deposit: %d", withdraw, deposit);
                
                NSLog(@"You have successfully completed the transactions!");
                
                //  Exit from the application.
                exit(0);

                break;
                
            default:
                //  Exit from the application if the input is else from 1, 2 or 3!!
                NSLog(@"Invalid selecton you have been exited from application!!");
                exit(0);
                break;
        }
        }
            NSLog(@"Invalid selecton you have been exited from applicationssssss!!");
    }
    return 0;
}
