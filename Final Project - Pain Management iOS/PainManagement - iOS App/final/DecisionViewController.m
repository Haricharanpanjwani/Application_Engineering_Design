//
//  DecisionViewController.m
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/28/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "DecisionViewController.h"
#import "EmailViewController.h"
#import "QuestionViewController.h"
#import "AccordionViewControllerTableViewController.h"
#import "Constants.h"


@implementation DecisionViewController
@synthesize button,somearray,jsonarray;

-(id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    
    if(self){
        
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    somearray = [[NSMutableArray alloc] init];
    arrayData =[[NSArray alloc]initWithArray:[NSArray arrayWithObjects:@"Pain",@"Sleep",@"Mood",@"Other", nil]];
      
    self.picker.dataSource = self;
    self.picker.delegate = self;
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources tha can be recreated.
}

- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView
{
    return 1;
}

// The number of rows of data
- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component
{
    return [arrayData count];
}

// The data to return for the row and component (column) that's being passed in
- (NSString*)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component
{
    return arrayData[row];
}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component
{
    selectedRow = row;
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    if([segue.identifier isEqualToString:@"other"]){
        AccordionViewControllerTableViewController *avc = (AccordionViewControllerTableViewController*)[segue destinationViewController];
        avc.ua = self.ua;

    }else if([segue.identifier isEqualToString:@"questions"]){
        QuestionViewController *qvc= (QuestionViewController*)[segue destinationViewController];
        qvc.ua =self.ua;
        qvc.quesCategory = [arrayData objectAtIndex: selectedRow];
       // qvc.jsonarray = jsonarray; // to pass data to question controller
        
    }
 }

- (IBAction)optionSelected:(id)sender {
    
    NSString *data = [arrayData objectAtIndex: selectedRow];
    
    NSLog(@"Selected choce %@",data);
    
    if ([data isEqualToString:@"Other"]) {
        [self performSegueWithIdentifier:@"other" sender:sender];
    } else {
        [self performSegueWithIdentifier:@"questions" sender:sender];
    }
    
}

-(void)doctorViewController:(EmailViewController *)evc didChooseValue:(NSMutableArray *)profile{
    self.ua = [profile objectAtIndex:0];
    [self viewDidLoad];
    }
@end
