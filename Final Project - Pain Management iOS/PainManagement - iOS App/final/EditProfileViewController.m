//
//  EditProfileViewController.m
//  final
//
//  Created by apple on 5/15/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "EditProfileViewController.h"
#import "Constants.h"

@interface EditProfileViewController ()

@end

@implementation EditProfileViewController
@synthesize profile,lname,fname,gender,ua,hispaniclatin,language,currentlyworking,enthnicity,weight,height;
@synthesize tap;

- (void)viewDidLoad {
    [super viewDidLoad];
    
//    lname.text = profile.lastName;
//    fname.text = profile.firstName;
//    gender.text = profile.gender;
    
    self.tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

//  Dismiss the keyboard on tap out
-(void)dismissKeyboard {
    [self.view endEditing:YES];
}


- (IBAction)Save:(id)sender {
    
    @try {
        NSError *error;
        
//        NSString *nameRegex = @"^[A-Z][a-z]*";
//        NSRegularExpression *regex =
//        [NSRegularExpression regularExpressionWithPattern:nameRegex
//                                                  options:0
//                                                    error:&error];
        
        NSDate *date = self.startDate.date;
        NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
        [dateFormat setDateFormat:@"yyyy-MM-dd"];
        NSString *treatDate=[dateFormat stringFromDate:date];
        
        NSLog(@"Date: %@", treatDate);
        
        NSDate *today = [NSDate date];
        NSComparisonResult result = [today compare:self.startDate.date];
        
        NSCharacterSet *notDigits = [[NSCharacterSet decimalDigitCharacterSet] invertedSet];
        NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
        NSCharacterSet *lettersOnly = [[NSCharacterSet letterCharacterSet] invertedSet];
        
        NSString *rawFirstName = self.fname.text;
        NSString *trimmedFirstName = [rawFirstName stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawLastName = self.lname.text;
        NSString *trimmedLastName = [rawLastName stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawGender = self.gender.text;
        NSString *trimmedGender = [rawGender stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawLanguage = self.language.text;
        NSString *trimmedLanguage = [rawLanguage stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawEnthnonym = self.hispaniclatin.text;
        NSString *trimmedEnthnonym = [rawEnthnonym stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawEnthnicity = self.enthnicity.text;
        NSString *trimmedEnthnicity = [rawEnthnicity stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawCurrentlyWorking = self.currentlyworking.text;
        NSString *trimmedCurrentlyWorking = [rawCurrentlyWorking stringByTrimmingCharactersInSet:whitespace];
        
        NSString *rawWeight = self.weight.text;
        NSString *trimmedWeight = [rawWeight stringByTrimmingCharactersInSet:whitespace];
        
        
        
        if(result == NSOrderedAscending) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                            message:@"Start Date cannot be of future!"preferredStyle:UIAlertControllerStyleAlert];
            
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];[alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedFirstName length] > 0) || [trimmedFirstName isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"First Name cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedLastName length] > 0) || [trimmedLastName isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Last Name cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedGender length] > 0) || [trimmedGender isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Gender cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedLanguage length] > 0) || [trimmedLanguage isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Language cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedEnthnonym length] > 0) || [trimmedEnthnonym isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Enthnonym cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedEnthnicity length] > 0) || [trimmedEnthnicity isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Enthnicity cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedCurrentlyWorking length] > 0) || [trimmedCurrentlyWorking isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Currently working field cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedWeight length] > 0) || [trimmedWeight isEqual:@""] == TRUE) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                                                                           message:@"Weight cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedWeight rangeOfCharacterFromSet:notDigits].location == NSNotFound))
        {
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Field cannot be empty"
                        message:@"Weight can only have digits!" preferredStyle:UIAlertControllerStyleAlert];
            
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            return;
        }
        else if (!([trimmedFirstName rangeOfCharacterFromSet:lettersOnly].location == NSNotFound) ||
                 !([trimmedLastName rangeOfCharacterFromSet:lettersOnly].location == NSNotFound) ||
                 !([trimmedGender rangeOfCharacterFromSet:lettersOnly].location == NSNotFound) ||
                 !([trimmedLanguage rangeOfCharacterFromSet:lettersOnly].location == NSNotFound) ||
                 !([trimmedEnthnonym rangeOfCharacterFromSet:lettersOnly].location == NSNotFound) ||
                 !([trimmedEnthnicity rangeOfCharacterFromSet:lettersOnly].location == NSNotFound) ||
                 !([trimmedCurrentlyWorking rangeOfCharacterFromSet:lettersOnly].location == NSNotFound)) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Invalid Entry"
                                                                           message:@"Field can only have alphabets!" preferredStyle:UIAlertControllerStyleAlert];
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault
                                                                  handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            [self presentViewController:alert animated:YES completion:nil];
            
            return;
        }
        else {
            
            profile.userId = ua.userId;
            profile.firstName = trimmedFirstName;
            profile.lastName = trimmedLastName;
            profile.gender = trimmedGender;
            profile.language= trimmedLanguage;
            profile.enthnonym= trimmedEnthnonym;
            profile.enthnicity = trimmedEnthnicity;
            profile.startDate= treatDate;
            profile.currentlyWorking = trimmedCurrentlyWorking;
            profile.weight = [weight.text intValue];
        
            NSDictionary *myprofiledictionary = [NSDictionary dictionaryWithObjectsAndKeys:
                                        profile.firstName,@"firstname",
                                        profile.lastName,@"lastname",
                                        profile.gender,@"gender",
                                        profile.language,@"language",
                                        profile.enthnonym,@"enthnonym",
                                        profile.enthnicity,@"enthnicity",
                                        profile.currentlyWorking,@"currentlyWorking",
                                        profile.startDate,@"startdate",
                                        [NSNumber numberWithInteger:profile.weight],@"weight",
                                        [NSNumber numberWithLong:profile.userId],@"userid",nil];
            
            NSData *myprofiledata = [NSJSONSerialization dataWithJSONObject:myprofiledictionary options:kNilOptions error:nil];
            
            NSString *stringUrl = [NSString stringWithFormat:@"%@editprofile",Url];
            NSURL *url = [NSURL URLWithString:stringUrl];
            
            //NSURL *profileUrl = [NSURL URLWithString:@"http://localhost:8080/finalproject/editprofile"];
            
            NSMutableURLRequest *editProfileRequest = [NSMutableURLRequest requestWithURL:url];
            
            [editProfileRequest setHTTPMethod:@"POST"];
            [editProfileRequest setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
            [editProfileRequest setValue:@"application/json" forHTTPHeaderField:@"Accept"];
            [editProfileRequest setValue:[NSString stringWithFormat:@"%ul",(unsigned)[myprofiledata length]] forHTTPHeaderField:@"Content-length"];
            [editProfileRequest setHTTPBody:myprofiledata];
            
            NSURLResponse *response = nil;
            
            NSData *result = [NSURLConnection sendSynchronousRequest:editProfileRequest returningResponse:&response error:nil];
            
            NSString *resultString = [[NSString alloc] initWithData:result encoding:NSUTF8StringEncoding];
            
            NSLog(@"%@",resultString);
            
            id<EditProfileViewControllerDelegate> del = self.delegate;
            if([del respondsToSelector:@selector(editProfileViewController:didChooseValue:)]){
                [del editProfileViewController:self didChooseValue:self.profile];
            }
            
        }
    }
    @catch (NSException * e) {
        NSLog(@"Exception: %@", e);
        [self alertStatus:@"Error in saving data." :@"Error!" :0];
    }
}

- (void) alertStatus:(NSString *)msg :(NSString *)title :(int) tag
{
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:title
                                                        message:msg
                                                       delegate:self
                                              cancelButtonTitle:@"Ok"
                                              otherButtonTitles:nil, nil];
    alertView.tag = tag;
    [alertView show];
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    if([segue.identifier isEqualToString:@"showProfile"]){
        
        MyProfileViewController *mpvc= segue.destinationViewController;
        mpvc.profile = self.profile;
    }
}


@end
