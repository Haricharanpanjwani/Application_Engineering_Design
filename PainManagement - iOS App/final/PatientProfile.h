//
//  PatientProfile.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/2/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PatientProfile : NSObject
{
    NSInteger userId;
    NSString *firstName;
    NSString *lastName;
    NSString *gender;
    NSString *startDate;
    NSInteger doctorId;
    NSString *healthCondition;
    NSString *isPrescribed;
    NSString *language;
    NSString *enthnonym;
    NSString *enthnicity;
    NSString *lastGradeSchool;
    NSString *currentlyWorking;
    NSInteger feet;
    NSInteger inches;
    NSInteger weight;
    
}

@property(nonatomic) NSInteger userId;
@property(nonatomic,strong) NSString *firstName;
@property(nonatomic,strong) NSString *lastName;
@property(nonatomic,strong) NSString *gender;
@property(nonatomic,strong) NSString *startDate;
@property(nonatomic) NSInteger doctorId;
@property(nonatomic,strong) NSString *healthCondition;
@property(nonatomic,strong) NSString *isPrescribed;
@property(nonatomic,strong) NSString *language;
@property(nonatomic,strong) NSString *enthnonym;
@property(nonatomic,strong) NSString *enthnicity;
@property(nonatomic,strong) NSString *lastGradeSchool;
@property(nonatomic,strong) NSString *currentlyWorking;
@property(nonatomic) NSInteger feet;
@property(nonatomic) NSInteger inches;
@property(nonatomic) NSInteger weight;


@end


