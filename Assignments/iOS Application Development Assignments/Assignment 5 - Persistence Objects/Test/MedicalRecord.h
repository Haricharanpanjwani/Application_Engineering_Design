//
//  MedicalRecord.h
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import <Foundation/Foundation.h>

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@interface MedicalRecord : NSObject {
    
    NSDate *appointmentDate;
    float respRate;
    float heartRate;
    float bp;
    float pulse;
    float weight;
    NSString *prescription;
}

/*  @property provides a syntactical shorthand for declaring a class’s
 accessor methods and, optionally, implementing them. */

/*  We are declaring property for all the instance variable like
 heart rate, resp rate and appointment date class which we define in the
 upper part of the interface     */
@property NSDate *appointmentDate;
@property float respRate;
@property float heartRate;
@property float bp;
@property float pulse;
@property float weight;
@property NSString *prescription;


@end
