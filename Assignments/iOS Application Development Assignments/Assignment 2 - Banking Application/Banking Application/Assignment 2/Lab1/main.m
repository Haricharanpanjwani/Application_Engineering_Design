//
//  main.m
//  Lab1
//
//  Created by Hari Panjwani on 2/6/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

/*  Import is a preprocessor command, which tells a Objective-C compiler
    to include Foundation.h file before going to actual compilation.     */
#import <Foundation/Foundation.h>

/*  int main() is the main function where program execution 
    begins. This is the entry point for the application.    */
int main(int argc, const char * argv[]) {
    
    /*  This is an autorelease block. At the end of the autorelease pool block, 
        objects that received an autorelease message within the block are sent 
        a release message—an object receives a release message for each time it 
        was sent an autorelease message within the block.   */
    @autoreleasepool {
        
        /*  NSLog is a function available in Objective-C which causes
            the message written within it, to be displayed on the screen. */
        //  '@' is the directive to the compiler.
        //  The below statement ask user for the input.
        NSLog(@"Please enter your name?");
        
        // Declaring a character type array of length 40, where user name is stored.
        char name[40];
        
        //scanf is used for getting the input from user through console.
        scanf("%s",name);
        
        /*  An NSString object encodes a Unicode-compliant text string, represented as a sequence 
            of UTF–16 code units. All lengths, character indexes, and ranges are expressed in terms
            of 16-bit platform-endian values, with index values starting at 0. */
        /*  stringWithUTF8String - Returns a string created by copying the data from a
            given C array of UTF8-encoded bytes. */
        NSString *userName = [NSString stringWithUTF8String:name];
        
        /*  NSLog is a function available in Objective-C which causes
            the message written within it, to be displayed on the screen. */
        //  Below line welcome the user to application with it's name, which was taken as input from it.
        NSLog(@"Good Morning %@, Welcome to the first program in Objective C \n All the best!!", userName);
    
/*  This is the end of auto release pool here. All the objects that received 
    an auto release message, will be released and memory would be free.     */
    }
    
    //This is the termination point of main()function and returns the value 0.
    return 0;
}
