//
//  CreateHospitalView.m
//  Assignment 6
//
//  Created by Hari Panjwani on 3/20/16.
//  Copyright © 2016 Hari Panjwani. All rights reserved.
//

#import "CreateHospitalView.h"

@interface CreateHospitalView ()

@end

@implementation CreateHospitalView

@synthesize viewController;
@synthesize hospital;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}

- (ViewController *) viewController {
    
    if(!viewController) {
        viewController = [[ViewController alloc] initWithNibName:nil bundle: nil];
        viewController.title = @"Hospital";
    }
    return viewController;
}

- (IBAction)createHospital:(id)sender {
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    
    NSString *rawHospitalName = self.hospitalName.text;
    NSString *trimmedHospitalName = [rawHospitalName stringByTrimmingCharactersInSet:whitespace];
    
    if (!([trimmedHospitalName length] > 0) || [trimmedHospitalName isEqual:@""] == TRUE) {
    
    
        UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Error" message:@"Hospital Name Cannot be empty!" preferredStyle:UIAlertControllerStyleAlert];
    
        UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault handler:^(UIAlertAction * action) {}];
        [alert addAction:defaultAction];
    
        [self presentViewController:alert animated:YES completion:nil];
        return;
    }
    else {
        self.hospital.hospitalName = self.hospitalName.text;
        self.viewController.hospital = self.hospital;
        [self.navigationController pushViewController:self.viewController animated:YES];
        
        NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
        NSString *documentPath = [paths objectAtIndex:0];
        NSString *filePath = [documentPath stringByAppendingPathComponent:@"assignment6.txt"];
        
        NSMutableData *data = [NSMutableData data];
        NSKeyedArchiver *archiver = [[NSKeyedArchiver alloc] initForWritingWithMutableData:data];
        [archiver encodeObject:self.hospital forKey:@"hospital"];
        [archiver finishEncoding];
        
        NSURL *archiveURL = [[NSURL alloc] initFileURLWithPath:filePath];
        BOOL result = [data writeToURL:archiveURL atomically:YES];
        
        if(result) {
            
            UIAlertController* alert = [UIAlertController alertControllerWithTitle:@"Success" message:@"Hospital has been created Successfully!!" preferredStyle:UIAlertControllerStyleAlert];
            
            UIAlertAction* defaultAction = [UIAlertAction actionWithTitle:@"OK" style:UIAlertActionStyleDefault handler:^(UIAlertAction * action) {}];
            [alert addAction:defaultAction];
            
            [self presentViewController:alert animated:YES completion:nil];
        }
        
    }
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
