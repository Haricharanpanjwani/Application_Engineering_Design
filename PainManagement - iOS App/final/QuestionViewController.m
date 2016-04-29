//
//  QuestionViewController.m
//  final
//
//  Created by Manali Rajesh Chheda on 4/30/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import "QuestionViewController.h"

#import "SidebarViewController.h"
#import "MainViewController.h"
#import "Feedback.h"
#import "AccordionViewControllerTableViewController.h"
#import "Constants.h"
#import "QuestionType.h"
#import "Questions.h"
#import "Instrcutions.h"
#import "Answer.h"
#import "MainQuestion.h"

@interface QuestionViewController ()

@end

@implementation QuestionViewController
@synthesize questions,ua,instructionText,textField;
@synthesize questionNumber;
@synthesize questionLabel,instruction1,instruction2,instruction3,instruction4,instruction5;
@synthesize answers,instructionsDetails;
@synthesize answer;
@synthesize answerNumber;
@synthesize correctAnswers,reponse;
@synthesize correctAnswerNumber;
@synthesize correctOrFalse,timeInt,questionScoreInt, totalScoreInt;
@synthesize nextQuestionButton;
@synthesize buttonA, buttonB, buttonC;
@synthesize instructions;
@synthesize mySlider,myLabel;
@synthesize data,jsonarray;
@synthesize feedbackarray,arr;
@synthesize tenlabel, zerolab,smiley, smileydesc, sad, saddesc,maxval,minVal;

- (void)initQuiz{
    // ENTER QUESTIONS
    questions = [[NSMutableArray alloc] init];
    arr = [[NSMutableArray alloc]init];
    

    for(id object in jsonarray){
        
        MainQuestion *mq = [[MainQuestion alloc]init];
        id q= [object objectForKey:@"question"];
        
        mq.questionId = [[q objectForKey:@"questionid"] integerValue];
        mq.questionDetails = [q objectForKey:@"questiondetail"];
        mq.answerId = [[object objectForKey:@"answerid"]integerValue];
        
        id a = [object objectForKey:@"answer"];
        mq.answerdetail = [a objectForKey:@"answerdetail"];
        mq.answertype = [a objectForKey:@"answertype"];
        mq.answerId= [[a objectForKey:@"answerid"]integerValue];
        
        id subobjects = [object objectForKey:@"instruction"];
        for(id o in subobjects){
            Instrcutions *is = [[Instrcutions alloc]init];
            is.instructionId = [[o objectForKey:@"instructionid"]integerValue];
            is.instructionDetail = [o objectForKey:@"instructiondetail"];
            [mq.instructionList addObject:is];
        }
        [questions addObject:mq];
        break;
    }
    
    NSString *questionString = [[NSString alloc] initWithFormat:@"%lu", (unsigned long)[questions count]];
    int questionNo = [questionString intValue];
    NSString *answersString = [[NSString alloc] initWithFormat:@"%lu", (unsigned long)[answers count]];
    int answerNo = [answersString intValue]/3;
    NSString *correctAnswersString = [[NSString alloc] initWithFormat:@"%lu", (unsigned long)[correctAnswers count]];
    int correctAnswersNo = [correctAnswersString intValue];
    if ((questionNo == answerNo) && (questionNo == correctAnswersNo)) {
        NSLog(@"Questions, answers and correct answers written");
    } else {
        NSLog(@"\nWARNING APP WILL CRASH \nSOLUTION: \nCheck if you have the same amount of questions and CORRECT answers, AND if you have 3 answers for each question!");
        NSLog(@"\nQUESTIONS = %d \nANSWERS = %d (3 times more) \nCORRECTANSWERS = %d", questionNo, [answersString intValue], correctAnswersNo);
    }
    
}

-(void)converttojson{
    
    NSFileManager *mgr = [NSFileManager defaultManager];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"Reports"];
    NSString *filePath = [documentsDirectory stringByAppendingPathComponent:@"report.txt"];
    NSMutableArray *temparray = [[NSMutableArray alloc]init];
//
//    if([mgr fileExistsAtPath:filePath] == YES){
//        
//        NSLog(@"File exists");
//        NSString *stringhere = [NSString stringWithContentsOfFile:filePath encoding:NSUTF8StringEncoding error:NULL];
//        NSData *jsonData2 = [stringhere dataUsingEncoding:NSUTF8StringEncoding];
//        
//        temparray = [NSJSONSerialization JSONObjectWithData:jsonData2 options:kNilOptions error:nil];
//        
//        for(id object in arr){
//            [temparray addObject:object];
//            break;
//        }
//        
//    }
    
    NSData *jsonData2 = [NSJSONSerialization dataWithJSONObject:arr options:NSJSONWritingPrettyPrinted error:nil];
    NSString *stringUrl = [NSString stringWithFormat:@"%@questionfeedback",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[jsonData2 length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:jsonData2];
    
    NSLog(@"JSON summary of question : %@",[[NSString alloc] initWithData:jsonData2 encoding:NSUTF8StringEncoding]);
    
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    NSString *responseData = [[NSString alloc]initWithData:result encoding:NSUTF8StringEncoding];
    NSLog(@"Response ==> %@", responseData);
    
    //report generation
    if ([response statusCode] >= 200 && [response statusCode] < 300)
    {
        NSLog(@"Successfully save to database!!");
        
        NSError *error;
        
        if ([[NSFileManager defaultManager] fileExistsAtPath:documentsDirectory])	//Does directory exist?
        {
            if (![[NSFileManager defaultManager] removeItemAtPath:documentsDirectory error:&error]) {
                NSLog(@"Delete directory error: %@", error);
            }
        }
        
        [self saveAnswers];
        
    } else {
        //[self saveAnswers];
        NSLog(@"Error in saving answers file");
    }
    
}

-(void)saveAnswers{
    
    NSFileManager *mgr = [NSFileManager defaultManager];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"Reports"];
    NSString *filePath = [documentsDirectory stringByAppendingPathComponent:@"report.txt"];
    
    NSError *error;
    
    // Creating the Directory Reports
    if (![[NSFileManager defaultManager] fileExistsAtPath:documentsDirectory])//Does directory already exist
    {
        if (![[NSFileManager defaultManager] createDirectoryAtPath:documentsDirectory
                                       withIntermediateDirectories:NO
                                                        attributes:nil
                                                             error:&error])
        {
            NSLog(@"Create directory error: %@", error);
        }
    }
    
    NSData *jsonData2 = [NSJSONSerialization dataWithJSONObject:arr options:NSJSONWritingPrettyPrinted error:nil];
    
    // Creating a file with name Report.txt
    if (![[NSFileManager defaultManager] fileExistsAtPath:filePath]) {
        if(![[NSFileManager defaultManager] createFileAtPath:filePath
                                                    contents:jsonData2
                                                  attributes:nil]) {
            NSLog(@"Create Report File error: %@", error);
        }
    }
    
    NSLog(@"File Path: %@", filePath);
 
//    Commenting to check
    
//    if([mgr fileExistsAtPath:filePath] == YES){
//        
//        NSLog(@"File exists");
//        NSString *str = [NSString stringWithContentsOfFile:filePath encoding:NSUTF8StringEncoding error:NULL];
//        NSData *jsonData2 = [str dataUsingEncoding:NSUTF8StringEncoding];
//        NSArray *temparray = [[NSArray alloc]init];
//        temparray = [NSJSONSerialization JSONObjectWithData:jsonData2 options:kNilOptions error:nil];
//        
//        for(id object in temparray){
//            [arr addObject:object];
//            //break;
//        }
//    
//        NSData *jsonData3 = [NSJSONSerialization dataWithJSONObject:arr options:NSJSONWritingPrettyPrinted error:nil];
//        NSString *string = [[NSString alloc]initWithData:jsonData3 encoding:NSUTF8StringEncoding];
//        [string writeToFile:filePath atomically:TRUE encoding:NSUTF8StringEncoding error:NULL];
//        
//        
//    }
//    else {
//        
//        NSData *jsonData2 = [NSJSONSerialization dataWithJSONObject:arr options:NSJSONWritingPrettyPrinted error:nil];
//        NSString *string = [[NSString alloc]initWithData:jsonData2 encoding:NSUTF8StringEncoding];
//        [string writeToFile:filePath atomically:TRUE encoding:NSUTF8StringEncoding error:NULL];
//    }
    
}

- (IBAction)nextQuestion {
    instructionText.hidden = YES;
    textField.hidden = YES;
    questionLabel.hidden = NO;
    answer.hidden = YES;
    instructions.hidden = NO;
    buttonA.enabled = YES;
    mySlider.enabled = YES;
    
    buttonA.hidden = NO;
    mySlider.hidden = NO;
    myLabel.hidden = NO;
    
    tenlabel.hidden = NO;
    zerolab.hidden = NO;
    smileydesc.hidden = NO;
    smiley.hidden = NO;
    saddesc.hidden = NO;
    sad.hidden = NO;
    ins1 = NO;
    ins2 = NO;ins3 = NO;
    ins4 = NO;
    ins5 = NO;
    
    if (questionNumber >= [questions count]) {
        
        
        [self converttojson];
        [self pushMyNewViewController];
        
        
    } else {
        MainQuestion *quest = [questions objectAtIndex:questionNumber];
        
        questionLabel.text =[[NSString alloc]
                             initWithFormat:@"Question %d \n%@", questionNumber+1, quest.questionDetails];
        mySlider.minimumValue = 0;
        mySlider.maximumValue = [quest.answerdetail intValue];
        mySlider.value = mySlider.maximumValue/2;
        maxval.text = [NSString stringWithFormat:@"%@",quest.answerdetail];
        minVal.text = @"0";
        
        
        myLabel.text = 0;
        
        [quest.instructionList enumerateObjectsUsingBlock:^(id  _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
            if(ins1 == NO){
            instruction1.hidden = NO;
            instruction1.text = [NSString stringWithFormat:@"%lu. %@",(unsigned long)idx,[obj instructionDetail]];
                ins1 = YES;
            }else if(ins2 == NO){
                instruction2.hidden = NO;
                instruction2.text = [NSString stringWithFormat:@"%lu. %@",(unsigned long)idx,[obj instructionDetail]];
                ins2 = YES;
            }else if(ins3 == NO){
                instruction3.hidden = NO;
                instruction3.text = [NSString stringWithFormat:@"%lu. %@",(unsigned long)idx,[obj instructionDetail]];
                ins3 = YES;
            }else if(ins4 == NO){
                instruction4.hidden = NO;
                instruction4.text = [NSString stringWithFormat:@"%lu. %@",(unsigned long)idx,[obj instructionDetail]];
                ins4 = YES;
            }else if(ins5 == NO){
                instruction5.hidden = NO;
                instruction5.text = [NSString stringWithFormat:@"%lu. %@",(unsigned long)idx,[obj instructionDetail]];
                ins5 = YES;
            }
        }];
        
        [self setQuestionNumber:questionNumber +1];
        nextQuestionButton.hidden = YES;
        [[self nextQuestionButton] setTitle:@"Next >" forState:UIControlStateNormal];
        
        [[self instructions] setTitle:@"< Previous" forState:UIControlStateNormal];
    }
}

-(IBAction)prevQuestion:(id)sender{
    answer.hidden = NO;
    nextQuestionButton.hidden = NO;
    buttonA.enabled  =YES;
    mySlider.enabled = YES;
    
    buttonA.hidden = NO;
    mySlider.hidden = NO;
    myLabel.hidden = NO;
    
    tenlabel.hidden = NO;
    zerolab.hidden = NO;
    smileydesc.hidden = NO;
    smiley.hidden = NO;
    saddesc.hidden = NO;
    sad.hidden = NO;
    
    if(questionNumber >1){
        questionLabel.text=[[NSString alloc]
                            initWithFormat:@"Question %d \n%@", questionNumber-1, [[questions objectAtIndex:questionNumber-1]objectForKey:@"questiondetail"]];
        mySlider.value = 5.0;
        myLabel.text = 0;
        
        [self setQuestionNumber:questionNumber-1];
        nextQuestionButton.hidden = NO;
        [[self nextQuestionButton] setTitle:@"Next >" forState:UIControlStateNormal];
        
        [[self instructions] setTitle:@"< Previous " forState:UIControlStateNormal];
    }
}

- (IBAction)pushMyNewViewController
{
    [self performSegueWithIdentifier:@"main" sender:nil];
   
}


- (IBAction)pressedAnswer:(id)sender {
    NSString *enteredResponse = [NSString stringWithFormat:@"%d", (int)self.mySlider.value];
    
    NSLog(@"Enterred value %@",enteredResponse);
    NSString *MyString;
    
    NSDate *now = [NSDate date];
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyy-MM-dd'T'HH:mm:ss.SSS"];
    MyString = [dateFormatter stringFromDate:now];
    
    Feedback *feedback = [[Feedback alloc]init];
    
    feedback.feedbackId = [NSString stringWithFormat:@"%d %@",questionNumber,MyString];
    feedback.questionId = questionNumber;
    feedback.answerValue = enteredResponse;
    feedback.answerType =[NSString stringWithFormat:@"%d",1] ;
    feedback.userId = self.ua.userId;
    NSMutableDictionary *obj = [[NSMutableDictionary alloc]init];
  
    
    [obj setObject:feedback.feedbackId forKey:@"feedbackid"];
    [obj setObject:[NSNumber numberWithInteger:feedback.questionId] forKey:@"questionid"];
    [obj setObject:feedback.answerValue forKey:@"answervalue"];
    [obj setObject:[NSNumber numberWithInteger:feedback.userId] forKey:@"userid"];
    [obj setObject:feedback.answerType forKey:@"answertype"];
    [arr addObject:obj];
                           
    [feedbackarray addObject:feedback];
    
    buttonA.enabled = NO;
    mySlider.enabled = NO;
    
    
    correctOrFalse.textColor = [UIColor greenColor];
    [self setQuestionScoreInt:0];
    nextQuestionButton.hidden = NO;

}

- (void)noMoreBlocked {
     buttonA.hidden = NO;
}

- (IBAction)instructionAction {
   // answer.hidden = YES;
    //answer.text = @"Press 'touch to begin' to start. Answer the questions by sliding the slider and then clicking done button.Have //fun!";
    answer.hidden = NO;
    nextQuestionButton.hidden = NO;
    buttonA.enabled  =YES;
    mySlider.enabled = YES;
    
    buttonA.hidden = NO;
    mySlider.hidden = NO;
    myLabel.hidden = NO;
    
    if(questionNumber >1){
        questionLabel.text=[[NSString alloc]
                            initWithFormat:@"Question %d \n%@", questionNumber-1, [[questions objectAtIndex:questionNumber-1]objectForKey:@"questiondetail"]];
        mySlider.value = 5.0;
        myLabel.text = 0;
        
        [self setQuestionNumber:questionNumber-1];
        nextQuestionButton.hidden = NO;
        [[self nextQuestionButton] setTitle:@"Next >" forState:UIControlStateNormal];
        [[self instructions] setTitle:@"< Previous " forState:UIControlStateNormal];
    }
}


- (void)viewDidLoad {
    questionLabel.lineBreakMode = NSLineBreakByWordWrapping;
    questionLabel.numberOfLines = 0;
    questionLabel.hidden = YES;
    answer.lineBreakMode = NSLineBreakByWordWrapping;
    answer.numberOfLines = 0;
    buttonA.hidden = YES;
    mySlider.hidden = YES;
    myLabel.hidden = YES;
    tenlabel.hidden = YES;
    zerolab.hidden = YES;
    smileydesc.hidden = YES;
    smiley.hidden = YES;
    saddesc.hidden = YES;
    sad.hidden = YES;
    instruction1.hidden = YES;
    instruction2.hidden = YES;
    instruction3.hidden = YES;
    instruction4.hidden = YES;
    instruction5.hidden = YES;
    maxval.hidden = YES;
    minVal.hidden = YES;
    ins1 = NO;
    ins2 = NO;ins3 = NO;
    ins4 = NO;
    ins5 = NO;
    
    
    self.mySlider.minimumValue = 0;
    self.mySlider.maximumValue = 10;
    
    myLabel.text = @"5";
    
    CGRect viewFrame = CGRectMake(20.0f, 20.0f, 300.0f, 300.0f);
    instructionText = [[UITextField alloc]initWithFrame:viewFrame];
    instructionText.text = @"Instruction for questionnaire ";
    instructionText.textColor = [UIColor brownColor];
    instructionText.font =[UIFont boldSystemFontOfSize:20.0f];
    instructionText.enabled = false;
    instructionText.textAlignment = NSTextAlignmentCenter;
    [self.view addSubview:instructionText];
    
    CGRect textFieldFrame = CGRectMake(20.0, 150.0, 300.0f, 300.0f);
    textField = [[UITextView alloc] initWithFrame:textFieldFrame];
    [textField setTag:1234];
    [textField setTextColor:[UIColor brownColor]];
    [textField setFont:[UIFont systemFontOfSize:20]];
    [textField setText:@"\n\nPress 'touch to begin' to start.\n\nAnswer the questions by sliding the slider.\n\nThen clicking Done button.\n\nThus Help us to collect your current state!"];
    [textField setBackgroundColor:[UIColor clearColor]];
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    
    [textField sendSubviewToBack: imageview];
    
     [self.view addSubview:textField];
    
    
    UIImage *minImage = [[UIImage imageNamed:@"slider_minimum.png"] resizableImageWithCapInsets:UIEdgeInsetsMake(0, 5, 0, 0)];
    
    UIImage *maxImage = [[UIImage imageNamed:@"slider_maximum.png"] resizableImageWithCapInsets:UIEdgeInsetsMake(0, 0, 0, 5)];
    
    UIImage *thumbImage = [UIImage imageNamed:@"sliderhandle.png"];
    
    
    
    [[UISlider appearance] setMaximumTrackImage:maxImage forState:UIControlStateNormal];
    
    [[UISlider appearance] setMinimumTrackImage:minImage forState:UIControlStateNormal];
    
    [[UISlider appearance] setThumbImage:thumbImage forState:UIControlStateNormal];
    
    nextQuestionButton.hidden = NO;
    instructions.hidden = YES;
    answer.hidden = YES;
    [[self nextQuestionButton] setTitle:@"Touch to begin" forState:UIControlStateNormal];
    [super viewDidLoad];
    
    feedbackarray = [[NSMutableArray alloc]init];
    
    /*QuestionType *qt = [[QuestionType alloc]init];
    qt.type = self.quesCategory;
    
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:@"type",self.quesCategory,nil];
    NSData * data = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];

    
    //NSData *qdata = //[qt dataUsingEncoding:NSUTF8StringEncoding];
    NSString *stringUrl = [NSString stringWithFormat:@"%@questions",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];

    
    
   // NSURL *url = [NSURL URLWithString:@"http://localhost:8080/finalproject/questions"];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[data length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:data];*/
    
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:self.quesCategory,@"type",nil];
    
    NSData *postData = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];
    
    
    NSString *postLength = [NSString stringWithFormat:@"%lu", (unsigned long)[postData length]];
    NSString *stringUrl = [NSString stringWithFormat:@"%@questions",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:postLength forHTTPHeaderField:@"Content-Length"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setHTTPBody:postData];
    
    
    [[NSURLConnection alloc] initWithRequest:request delegate:self];
    
}


- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response
{
    data = [[NSMutableData alloc]init];
    
}

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)thedata
{
    [data appendData:thedata];
}


- (void)connectionDidFinishLoading:(NSURLConnection *)connection
{
    [UIApplication sharedApplication].networkActivityIndicatorVisible = NO;
    
    jsonarray = [NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
    
    [self initQuiz];
}

- (void)connection:(NSURLConnection *)connection
{
    UIAlertView *errorview = [[UIAlertView alloc] initWithTitle:@"Error" message:@"we can download the data for you" delegate:nil cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
    
    [errorview show];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    if([segue.identifier isEqualToString:@"main"]){
        
        AccordionViewControllerTableViewController *avc = (AccordionViewControllerTableViewController*)[segue destinationViewController];
        avc.ua = self.ua;
    
    }

}


- (IBAction)sliderValueChanged:(UISlider *)sender {

    UITapGestureRecognizer *gr = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(sliderTapped:)];
    
    [self.mySlider addGestureRecognizer:gr];
    
    self.myLabel.text =  [NSString stringWithFormat:@"%d", (int)sender.value];

}

- (void)sliderTapped:(UIGestureRecognizer *)g {
    
    UISlider* s = (UISlider*)g.view;
    
    if (s.highlighted)
        
        return; // tap on thumb, let slider deal with it
    
    CGPoint pt = [g locationInView: s];
    
    CGFloat percentage = pt.x / s.bounds.size.width;
    
    CGFloat delta = percentage * (s.maximumValue - s.minimumValue);
    
    CGFloat value = s.minimumValue + delta;
    
    
    
    [s setValue:value animated:YES];
    self.myLabel.text = [NSString stringWithFormat: @"%0.0f", s.value];
    
}




@end
