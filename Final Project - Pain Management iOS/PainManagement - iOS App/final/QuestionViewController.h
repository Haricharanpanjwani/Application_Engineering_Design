//
//  QuestionViewController.h
//  final
//
//  Created by Priya Dilipkumar Poptani on 4/30/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"
#import "ASValueTrackingSlider.h"
#import <MessageUI/MessageUI.h>

@interface QuestionViewController : UIViewController <MFMailComposeViewControllerDelegate>
{
    UserAccount *ua;
    NSArray *jsonarray;
    NSMutableData *data;
    NSMutableArray *feedbackarray;
    NSMutableArray *arr;
    UITextField *instructionText;
    UITextView *textField;
    BOOL ins1;
    BOOL ins2;
    BOOL ins3;
    BOOL ins4;
    BOOL ins5;
}

@property (strong,nonatomic) UITextField *instructionText;
@property (strong,nonatomic) UITextView *textField;
@property(strong,nonatomic)NSMutableArray *feedbackarray;
@property(strong,nonatomic)UserAccount *ua;
@property (weak, nonatomic) IBOutlet UILabel *questionLabel;
//@property (weak, nonatomic) IBOutlet UILabel *totalScore;
@property (weak, nonatomic) IBOutlet UILabel *correctOrFalse;
@property (weak, nonatomic) IBOutlet UIButton *nextQuestionButton;
@property (weak, nonatomic) IBOutlet UIButton *instructions;
@property (weak, nonatomic) IBOutlet UIButton *buttonA;
@property (weak, nonatomic) IBOutlet UIButton *buttonB;
@property (weak, nonatomic) IBOutlet UIButton *buttonC;
@property (weak, nonatomic) IBOutlet UILabel *answer;
@property (weak, nonatomic) IBOutlet UILabel *instruction1;
@property (weak, nonatomic) IBOutlet UILabel *instruction2;
@property (weak, nonatomic) IBOutlet UILabel *instruction3;
@property (weak, nonatomic) IBOutlet UILabel *instruction4;
@property (weak, nonatomic) IBOutlet UILabel *instruction5;
@property (weak, nonatomic) IBOutlet UILabel *minVal;
@property (weak, nonatomic) IBOutlet UILabel *maxval;
@property (strong,nonatomic) NSMutableArray *arr;

//@property (weak, nonatomic) IBOutlet UILabel *questionScore;

@property (strong,nonatomic) NSArray *jsonarray;
@property (strong,nonatomic) NSMutableData *data;
@property (strong,nonatomic)NSString* quesCategory;

- (IBAction)pressedAnswer:(id)sender;
- (IBAction)nextQuestion;
-(IBAction)prevQuestion:(id)sender;

@property int timeInt;
@property int totalScoreInt;
@property int questionScoreInt;

@property (nonatomic, retain) NSMutableArray *questions;
@property (nonatomic, retain) NSMutableArray *answers;
@property (nonatomic, retain) NSMutableArray *instructionsDetails;
@property (nonatomic, retain) NSMutableArray *correctAnswers;
@property (nonatomic, retain) NSMutableArray *reponse;
//@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;

@property int questionNumber;
@property int answerNumber;
@property int correctAnswerNumber;

@property (weak, nonatomic) IBOutlet UILabel *myLabel;
@property (weak, nonatomic) IBOutlet ASValueTrackingSlider *mySlider;
- (IBAction)sliderValueChanged:(ASValueTrackingSlider *)sender;
@property (weak, nonatomic) IBOutlet UILabel *zerolab;
@property (weak, nonatomic) IBOutlet UILabel *tenlabel;
@property (weak, nonatomic) IBOutlet UIImageView *smiley;
@property (weak, nonatomic) IBOutlet UIImageView *sad;
@property (weak, nonatomic) IBOutlet UILabel *smileydesc;
@property (weak, nonatomic) IBOutlet UILabel *saddesc;

- (void)showEmail:(NSString*)file;


@end
