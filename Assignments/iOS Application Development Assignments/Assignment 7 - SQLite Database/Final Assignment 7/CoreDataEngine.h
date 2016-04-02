//
//  CoreDataEngine.h
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/27/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>
#import "AppDelegate.h"
#import "Patient.h"
#import "Hospital.h"

@interface CoreDataEngine : NSObject

@property Hospital *hospital;
@property (strong, nonatomic) NSManagedObjectContext *managedObjectContext;
@property (strong, nonatomic) NSFetchedResultsController *fetchResultController;
//@property (strong, nonatomic) NSManagedObjectModel *managedObjectModel;
//@property (strong, nonatomic) NSPersistentStoreCoordinator *persistentStoreCoordinator;

+ (id) sharedDataEngine;

- (void) savePatients;

- (void) retrievePatients;

- (Hospital *) retrieveHospital;

- (void) saveHospital;

@end
