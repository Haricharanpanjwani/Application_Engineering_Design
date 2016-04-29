//
//  PatientMedicine.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PatientMedicine : NSObject
{
    NSInteger mpId;
    NSInteger userId;
    NSInteger medicineId;
    NSString *medicineDes;
    NSString *medicineName;
    NSInteger quantity;
    NSInteger maxquatity;
    NSNumber *mdpertime;
}
@property(nonatomic) NSInteger mpId;
@property(nonatomic) NSInteger userId;
@property(nonatomic) NSInteger medicineId;
@property(nonatomic) NSInteger maxquantity;
@property(nonatomic,strong) NSNumber *mdpertime;
@property(nonatomic,strong) NSString *medicineDes;
@property(nonatomic,strong) NSString *medicineName;
@property(nonatomic) NSInteger quantity;


@end
