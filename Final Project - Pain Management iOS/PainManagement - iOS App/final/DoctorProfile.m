//
//  DoctorProfile.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "DoctorProfile.h"

@implementation DoctorProfile
@synthesize doctorId,firstName,lastName,emailId,PhoneNo,Specialist;


-(NSString *)description{
    return [NSString stringWithFormat:@"\n doctorId : %li, \nfirst Name: %@, \nemailId: %@ , \nPhoneNo: %@", (long)self.doctorId,self.firstName,self.emailId, self.PhoneNo];
}


@end
