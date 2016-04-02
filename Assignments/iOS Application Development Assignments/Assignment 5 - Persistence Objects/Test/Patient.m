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

- (void) encodeWithCoder:(NSCoder *)aCoder {
    
    [ aCoder encodeObject:self forKey:@"patient"];
    [ aCoder encodeObject:self.firstName forKey:@"firstName"];
    [ aCoder encodeObject:self.lastName forKey:@"lastName"];
    [ aCoder encodeInt:self.streetNumber forKey:@"streetNumber"];
    [ aCoder encodeObject:self.streetName forKey:@"streetName"];
    [ aCoder encodeObject:self.city forKey:@"city"];
    [ aCoder encodeObject:self.state forKey:@"state"];
    [ aCoder encodeInt:self.zipCode forKey:@"zipCode"];
    [ aCoder encodeInt64:self.phoneNumber forKey:@"phoneNumber"];
    [ aCoder encodeObject:self.dob forKey:@"dob"];
    [ aCoder encodeInt:self.ssn forKey:@"ssn"];

    [ aCoder encodeObject:self.primaryPhysician forKey:@"primaryPhysician"];
    [ aCoder encodeObject:self.medicalRecord forKey:@"medicalRecord"];
    
}

- (id) initWithCoder:(NSCoder *)aDecoder {
    
    if (self == [self init]) {
        
        self = [ aDecoder decodeObjectForKey:@"patient"];
        firstName = [ aDecoder decodeObjectForKey:@"firstName"];
        lastName  = [ aDecoder decodeObjectForKey:@"lastName"];
        streetNumber = [ aDecoder decodeIntForKey:@"streetNumber"];
        streetName = [ aDecoder decodeObjectForKey:@"streetName"];
        city = [ aDecoder decodeObjectForKey:@"city"];
        state = [ aDecoder decodeObjectForKey:@"state"];
        zipCode = [ aDecoder decodeIntForKey:@"zipCode"];
        phoneNumber = [ aDecoder decodeInt64ForKey:@"phoneNumber"];
        dob = [ aDecoder decodeObjectForKey:@"dob"];
        ssn = [ aDecoder decodeIntForKey:@"ssn"];
        primaryPhysician = [ aDecoder decodeObjectForKey:@"primaryPhysician"];
        medicalRecord  = [ aDecoder decodeObjectForKey:@"medicalRecord"];
    }
    return self;
}



//  Descriptor method is define which is going to return the patients profile
- (NSString *)description    {
    return [NSString stringWithFormat:@"Patient details are as follows: \nFirst Name: %@ \nLast Name: %@ \nSSN: %d \nDate of Birth: %@ \nPhone Number: %ld \nStreet Number: %d \nStreet Name: %@  \nCity: %@ \nState: %@ \nZip Code: %d \nPrimary Physician: %@", [self firstName], [self lastName], [self ssn], [self dob], [self phoneNumber], [self streetNumber], [self streetName], [self city], [self state], [self zipCode], [self primaryPhysician]];
}

/*  Define a method updateMedicalRecord which take input as patient and take
    the input for all the vitalSign and appointment and stored in an array */
- (void) updateMedicalRecord: (MedicalRecord *)mr  {
    
//    float rate;
//    NSString *nr = [[NSString alloc] init];
    
    
//            NSLog(@"\nPlease enter your Appointment Date (MM/dd/yy) ?\n");
//            NSString* date = nr.readString;
//            //  Setting the input in the patient class, so that it can be retrieve later.
//            NSDateFormatter *dateFormatter = [[NSDateFormatter alloc]init];
//            dateFormatter.dateFormat = @"MM/dd/yy";
//            mr.appointmentDate = [dateFormatter dateFromString:date];
//    
//            NSLog(@"Please enter the current respiratory rate: ");
//            scanf("%f", &rate);
//            mr.respRate = rate;
//            
//            NSLog(@"Please enter the current heart rate: ");
//            scanf("%f", &rate);
//            mr.heartRate = rate;
//            
//            NSLog(@"Please enter the current blood pressure: ");
//            scanf("%f", &rate);
//            mr.bp = rate;
//            
//            NSLog(@"Please enter the current pulse rate: ");
//            scanf("%f", &rate);
//            mr.pulse = rate;
//    
//            NSLog(@"Please enter the current weight: ");
//            scanf("%f", &rate);
//            mr.weight = rate;
//    
//            NSLog(@"Prescription prescribed to patient is: ");
//            mr.prescription = [nr readString];
//    
 //           [p.medicalRecord addObject:mr];

}

/*  Define a method viewMedicalRecord which take output as patient and take
    the input for all the vital sign and appointment and stored in an array */
- (void) viewMedicalRecord: (Patient*)p {
    
    // if the medical record of patient are nil
    if(medicalRecord.count == 0) {
        NSLog(@"There are no medical record for patient %@, %@", p.lastName, p.firstName);
    }    
    else {
        
        NSLog(@"Medical Record for patient %@, %@ is: ", p.lastName, p.firstName);
        for(MedicalRecord *mr in medicalRecord) {
            
            NSLog(@"%@", mr);
            
            NSLog(@"----------------------------------------------------------");
        }
    }
}

@end
