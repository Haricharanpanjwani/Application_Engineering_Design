//
//  Patient.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//


#import "Patient.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@implementation Patient

/* Initialization sets the instance variables of an object to reasonable and useful initial values.
 It can also allocate and prepare other global resources needed by the object, loading them if
 necessary from an external source such as a file. Every object that declares instance variables
 should implement an initializing method—unless the default set-everything-to-zero initialization
 is sufficient. If an object does not implement an initializer, Cocoa invokes the initializer
 of the nearest ancestor instead.   */
-(id)init
{
    self = [super init];
    /* This part is initializing the account class, the purpose of initializing it over
     here is, as soon as customer class is initialized account class will also be initialized     */
    
    medicalRecord = [NSMutableArray array];
    return self;
}

/*  This line tells the compiler to create a setter and getter for medicalRecord or all the instance variable for which you will write it, and that they should use the medicalRecord for those method. Without the = medicalRecord part, the compiler would assume that the property and use _medicalRecord.
 */
@synthesize primaryPhysician;
@synthesize medicalRecord;


//  Descriptor method is define which is going to return the patients profile
- (NSString *)description    {
    return [NSString stringWithFormat:@"Patient details are as follows: \nFirst Name: %@ \nLast Name: %@ \nSSN: %d \nDate of Birth: %@ \nPhone Number: %ld \nStreet Number: %d \nStreet Name: %@  \nCity: %@ \nState: %@ \nZip Code: %d \nPrimary Physician: %@ \nImage Name: %ld", [self firstName], [self lastName], [self ssn], [self dob], [self phoneNumber], [self streetNumber], [self streetName], [self city], [self state], [self zipCode], [self primaryPhysician], (long)[self imageName]];
}

/*  Define a method updateMedicalRecord which take input as patient and take
    the input for all the vitalSign and appointment and stored in an array */

@end
