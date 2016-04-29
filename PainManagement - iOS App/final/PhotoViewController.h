//
//  PhotoViewController.h
//  SidebarDemo
//
//  Created by Simon on 30/6/13.
//  Copyright (c) 2013 Appcoda. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MediaPlayer/MediaPlayer.h>
#import <MobileCoreServices/MobileCoreServices.h>
#import <AVFoundation/AVFoundation.h>
#import <MobileCoreServices/MobileCoreServices.h>

@interface PhotoViewController : UIViewController<UIImagePickerControllerDelegate, UINavigationControllerDelegate>
{
    AVAudioPlayer *audioPlayer;
    MPMoviePlayerViewController *moviePlayer;
}
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property (weak, nonatomic) IBOutlet UIImageView *photoImageView;
@property (strong, nonatomic) NSString *photoFilename;

@property(strong,nonatomic) NSURL *videoURL;
@property(strong,nonatomic) MPMoviePlayerController *videoController;


@end
