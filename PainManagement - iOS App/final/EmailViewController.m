//
//  EmailViewController.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/30/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "EmailViewController.h"
#import "Constants.h"
#import "AppDelegate.h"

@interface EmailViewController ()
{
    AppDelegate *mydelegate;
}
@end

@implementation EmailViewController
@synthesize ua,doctor,titlelabel;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    mydelegate =(AppDelegate *) [[UIApplication sharedApplication]delegate];
    // Do any additional setup after loading the view.
    
    titlelabel.text = @"Doctor Information";
    
    self.navigationItem.titleView = titlelabel;
    doctor = [[DoctorProfile alloc]init];
    
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithLong:self.ua.userId],@"userid",self.ua.username,@"username",self.ua.password,nil];
    NSData * data = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];
    
    NSString *stringUrl = [NSString stringWithFormat:@"%@doctor",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[data length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:data];
    
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding]);
    
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    if ([response statusCode] >= 200 && [response statusCode] < 300)
    {
    id object = [NSJSONSerialization JSONObjectWithData:result options:kNilOptions error:nil];
    
    doctor.firstName = [object objectForKey:@"firstname"];
    doctor.lastName = [object objectForKey:@"lastname"];
    doctor.emailId = [object objectForKey:@"emailid"];
    doctor.PhoneNo = [object objectForKey:@"phonenum"];
    doctor.Specialist = [object objectForKey:@"specialist"];
    
    self.docInfo.text = [NSString stringWithFormat:@"Dr. %@ %@",doctor.firstName,doctor.lastName];
    self.specialist.text = [NSString stringWithFormat:@"( %@ )",doctor.Specialist];
    self.email.text = doctor.emailId;
    self.phonedoc.text = doctor.PhoneNo;
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


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


 #pragma mark - Navigation
 
 // In a storyboard-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
     if([segue.identifier isEqualToString:@"back"]){
         DecisionViewController *svc= (DecisionViewController*)[segue destinationViewController];
         svc.ua = self.ua;
     }
 }
 

- (IBAction)showEmail:(id)sender {
    
    // Email Subject
    NSString *emailTitle = @"Test Email";
    // Email Content
    NSString *messageBody = @"iOS programming is so fun!";
    // To address
    NSArray *toRecipents = [NSArray arrayWithObject:@"testingm28@gmail.com"];
    
    MFMailComposeViewController *mc = [[MFMailComposeViewController alloc] init];
    mc.mailComposeDelegate = self;
    [mc setSubject:emailTitle];
    [mc setMessageBody:messageBody isHTML:NO];
    [mc setToRecipients:toRecipents];
    
    // Present mail view controller on screen
    [self presentViewController:mc animated:YES completion:NULL];
}

- (IBAction)call:(id)sender {
    
    [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"telprompt://6179522975"]];
}

- (void) mailComposeController:(MFMailComposeViewController *)controller didFinishWithResult:(MFMailComposeResult)result error:(NSError *)error
{
    switch (result)
    {
        case MFMailComposeResultCancelled:
            NSLog(@"Mail cancelled");
            break;
        case MFMailComposeResultSaved:
            NSLog(@"Mail saved");
            break;
        case MFMailComposeResultSent:
            NSLog(@"Mail sent");
            break;
        case MFMailComposeResultFailed:
            NSLog(@"Mail sent failure: %@", [error localizedDescription]);
            break;
        default:{
            
        }
            break;
    }
    
    // Close the Mail Interface
    
    id<DoctorViewControllerDelegate> del = self.delegate;
    if([del respondsToSelector:@selector(doctorViewController:didChooseValue:)]){
        NSMutableArray *arr = [[NSMutableArray alloc]init];
        [arr addObject:ua];
        [arr addObject:doctor];
        [del doctorViewController:self didChooseValue:arr];
    }
    
    [self dismissViewControllerAnimated:YES completion:NULL];
}


@end
