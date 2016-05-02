//
//  PatientMedicine.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "PatientMedicine.h"

@implementation PatientMedicine
@synthesize mpId,userId,medicineDes,medicineName,quantity,medicineId;

-(NSString *)description{
    return [NSString stringWithFormat:@"\n mpId : %li, \nmedicineDes: %@, \nMedicineName: %@", (long)self.mpId,self.medicineDes,self.medicineName];
}


@end
