//
//  DBManager.h
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/27/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <sqlite3.h>
#import "Patient.h"

@interface DBManager : NSObject

@property (nonatomic, strong) NSString *databaseName;

+ (DBManager *)sharedSingleton;

- (NSString *) getWritableDBPath;

-(void)createEditableCopyOfDatabaseIfNeeded;

- (NSString *) retrieveHospital;

- (NSMutableArray *) createPatientList: (NSString *)name;

- (void) deletePatient: (Patient *)patient;

@end
