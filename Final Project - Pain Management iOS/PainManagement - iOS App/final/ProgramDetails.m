//
//  ProgramDetails.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "ProgramDetails.h"

@implementation ProgramDetails
@synthesize programDetails,programId,programName,programUrl,subCategory;


-(NSString *)description{
    return [NSString stringWithFormat:@"\n programId : %li, \nProgram Details: %@, \nProgram Url: %@, \nSubcategory: %li,\nProgramName: %@", (long)self.programId,self.programDetails,self.programUrl,(long)self.subCategory,self.programName];
}
@end
