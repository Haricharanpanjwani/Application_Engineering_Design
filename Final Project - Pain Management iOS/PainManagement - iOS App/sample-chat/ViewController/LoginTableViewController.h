//
//  LoginTableViewController.h
//  sample-chat
//
//

#import <UIKit/UIKit.h>
#import "UserAccount.h"

@interface LoginTableViewController : UITableViewController

@property UserAccount *userAccount;

@property (weak, nonatomic) IBOutlet UIBarButtonItem *sideBarButton;

@end
