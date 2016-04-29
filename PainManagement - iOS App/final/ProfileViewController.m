//
//  ProfileViewController.m
//  final
//
//  Created by apple on 5/30/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "ProfileViewController.h"
#import "SWRevealViewController.h"
#import "Constants.h"

@implementation ProfileViewController
@synthesize ua,profile,arrayData,lname,fname,gender;
- (void)viewDidLoad
{
    [super viewDidLoad];
    
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sidebarButton setTarget:self.revealViewController];
        [self.sidebarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
        self.ua = revealViewController.ua;
    }
    
    profile= [[PatientProfile alloc]init];
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithLong:self.ua.userId],@"userid",self.ua.username,@"username",self.ua.password,nil];
    NSData * data = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];
    
    NSString *stringUrl = [NSString stringWithFormat:@"%@patientproflie",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    //NSURL *url = [NSURL URLWithString:@"http://localhost:8080/finalproject/patientproflie"];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[data length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:data];
    
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding]);
    
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    NSLog(@"Response code: %ld", (long)[response statusCode]);
    
    if ([response statusCode] >= 200 && [response statusCode] < 300)
    {
    id object = [NSJSONSerialization JSONObjectWithData:result options:kNilOptions error:nil];
    
    //for(id object in arrayData){
    
    profile.firstName = [object objectForKey:@"firstname"];
    profile.lastName = [object objectForKey:@"lastname"];
    profile.gender = [object objectForKey:@"gender"];
    profile.userId = [[object objectForKey:@"userid"] integerValue];
    
    NSLog(@"%ld",(long)profile.userId);
    
    fname.text = profile.firstName;
    lname.text = profile.lastName;
    gender.text = profile.gender;
    }else {
        
        [self alertStatus:@"Connection Failed" :@"Try connecting after sometime!" :0];
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


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    if([segue.identifier isEqualToString:@"editprofile"]){
        EditProfileViewController *svc= (EditProfileViewController*)[segue destinationViewController];
        svc.delegate = self;
        svc.profile=self.profile;
        
    }
}
-(void)editProfileViewController:(EditProfileViewController *)epvc didChooseValue:(PatientProfile *)editedProfile{
    self.profile = editedProfile;
    
    fname.text = profile.firstName;
    lname.text = profile.lastName;
    gender.text = profile.gender;
    
    [self.navigationController popViewControllerAnimated:YES];
}


@end
