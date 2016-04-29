//
//  modalView.h
//  final
//
//  Created by apple on 5/31/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface modalView : UIViewController{
   // NSString *amount;
}
@property (weak, nonatomic) NSString *amount;
@property (weak, nonatomic) IBOutlet UILabel *pilsamt;
@property (weak, nonatomic) IBOutlet UIStepper *pilsStepper;
- (IBAction)valueChanged:(id)sender;

- (IBAction)submit:(id)sender;


@end
