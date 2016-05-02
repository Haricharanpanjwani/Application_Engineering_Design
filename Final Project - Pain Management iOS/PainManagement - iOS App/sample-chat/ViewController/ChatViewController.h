//
//  ChatViewController.h
//  sample-chat
//
//

#import <UIKit/UIKit.h>
#import "QMChatViewController.h"

@interface ChatViewController : QMChatViewController

@property (nonatomic, strong) QBChatDialog* dialog;
@property (nonatomic, assign) BOOL shouldUpdateNavigationStack;

@end
