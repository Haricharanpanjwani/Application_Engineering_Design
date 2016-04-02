//
//  Person.h
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@interface Person : NSObject <NSCoding>{

    NSString *firstName;
    NSString *lastName;
    int ssn;
    NSDate *dob;
    long phoneNumber;
    int streetNumber;
    NSString *streetName;
    NSString *city;
    NSString *state;
    int zipCode;
    UIImage *imageName;

}

/*  @property provides a syntactical shorthand for declaring a class’s
 accessor methods and, optionally, implementing them. */

/*  We are declaring property for all the instance variable like
 firstName, lastName and ssn record class which we define in the
 upper part of the interface     */
@property NSString *firstName;
@property NSString *lastName;
@property int ssn;
@property NSDate *dob;
@property long phoneNumber;
@property int streetNumber;
@property NSString *streetName;
@property int aptNo;
@property NSString *city;
@property NSString *state;
@property int zipCode;
@property UIImage *imageName;


@end
