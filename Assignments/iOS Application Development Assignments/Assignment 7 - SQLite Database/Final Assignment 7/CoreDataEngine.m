//
//  CoreDataEngine.m
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/27/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "CoreDataEngine.h"

@implementation CoreDataEngine

@synthesize fetchResultController;

+ (id) sharedDataEngine {
    
    static CoreDataEngine *data = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        data = [[self alloc] init];
    });
    return data;
}

- (NSManagedObjectContext *) managedObjectContext {
    return [(AppDelegate *)[[UIApplication sharedApplication] delegate] managedObjectContext];
}

-(NSFetchedResultsController *) fetchResultController {
    
    if(fetchResultController != nil){
        return fetchResultController;
    }
    
    NSManagedObjectContext *context = [self managedObjectContext];
    
    NSFetchRequest *fetchRequest = [[NSFetchRequest alloc] init];
    
    NSEntityDescription *entity = [NSEntityDescription entityForName:@"Hospital"
                                              inManagedObjectContext:context];
    
    [fetchRequest setEntity:entity];
    
    NSSortDescriptor *sortDescriptor = [[NSSortDescriptor alloc] initWithKey:@"lastName" ascending:YES];
    
    NSArray *sortDescriptors = [[NSArray alloc] initWithObjects:sortDescriptor, nil];
    
    fetchRequest.sortDescriptors = sortDescriptors;
    
    fetchResultController = [[NSFetchedResultsController alloc] initWithFetchRequest:fetchRequest managedObjectContext:context sectionNameKeyPath:nil cacheName:nil];
    
    fetchResultController.delegate = self;
    
    return fetchResultController;
}



#pragma mark - Core Data Saving support

- (void)saveContext {
    NSManagedObjectContext *managedObjectContext = self.managedObjectContext;
    if (managedObjectContext != nil) {
        NSError *error = nil;
        if ([managedObjectContext hasChanges] && ![managedObjectContext save:&error]) {
            // Replace this implementation with code to handle the error appropriately.
            // abort() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
            NSLog(@"Unresolved error %@, %@", error, [error userInfo]);
            //abort();
        }
    }
}

- (void) savePatients {
    
    NSManagedObjectContext *context = [self managedObjectContext];
    NSManagedObject *hospital = [NSEntityDescription
                                       insertNewObjectForEntityForName:@"Hospital"
                                       inManagedObjectContext:context];
    
    [hospital setValue:self.hospital.hospitalName forKey:@"hospitalName"];
    
    NSManagedObject *patient = [NSEntityDescription
                                          insertNewObjectForEntityForName:@"Patient"
                                          inManagedObjectContext:context];
    [patient setValue:self.hospital.hospitalName forKey:@"hospitalName"];
    
    NSLog(@"Patient HUUUURRRRAYY");
    
    NSError *error;
        if (![context save:&error]) {
            NSLog(@"Whoops, couldn't save: %@", [error localizedDescription]);
        }
}

- (void) retrievePatients {
    
    NSManagedObjectContext *context = [self managedObjectContext];
    // Test listing all FailedBankInfos from the store
    NSFetchRequest *fetchRequest = [[NSFetchRequest alloc] init];
    NSEntityDescription *entity = [NSEntityDescription entityForName:@"Patient"
                                              inManagedObjectContext:context];
    [fetchRequest setEntity:entity];
    
    NSError *error;
    
    NSArray *fetchedHospital = [context executeFetchRequest:fetchRequest error:&error];
    
    Hospital *hos = [fetchedHospital objectAtIndex:0];
    
    for (Patient *p in hos.patientList) {
        NSLog(@"First Name: %@", p.firstName);
        NSLog(@"Last Name: %@", p.lastName);
        NSLog(@"Name: %@", p.city);
        NSLog(@"Zip: %@", p.state);
    }
    
    //    if (![context save:&error]) {
    //        NSLog(@"Whoops, couldn't save: %@", [error localizedDescription]);
    //    }
}

- (void) saveHospital {
    
    NSManagedObjectContext *context = [self managedObjectContext];
    
    if (self.managedObjectContext != nil) {
        NSError *error = nil;
        if ([self.managedObjectContext hasChanges] && ![self.managedObjectContext save:&error]) {
            // Replace this implementation with code to handle the error appropriately.
            // abort() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
            NSLog(@"Unresolved error %@, %@", error, [error userInfo]);
            //abort();
        }
        else {
            NSManagedObject *hospitalObject = [NSEntityDescription
                                 insertNewObjectForEntityForName:@"Hospital"
                                 inManagedObjectContext:context];
    
            [hospitalObject setValue:self.hospital.hospitalName forKey:@"hospitalName"];
            [hospitalObject setValue:self.hospital.patientList forKey:@"patientList"];
            NSLog(@"Hospital Saved!!");
        }
    }
}

- (Hospital *) retrieveHospital {
    
    NSManagedObjectContext *context = [self managedObjectContext];
    NSFetchRequest *fetchRequest = [[NSFetchRequest alloc] init];
    NSEntityDescription *entity = [NSEntityDescription entityForName:@"Hospital"
                                                  inManagedObjectContext:context];
    [fetchRequest setEntity:entity];
    
    NSError *error;
    
    NSArray *fetchedHospital = [context executeFetchRequest:fetchRequest error:&error];
    
    Hospital *hos = [fetchedHospital objectAtIndex:0];
    
    return hos;
}

@end
