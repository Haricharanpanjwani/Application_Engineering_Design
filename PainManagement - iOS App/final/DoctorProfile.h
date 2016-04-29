//
//  DoctorProfile.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface DoctorProfile : NSObject
{
    NSInteger doctorId;
    NSString *firstName;
    NSString *lastName;
    NSString *emailId;
    NSString *PhoneNo;
    NSString *Specialist;
}

@property(nonatomic) NSInteger doctorId;
@property(nonatomic,strong) NSString *firstName;
@property(nonatomic,strong) NSString *lastName;
@property(nonatomic,strong) NSString *emailId;
@property(nonatomic,strong) NSString *PhoneNo;
@property(nonatomic,strong) NSString *Specialist;

@end
