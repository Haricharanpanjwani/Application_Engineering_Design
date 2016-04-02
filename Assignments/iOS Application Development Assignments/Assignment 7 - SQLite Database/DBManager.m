//
//  DBManager.m
//  Final Assignment 7
//
//  Created by Hari Panjwani on 3/27/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "DBManager.h"

@implementation DBManager

@synthesize databaseName;

static DBManager *shared = NULL;

- (id)init
{
    if ( self = [super init] )
    {
        // initialize your singleton variable here (i.e. set to initial value that you require)
        databaseName = @"hosp.db";
    }
    return self;
    
}


+ (DBManager *)sharedSingleton
{
    @synchronized(shared)
    {
        if ( !shared || shared == NULL )
        {
            // allocate the shared instance, because it hasn't been done yet
            shared = [[DBManager alloc] init];
        }
        
        return shared;
    }
}

- (NSString *) getWritableDBPath {
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory , NSUserDomainMask, YES);
    NSString *documentsDir = [paths objectAtIndex:0];
    return [documentsDir stringByAppendingPathComponent:databaseName];
    
}

-(void)createEditableCopyOfDatabaseIfNeeded {
    // Testing for existence
    BOOL success;
    NSFileManager *fileManager = [NSFileManager defaultManager];
    NSError *error;
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [paths objectAtIndex:0];
    if ([fileManager fileExistsAtPath:@""]==YES) {
        NSLog(@"File exists");
    }
    NSString *writableDBPath = [documentsDirectory stringByAppendingPathComponent:databaseName];
    
    success = [fileManager fileExistsAtPath:writableDBPath];
    if (success)
        return;
    
    // The writable database does not exist, so copy the default to
    // the appropriate location.
    NSString *defaultDBPath = [[[NSBundle mainBundle] resourcePath]stringByAppendingPathComponent:databaseName];
    success = [fileManager copyItemAtPath:defaultDBPath
                                   toPath:writableDBPath
                                    error:&error];
    if(!success)
    {
        NSAssert1(0,@"Failed to create writable database file with Message : '%@'.",
                  [error localizedDescription]);
    }
}

- (NSString *) retrieveHospital {
    
    NSString *hospitalName = nil;
    
    // copy the database
    [self createEditableCopyOfDatabaseIfNeeded];
    
    NSString * paths=[self getWritableDBPath];
    
    //const char *dbpath =  [paths UTF8String];
    sqlite3_stmt    *statement;
    
    static sqlite3 *database = nil;
    
    if (sqlite3_open([paths UTF8String], &database) == SQLITE_OK)
    {
        NSString *querySQL = [NSString stringWithFormat: @"SELECT hospitalName FROM Hospital"];
        
        const char *query_stmt = [querySQL UTF8String];
        
        //  NSLog(@"Databasae opened = %@", userN);
        
        if (sqlite3_prepare_v2(database, query_stmt, -1, &statement, NULL) == SQLITE_OK)
        {            
            while(sqlite3_step(statement) == SQLITE_ROW)
            {
                hospitalName = [[NSString alloc]initWithUTF8String:(const char *) sqlite3_column_text(statement, 0)];
                
                NSLog(@"Retreived Hospital: %@", hospitalName);
            }
            
            sqlite3_finalize(statement);
        }
        
        sqlite3_close(database);
   }
    
    return hospitalName;
}

- (NSMutableArray *) createPatientList: (NSString *)name {
    
    NSMutableArray *generatedList = [[NSMutableArray alloc] init];
    
    NSString * paths=[self getWritableDBPath];
    
    //const char *dbpath =  [paths UTF8String];
    sqlite3_stmt    *statement;
    
    static sqlite3 *database = nil;
    
    if (sqlite3_open([paths UTF8String], &database) == SQLITE_OK)
    {
        NSString * tempSQL = @"SELECT * FROM Person where hospital = '";
        
        NSString *querySQL =  [NSString stringWithFormat:@"%@%@%@",tempSQL,name,@"';"];
        
        //NSString *querySQL = [NSString stringWithFormat: @"SELECT * FROM Person where hospital = ?"];
        
        const char *query_stmt = [querySQL UTF8String];
        
        //  NSLog(@"Databasae opened = %@", userN);
        
        if (sqlite3_prepare_v2(database, query_stmt, -1, &statement, NULL) == SQLITE_OK)
        {
            while(sqlite3_step(statement) == SQLITE_ROW)
            {
                Patient *p = [[Patient alloc] init];
                
                p.firstName = [[NSString alloc]initWithUTF8String:(const char *) sqlite3_column_text(statement, 0)];
                
                p.lastName = [[NSString alloc]initWithUTF8String:(const char *) sqlite3_column_text(statement, 1)];
                
                p.city = [[NSString alloc]initWithUTF8String:(const char *) sqlite3_column_text(statement, 2)];
                
                p.state = [[NSString alloc]initWithUTF8String:(const char *) sqlite3_column_text(statement, 3)];
                
                //Selecting the Image
                NSData* data = nil;
                int length = sqlite3_column_bytes(statement, 5);
                data       = [NSData dataWithBytes:sqlite3_column_blob(statement, 5) length:length];
                
                p.imageName = [[UIImage alloc] initWithData:data];
                
                [generatedList addObject:p];
                
                NSLog(@"%@ added successfully to the list", p.firstName);
            }
            
            sqlite3_finalize(statement);
        }
        
        sqlite3_close(database);
    }
    
    return generatedList;
}

- (void) deletePatient: (Patient *)patient {
    
    NSString *filePath = [self getWritableDBPath];
    
    sqlite3 *database;
    
    NSString *firstName = patient.firstName;
    NSString *lastName = patient.lastName;
    
    
    if(sqlite3_open([filePath UTF8String], &database) == SQLITE_OK) {
        
        NSString *tempFirst = @"DELETE FROM Person WHERE firstName ='";
        NSString *tempSecond = @"' and lastName ='";
        
        NSString *query =  [NSString stringWithFormat:@"%@%@%@%@%@",tempFirst,firstName,tempSecond,lastName,@"';"];
        
        const char *sqlStatement = [query cStringUsingEncoding:NSUTF8StringEncoding];
        
        sqlite3_stmt *compiledStatement;
        
        sqlite3_prepare_v2(database, sqlStatement, -1, &compiledStatement, NULL);        
        
        if(sqlite3_step(compiledStatement) != SQLITE_DONE ) {
            NSLog( @"Save Error: %s", sqlite3_errmsg(database) );
        }
        else {
            NSLog(@"Patient deleted successfully!!");
        }
        
        sqlite3_finalize(compiledStatement);
    }
    sqlite3_close(database);

}


@end
