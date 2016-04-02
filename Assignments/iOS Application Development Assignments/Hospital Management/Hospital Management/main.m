//
//  main.m
//  Hospital Management
//
//  Created by Hari Panjwani on 2/18/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

//  Import is a preprocessor command, which tells a Objective-C compiler
#import <Foundation/Foundation.h>

/*  Importing a Patient, Hospital class and Category on NSString so that we can use 
    it in the main class. '<>' angular brackets are used for importing the pre-definie class in
    Objective-C and "" quotes are use for importing the user defined classes. */
#import "Patient.h"
#import "Hospital.h"
#import "NSString+Read.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        
        //  To take the input from the user what action he wants to perform
        int input;
        
        /* Object of NSString is created and memory is allocated, so that
            readString which is created on it can be called to take String input */
        NSString *nr = [[NSString alloc] init];
        
        /*  Patient object of name search is created, so
            it can be used while searching for patient  */
        Patient *search;
        
        /* Object of Hospital class is created and memory is allocated, so that
            various methods and varaibles can be accessed to perform different actions. */
        Hospital *hospital = [[Hospital alloc] init];
        
        //  Adding the hospital and initializing it with the name
        NSLog(@"Enter the name of the hospital: ");
        hospital.hospitalName = [nr readString];
        NSLog(@"Hospital %@, added successfully!!", hospital.hospitalName);
        
        // Calling hospital descriptor to display the welcome message and menu options
        NSLog(@"%@", hospital);
        //  Taking the input for the same.
        scanf("%d", &input);
        
        /* While condition is put on the customer input, it will exist the application
         if the input is anything other than 1 to 9   */
        while(input < 10) {
            
            // Switch statement is used based on the customer input, what he wants to do
            switch (input) {
                
                //case 1 adds patient should to the hospital by calling addPatient method
                case 1:
                    [hospital addPatient];                    
                    
                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                
                //case 2 searches patient within the hospital by calling searchPatient method
                case 2:
                    [hospital searchPatient];
                    
                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                
                //case 3 present list of patients within the hospital by calling listOfPatients method
                case 3:
                    [hospital listOfPatients];
                    
                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                    
                /*  case 4 first look for patient and then add medical record along with 
                    appointment date of the patient by calling updateMedicalRecordMethod    */
                case 4:
                    search = [hospital searchPatient];
                    [search updateMedicalRecord:search];
                    
                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                
                /*  case 5 first look for patient and then present the list of all the 
                    medical record along with appointment date of the patient by calling viewMedicalRecordMethod    */
                case 5:
                    search = [hospital searchPatient];
                    [search viewMedicalRecord:search];
                    
                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                    
                //case 6 adds department should to the hospital by calling addDepartment method
                case 6:
                    [hospital addDepartment];
                    
                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                
                /*  case 7 present list of all the department within the
                    hospital by calling listOfDepartment method */
                case 7:
                    [hospital listOfDepartment];

                    // Calling hospital descriptor to display the welcome message and menu options
                    NSLog(@"%@", hospital);
                    //  Taking the input for the same.
                    scanf("%d", &input);
                    break;
                    
                //  Exit the application
                case 8:
                    NSLog(@"You have  successfully existed the application!!");
                    exit(0);
                
                // This case will exit the application, if user input anything other than 1 to 9.
                default:
                    //  Exit from the application if the input is else from 1 to 9!!
                    NSLog(@"Invalid selecton you have been exited from application!!");
                    exit(0);
                    break;
                
            }
        }
    }
    return 0;
}
