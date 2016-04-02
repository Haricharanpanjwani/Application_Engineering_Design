//
//  MedicalRecord.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "MedicalRecord.h"

/*
 A class definition is the specification of a class of objects through the use of certain files and syntax.
 A class definition minimally consists of two parts: a public interface, and a private implementation.
 You typically split the interface and implementation into two separate files—the
 header file and the implementation file.
*/
@implementation MedicalRecord

/*  This line tells the compiler to create a setter and getter for appointmentDate or all the instance variable for which you will write it, and that they should use the appointmentDate for those method. Without the = appointmentDate part, the compiler would assume that the property and use _appointmentDate.
*/
@synthesize appointmentDate;
@synthesize respRate;
@synthesize heartRate;
@synthesize bp;
@synthesize pulse;
@synthesize weight;
@synthesize prescription;

- (void) encodeWithCoder:(NSCoder *)aCoder {
    
    [ aCoder encodeObject:self forKey:@"medicalRecord"];
    [ aCoder encodeFloat:self.respRate forKey:@"respRate"];
    [ aCoder encodeFloat:self.heartRate forKey:@"heartRate"];
    [ aCoder encodeFloat:self.bp forKey:@"bp"];
    [ aCoder encodeFloat:self.pulse forKey:@"pulse"];
    [ aCoder encodeFloat:self.weight forKey:@"weight"];
    [ aCoder encodeObject:self.prescription forKey:@"prescription"];
    
}

- (id) initWithCoder:(NSCoder *)aDecoder {
    
    if (self == [self init]) {
        
        self = [ aDecoder decodeObjectForKey:@"medicalRecord"];
        respRate = [ aDecoder decodeFloatForKey:@"respRate"];
        heartRate = [ aDecoder decodeFloatForKey:@"heartRate"];
        bp = [ aDecoder decodeFloatForKey:@"bp"];
        pulse = [ aDecoder decodeFloatForKey:@"pulse"];
        weight = [ aDecoder decodeFloatForKey:@"weight"];
        prescription  = [ aDecoder decodeObjectForKey:@"prescription"];
    }
    return self;
}

//  Descriptor method is define which is going to return the patients medical record
- (NSString *)description    {
    
    return [NSString stringWithFormat:@"\nAppointment Date: %@ \nRespiratory Rate: %f \nHeart Rate: %f \nBlood Pressure: %f \nPulse: %f \nCurrent Weight: %f \nPrescribed Medicine: %@", self.appointmentDate,self.respRate,self.heartRate,self.bp, self.pulse, self.weight, self.prescription];
}

@end
