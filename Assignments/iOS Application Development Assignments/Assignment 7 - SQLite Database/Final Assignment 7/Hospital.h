//
//  Hospital.h
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import <Foundation/Foundation.h>
#import "Patient.h"
/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@interface Hospital : NSObject {
    
    NSString *hospitalName;
    //  Declaring a mutuable array to store the patient list.
    NSMutableArray *patientList;
}

/*  @property provides a syntactical shorthand for declaring a class’s
 accessor methods and, optionally, implementing them. */

/*  We are declaring property for all the instance variable like
 hospital name and patient list class which we define in the
 upper part of the interface     */
@property NSString *hospitalName;
@property NSMutableArray *patientList;


//  Declare a addPatient method for adding the patient to the hospital
- (void) addPatient: (Patient *)patient;

//  Declare a searchPatient method for searching the patient in the hospital
- (Patient*) searchPatient: (NSString *)name;

//  Declare a listOfPatients method for displaying the list of patient in the hospital
- (void) listOfPatients;

@end
