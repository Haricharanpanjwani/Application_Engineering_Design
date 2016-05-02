//
//  modalView.m
//  final
//
//  Created by apple on 5/31/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "modalView.h"

@implementation modalView

@synthesize amount;

- (IBAction)valueChanged:(UIStepper *)sender {
    NSUInteger value = sender.value;
    [self.pilsamt setText:[NSString stringWithFormat:@"%lu",(unsigned long)value]];
   }

- (IBAction)submit:(id)sender {
   
}
@end
