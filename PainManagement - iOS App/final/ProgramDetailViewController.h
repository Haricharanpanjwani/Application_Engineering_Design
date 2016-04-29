//
//  ProgramDetailViewController.h
//  final
//
//  Created by apple on 5/31/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ProgramDetails.h"
#import "UserAccount.h"
#import <MediaPlayer/MediaPlayer.h>
#import <MobileCoreServices/MobileCoreServices.h>
#import <AVFoundation/AVFoundation.h>
#import <MobileCoreServices/MobileCoreServices.h>

@protocol programViewControllerDelegate;
@protocol UIWebViewDelegate;

@interface ProgramDetailViewController : UIViewController{
    ProgramDetails *data;
    UserAccount *ua;
     MPMoviePlayerViewController *moviePlayer;
     NSInteger selectedRow;
    UIWebView *youTubeWebView;
}

@property (weak, nonatomic) IBOutlet UIButton *playVideoButton;
@property(nonatomic,strong)ProgramDetails *data;
@property(nonatomic,strong)NSArray *pickerData;
@property(nonatomic,strong)UserAccount *ua;
@property (weak, nonatomic) IBOutlet UILabel *programName;
@property (weak, nonatomic) IBOutlet UIButton *done;
@property (weak, nonatomic) IBOutlet UITextView *programDescription;
@property (weak, nonatomic) IBOutlet UILabel *clickToWatch;

@property (nonatomic, weak) id<programViewControllerDelegate> delegate;
- (IBAction)playVideo:(id)sender;
@property (weak, nonatomic) IBOutlet UIPickerView *pickerView;
- (IBAction)done:(id)sender;

@end

@protocol programViewControllerDelegate <NSObject>

-(void)programViewController:(ProgramDetailViewController *)mvc didChooseValue:(UserAccount *)ua;

@end
