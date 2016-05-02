//
//  ViewController.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/28/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "ViewController.h"
#import "SWRevealViewController.h"
#import "DecisionViewController.h"
#import "AppDelegate.h"
#import "Constants.h"

@interface ViewController ()

@end

@implementation ViewController
@synthesize ua;
- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.

    ua = [[UserAccount alloc]init];
    
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sidebarButton setTarget:self.revealViewController];
        [self.sidebarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
    }
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)signIn:(id)sender {
    NSInteger success = 0;
    @try {
        
        if([[self.usernameTxt text] isEqualToString:@""] || [[self.pwdTxt text] isEqualToString:@""] ) {
            
            [self alertStatus:@"Please enter Email and Password" :@"Sign in Failed!" :0];
            
        } else {
            NSString *post =[[NSString alloc] initWithFormat:@"username=%@&password=%@",[self.usernameTxt text],[self.pwdTxt text]];
            NSLog(@"PostData: %@",post);
            
            //NSURL *url=[NSURL URLWithString:@"https://dipinkrishna.com/jsonlogin.php"];
            
            NSString *stringUrl = [NSString stringWithFormat:@"%@login",Url];
            NSURL *url = [NSURL URLWithString:stringUrl];
            
            //    NSURL *url=[NSURL URLWithString:@"http://localhost:8080/finalproject/login"];
            
            
            NSDictionary *loginfo = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithInt:1],@"userid",[self.usernameTxt text],@"username",[self.pwdTxt text],@"userpassword",nil];
            
            
            NSData *postData = [NSJSONSerialization dataWithJSONObject:loginfo options:kNilOptions error:nil];
            
            NSLog(@"Json data before request: %@",[[NSString alloc] initWithData:postData encoding:NSUTF8StringEncoding]);
            
            NSString *postLength = [NSString stringWithFormat:@"%lu", (unsigned long)[postData length]];
            
            
            
            NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
            
            
            [request setHTTPMethod:@"POST"];
            [request setValue:postLength forHTTPHeaderField:@"Content-Length"];
            [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
            [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
            [request setHTTPBody:postData];
            
            NSError *error = [[NSError alloc] init];
            NSHTTPURLResponse *response = nil;
            NSData *urlData=[NSURLConnection sendSynchronousRequest:request returningResponse:&response error:&error];
            
            NSLog(@"Response code: %ld", (long)[response statusCode]);
            
            if ([response statusCode] >= 200 && [response statusCode] < 300)
            {
                NSString *responseData = [[NSString alloc]initWithData:urlData encoding:NSUTF8StringEncoding];
                NSLog(@"Response ==> %@", responseData);
                
                NSError *error = nil;
                NSDictionary *jsonData = [NSJSONSerialization
                                          JSONObjectWithData:urlData
                                          options:NSJSONReadingMutableContainers
                                          error:&error];
                
                success = [jsonData[@"userid"] integerValue];
                NSLog(@"Success: %ld",(long)success);
                
                if(success >= 1)
                {
                    //self.ua = [[UserAccount alloc]init];
                    ua.userId = success;
                    ua.username = self.usernameTxt.text;
                    AppDelegate *delegate = (AppDelegate*)[[UIApplication sharedApplication] delegate];
                    delegate.loginDetails.userId = success;
                    delegate.loginDetails.username = self.usernameTxt.text;
                    
                    
                    [self performSegueWithIdentifier:@"login_success" sender:self];
                    NSLog(@"Login SUCCESS");
                } else {
                    
                    NSString *error_msg = (NSString *) jsonData[@"error_message"];
                    [self alertStatus:error_msg :@"Sign in Failed!" :0];
                }
                
            } else {
                
                [self alertStatus:@"Connection Failed" :@"Sign in Failed!" :0];
            }
        }
    }
    
    @catch (NSException * e) {
        NSLog(@"Exception: %@", e);
        [self alertStatus:@"Sign in Failed." :@"Error!" :0];
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



- (IBAction)backgroundTap:(id)sender {
    [self.view endEditing:YES];
}

-(BOOL)textFieldShouldReturn:(UITextField *)textField{
    [textField resignFirstResponder];
    return YES;
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    if([segue.identifier isEqualToString:@"login_success"]){
        DecisionViewController *dvc= (DecisionViewController*)[segue destinationViewController];
        dvc.ua =self.ua;
    }
    
    
}

@end
