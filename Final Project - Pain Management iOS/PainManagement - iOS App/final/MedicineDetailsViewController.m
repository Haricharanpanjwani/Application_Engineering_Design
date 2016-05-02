//
//  MedicineDetailsViewController.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 5/1/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "MedicineDetailsViewController.h"
#import "MedicineFeedback.h"
#import "Constants.h"

@interface MedicineDetailsViewController ()

@end

@implementation MedicineDetailsViewController
@synthesize data,ua;


-(id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    
    if(self){
        
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    self.jsonData.text = data.medicineDes;
    self.medicineName.text = @"Description:";
    NSString *medval = [NSString stringWithFormat:@"%@ per time",[data.mdpertime stringValue]];
    self.quantity.text = medval;
    self.quantity.numberOfLines = 0;
    self.medicineDes.text = data.medicineDes;
    self.title = data.medicineName;
   
    self.totalNoOfPils.text = [NSString stringWithFormat:@"%li",(long)data.maxquantity];
    self.noOfPilsTaken.text = [NSString stringWithFormat:@"0"];
    self.noOfPilsTaken.numberOfLines=0;
    self.medicineDes.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    self.medicineDes.layer.borderWidth = 5.0f;
    self.medicineDes.layer.borderColor = [[UIColor grayColor] CGColor];
    
    [self getRemainingData];
    
    }

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
    
}


-(void)getRemainingData{
    
    NSString *currentDate;
    
    NSDate *now = [NSDate date];
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyy-MM-dd"];
    currentDate = [dateFormatter stringFromDate:now];
    
    MedicineFeedback *mf =[[MedicineFeedback alloc]init];
    mf.mpId = data.mpId;
    mf.totalAmounts = 0;
    mf.date = currentDate;
    mf.mHistory=@"history";
    NSMutableDictionary *obj = [[NSMutableDictionary alloc]init];
    
    NSString *timeStamp =[NSString stringWithFormat:@"%li%@",(long)data.mpId,currentDate];
    
    [obj setObject:[NSNumber numberWithInteger:mf.mpId] forKey:@"mpid"];
    [obj setObject:[NSNumber numberWithInteger:mf.totalAmounts] forKey:@"totalAmount"];
    [obj setObject:mf.date forKey:@"date"];
    [obj setObject:timeStamp forKey:@"timeStamp"];
    [obj setObject:mf.mHistory forKey:@"mHistory"];
    
    
    NSData *jsonData2 = [NSJSONSerialization dataWithJSONObject:obj options:kNilOptions error:nil];
    
    NSLog(@"Json data before request: %@",[[NSString alloc] initWithData:jsonData2 encoding:NSUTF8StringEncoding]);
    
    //NSString *jsonString = [[NSString alloc]initWithData:jsonData2 encoding:NSUTF8StringEncoding];
    NSString *stringUrl = [NSString stringWithFormat:@"%@getremaining",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    //  NSURL *url = [NSURL URLWithString:@"http://localhost:8080/finalproject/medicinefeedback"];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[jsonData2 length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:jsonData2];
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:jsonData2 encoding:NSUTF8StringEncoding]);
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    NSString *responsed = [[NSString alloc]initWithData:result encoding:NSUTF8StringEncoding];
    responseData = [responsed intValue];
    NSLog(@"Response ==> %ld", (long)responseData);
    self.totalNoOfPils.text = [NSString stringWithFormat:@"%li",(long)data.maxquantity - (long)responseData];
    
    if(responseData == data.maxquantity){
        self.pilsStepper.enabled = NO;
    }
    
}


/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)confirmAction:(id)sender {
    
    [self converttojson];
    
    id<MedicationViewControllerDelegate> del = self.delegate;
    if([del respondsToSelector:@selector(medicationViewController:didChooseValue:)]){
        [del medicationViewController:self didChooseValue:self.ua];
    }
    
}

-(void)converttojson{
    
    NSString *currentDate;
    
    NSString *currentTimeStamp;
    
    NSDate *now = [NSDate date];
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyy-MM-dd"];
    currentDate = [dateFormatter stringFromDate:now];
    
    [dateFormatter setDateFormat:@"yyyy-MM-dd'T'HH:mm:ss.SSS"];
    currentTimeStamp = [dateFormatter stringFromDate:now];

    
    MedicineFeedback *mf =[[MedicineFeedback alloc]init];
    mf.mpId = data.mpId;
    mf.totalAmounts = [self.noOfPilsTaken.text integerValue] + responseData;
    mf.date = currentDate;
    mf.mHistory=@"history";
    NSMutableDictionary *obj = [[NSMutableDictionary alloc]init];
    
    NSString *timeStamp =[NSString stringWithFormat:@"%li%@",(long)data.mpId,currentTimeStamp];
    
    [obj setObject:[NSNumber numberWithInteger:mf.mpId] forKey:@"mpid"];
    [obj setObject:[NSNumber numberWithInteger:mf.totalAmounts] forKey:@"totalAmount"];
    [obj setObject:mf.date forKey:@"date"];
    [obj setObject:timeStamp forKey:@"timeStamp"];
    [obj setObject:mf.mHistory forKey:@"mHistory"];
    

    NSData *jsonData2 = [NSJSONSerialization dataWithJSONObject:obj options:kNilOptions error:nil];
    
    NSLog(@"Json data before request: %@",[[NSString alloc] initWithData:jsonData2 encoding:NSUTF8StringEncoding]);
    
    //NSString *jsonString = [[NSString alloc]initWithData:jsonData2 encoding:NSUTF8StringEncoding];
    NSString *stringUrl = [NSString stringWithFormat:@"%@medicinefeedback",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];

  //  NSURL *url = [NSURL URLWithString:@"http://localhost:8080/finalproject/medicinefeedback"];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[jsonData2 length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:jsonData2];
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:jsonData2 encoding:NSUTF8StringEncoding]);
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    NSString *responseData = [[NSString alloc]initWithData:result encoding:NSUTF8StringEncoding];
    NSLog(@"Response ==> %@", responseData);    
    
}




- (IBAction)valueChanged:(UIStepper *)sender {
    self.pilsStepper.maximumValue = data.maxquantity;
    NSUInteger value = sender.value;
    if(value > data.maxquantity){
        self.pilsStepper.enabled = NO;
    }
    self.noOfPilsTaken.text = [NSString stringWithFormat:@"%lu",(unsigned long)value];
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex{
    NSLog(@"Entered: %@",[[alertView textFieldAtIndex:0] text]);
}
@end
