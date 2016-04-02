//
//  Patient.h
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import <Foundation/Foundation.h>
#import "Person.h"
#import "MedicalRecord.h"
#import "NSString+Read.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@interface Patient : Person <NSCoding>  {
    
    NSString *primaryPhysician;
    NSMutableArray *medicalRecord;
    
}

/*  @property provides a syntactical shorthand for declaring a class’s
 accessor methods and, optionally, implementing them. */

/*  We are declaring property for all the instance variable like
 primary physician and medical record class which we define in the
 upper part of the interface     */
@property NSString *primaryPhysician;
@property NSMutableArray *medicalRecord;

//  Declare a method updateMedicalRecord which take input as patient
- (void) updateMedicalRecord: (Patient*)p;

//  Declare a method viewMedicalRecord which take input as patient
- (void) viewMedicalRecord: (Patient*)p;

@end
