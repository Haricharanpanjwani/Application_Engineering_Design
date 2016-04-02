//
//  Hospital.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import "Hospital.h"

/*
  A class definition is the specification of a class of objects through the use of certain files and syntax.
  A class definition minimally consists of two parts: a public interface, and a private implementation.
  You typically split the interface and implementation into two separate files—the
  header file and the implementation file.
*/
@implementation Hospital

/*  This line tells the compiler to create a setter and getter for hospitalName or all the instance variable for which you will write it, and that they should use the hospitalName for those method. Without the = hospitalName part, the compiler would assume that the property and use _hospitalName.
 */
@synthesize hospitalName;
@synthesize patientList;

/* Initialization sets the instance variables of an object to reasonable and useful initial values.
 It can also allocate and prepare other global resources needed by the object, loading them if
 necessary from an external source such as a file. Every object that declares instance variables
 should implement an initializing method—unless the default set-everything-to-zero initialization
 is sufficient. If an object does not implement an initializer, Cocoa invokes the initializer
 of the nearest ancestor instead.   */
- (id) init {
    
    self = [super init];
    // Initializing the mutuable array which was declared in the interface file.
    patientList = [NSMutableArray array];
   
    return self;
}

// Descriptor method is define which is going to return the menu options
- (NSString *)description    {
    
    return [NSString stringWithFormat:@"Welcome to %@! Hello Admin, What you want to do, Please select your option? \n 1. Add New Patient \n 2. Search for Patient \n 3. List of All Patients \n 4. Add Medical Record \n 5. View Medical Records of Patient \n 6. Add Department \n 7. List of Department \n 8. Exit", self.hospitalName];
}

//  defining a addPatient method for adding the patient to the hospital
- (void) addPatient: (Patient *)patient {
    
    [patientList addObject:patient];
    
    NSLog(@"Patient added successfully!!");
    
    NSLog(@"%@ ", patient);
    
}

//  Defining a searchPatient method for searching the patient in the hospital
- (Patient*) searchPatient: (NSString *) name {
    
    int flag = 0;
    
    //NSLog(@"Please enter the first or the last name of the patient");
    //NSString *name = [nr readString];
    
    NSLog(@"Searched Patient is: ");
    
    for(Patient *p in patientList) {
        
        NSComparisonResult resultFirst = [name compare:p.firstName];
        NSComparisonResult resultLast = [name compare:p.lastName];
        
        //  if the description provided by the user matches the one present in the list
        if(resultFirst == NSOrderedSame || resultLast == NSOrderedSame) {
            
            flag = 1;
            
            //Call to patient descriptor, to display patient details
            NSLog(@"%@",p);
            return p;
        }
    }
    
    //  If there is no patient found with this description
    if(flag == 0) {
        NSLog(@"No patient was found with this description!!");
    }
    
    return nil;
}

//  Defining a listOfPatients method for displaying the list of patient in the hospital
- (void) listOfPatients {
    
    // If there are no patients in the count
    if(patientList.count ==0) {
        NSLog(@"There are no patient registered in hospital");
    }
    // If there are patients, it is going to execute this loop
    else {
        
        NSLog(@"Total patients registered in hospital are: %lu", (unsigned long)patientList.count);
        NSLog(@"----------------------------------------------------------");
        
        // Looping through the patient list
        for(Patient *p in patientList) {
            //Call to patient descriptor, to display patient details
            NSLog(@"%@",p);
            NSLog(@"----------------------------------------------------------");
        }
    }
}

@end
