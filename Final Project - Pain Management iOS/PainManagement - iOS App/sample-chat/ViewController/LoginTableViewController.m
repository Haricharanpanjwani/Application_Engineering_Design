//
//  LoginTableViewController.m
//  sample-chat
//
//

#import "LoginTableViewController.h"
#import "ServicesManager.h"
#import "UsersDataSource.h"
#import "AppDelegate.h"
#import "DialogsViewController.h"
#import "ChatViewController.h"
#import "SWRevealViewController.h"

@interface LoginTableViewController () <NotificationServiceDelegate>

@property (strong, nonatomic) UsersDataSource *dataSource;
@property (nonatomic, assign, getter=isUsersAreDownloading) BOOL usersAreDownloading;

@end

@implementation LoginTableViewController

/*
 *  Default test users password
 */
static NSString *const kTestUsersDefaultPassword = @"123456789";
//static NSString *const kTestUsersDefaultPassword = @"x6Bt0VDy5";

- (void)viewDidLoad
{
	[super viewDidLoad];
    
    /*
        Adding code to send the user Account from
        LoginTableViewController to ServicesManager
     */
    self.tableView.backgroundColor=[UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    
    
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sideBarButton setTarget:self.revealViewController];
        [self.sideBarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
        self.userAccount = revealViewController.ua;
    }
    
    ServicesManager.instance.ua = self.userAccount;
    
    NSLog(@"UserAccount in Login Table: %ld", (long)self.userAccount.userId);
    
    if (ServicesManager.instance.currentUser != nil) {
        // loggin in with previous user
        ServicesManager.instance.currentUser.password = kTestUsersDefaultPassword;
        [SVProgressHUD showWithStatus:[NSLocalizedString(@"SA_STR_LOGGING_IN_AS", nil) stringByAppendingString:ServicesManager.instance.currentUser.login] maskType:SVProgressHUDMaskTypeClear];
        
        __weak __typeof(self)weakSelf = self;
        [ServicesManager.instance logInWithUser:ServicesManager.instance.currentUser completion:^(BOOL success, NSString *errorMessage) {
            if (success) {
                __typeof(self) strongSelf = weakSelf;
                [strongSelf registerForRemoteNotifications];
                [SVProgressHUD showSuccessWithStatus:NSLocalizedString(@"SA_STR_LOGGED_IN", nil)];
                
                if (ServicesManager.instance.notificationService.pushDialogID == nil) {
                    [strongSelf performSegueWithIdentifier:kGoToDialogsSegueIdentifier sender:nil];
                }
                else {
                    [ServicesManager.instance.notificationService handlePushNotificationWithDelegate:self];
                }
                
            } else {
                [SVProgressHUD showErrorWithStatus:NSLocalizedString(@"SA_STR_ERROR", nil)];
            }
        }];
    }

    [self retrieveUsers];
}

- (void)retrieveUsers
{
	__weak __typeof(self)weakSelf = self;
    
    // Retrieving users from cache.
    [[[ServicesManager instance].usersService loadFromCache] continueWithBlock:^id(BFTask *task) {
        //
        if ([task.result count] > 0) {
            [weakSelf loadDataSourceWithUsers:[[ServicesManager instance] filteredUsersByCurrentEnvironment]];
        } else {
            [weakSelf downloadLatestUsers];
        }
        
        return nil;
    }];
}

- (void)downloadLatestUsers
{
	if (self.isUsersAreDownloading) return;
    
	self.usersAreDownloading = YES;
	
	__weak __typeof(self)weakSelf = self;
    [SVProgressHUD showWithStatus:NSLocalizedString(@"SA_STR_LOADING_USERS", nil) maskType:SVProgressHUDMaskTypeClear];
	
    // Downloading latest users.
	[[ServicesManager instance] downloadLatestUsersWithSuccessBlock:^(NSArray *latestUsers) {
        [SVProgressHUD showSuccessWithStatus:NSLocalizedString(@"SA_STR_COMPLETED", nil)];
        [weakSelf loadDataSourceWithUsers:latestUsers];
        weakSelf.usersAreDownloading = NO;
	} errorBlock:^(NSError *error) {
		[SVProgressHUD showErrorWithStatus:[NSString stringWithFormat:@"%@: %@", NSLocalizedString(@"SA_STR_CANT_DOWNLOAD_USERS", nil), error.localizedRecoverySuggestion]];
		weakSelf.usersAreDownloading = NO;
	}];
}

- (void)loadDataSourceWithUsers:(NSArray *)users
{
	self.dataSource = [[UsersDataSource alloc] initWithUsers:users];
    self.dataSource.isLoginDataSource = YES;
	self.tableView.dataSource = self.dataSource;
	[self.tableView reloadData];
}

#pragma mark - NotificationServiceDelegate protocol

- (void)notificationServiceDidStartLoadingDialogFromServer {
    [SVProgressHUD showWithStatus:NSLocalizedString(@"SA_STR_LOADING_DIALOG", nil) maskType:SVProgressHUDMaskTypeClear];
}

- (void)notificationServiceDidFinishLoadingDialogFromServer {
    [SVProgressHUD dismiss];
}

- (void)notificationServiceDidSucceedFetchingDialog:(QBChatDialog *)chatDialog {
    DialogsViewController *dialogsController = (DialogsViewController *)[self.storyboard instantiateViewControllerWithIdentifier:@"DialogsViewController"];
    ChatViewController *chatController = (ChatViewController *)[self.storyboard instantiateViewControllerWithIdentifier:@"ChatViewController"];
    chatController.dialog = chatDialog;
    
    self.navigationController.viewControllers = @[dialogsController, chatController];
}

- (void)notificationServiceDidFailFetchingDialog {
    [self performSegueWithIdentifier:kGoToDialogsSegueIdentifier sender:nil];
}

#pragma mark - Push Notifications

- (void)registerForRemoteNotifications{
    
#if __IPHONE_OS_VERSION_MAX_ALLOWED >= 80000
    if ([[UIApplication sharedApplication] respondsToSelector:@selector(registerUserNotificationSettings:)]) {
        
        [[UIApplication sharedApplication] registerUserNotificationSettings:[UIUserNotificationSettings settingsForTypes:(UIUserNotificationTypeSound | UIUserNotificationTypeAlert | UIUserNotificationTypeBadge) categories:nil]];
        [[UIApplication sharedApplication] registerForRemoteNotifications];
    }
    else{
        [[UIApplication sharedApplication] registerForRemoteNotificationTypes:UIRemoteNotificationTypeAlert | UIRemoteNotificationTypeBadge | UIRemoteNotificationTypeSound];
    }
#else
    [[UIApplication sharedApplication] registerForRemoteNotificationTypes:UIRemoteNotificationTypeAlert | UIRemoteNotificationTypeBadge | UIRemoteNotificationTypeSound];
#endif
}

#pragma mark - Table view data source

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
	
	QBUUser *selectedUser = self.dataSource.users[indexPath.row];
	selectedUser.password = kTestUsersDefaultPassword;
	
    [SVProgressHUD showWithStatus:[NSLocalizedString(@"SA_STR_LOGGING_IN_AS", nil) stringByAppendingString:selectedUser.login] maskType:SVProgressHUDMaskTypeClear];
	
	__weak __typeof(self)weakSelf = self;
    // Logging in to Quickblox REST API and chat.
    [ServicesManager.instance logInWithUser:selectedUser completion:^(BOOL success, NSString *errorMessage) {
        if (success) {
            [SVProgressHUD showSuccessWithStatus:NSLocalizedString(@"SA_STR_LOGGED_IN", nil)];
            [weakSelf registerForRemoteNotifications];
            __typeof(self) strongSelf = weakSelf;
            [strongSelf performSegueWithIdentifier:kGoToDialogsSegueIdentifier sender:nil];
        } else {
            [SVProgressHUD showErrorWithStatus:NSLocalizedString(@"SA_STR_ERROR", nil)];
        }
    }];
	
	[tableView deselectRowAtIndexPath:indexPath animated:YES];
}

- (IBAction)backToLoginViewController:(UIStoryboardSegue *)segue
{

}

@end
