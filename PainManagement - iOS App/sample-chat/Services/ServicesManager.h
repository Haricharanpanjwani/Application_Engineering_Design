//
//  QBServiceManager.h
//  sample-chat
//
//  Created by Andrey Moskvin on 5/19/15.
//  Copyright (c) 2015 Igor Khomenko. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "NotificationService.h"
#import "UserAccount.h"

/**
 *  Implements logic connected with user's memory/disc storage, error handling, top bar notifications.
 */
@interface ServicesManager : QMServicesManager

/**
 *  Notification service.
 */
@property (nonatomic, readonly) NotificationService* notificationService;

/**
 *  Current opened dialog ID.
 */
@property (nonatomic, strong) NSString* currentDialogID;

/**
 *  Last activity date. Needed for updating chat dialogs when go back from tray.
 */
@property (strong, nonatomic) NSDate *lastActivityDate;

//User account from patient application
@property UserAccount *ua;

/**
 *  Downlaod latest users.
 */
- (void)downloadLatestUsersWithSuccessBlock:(void(^)(NSArray *latestUsers))successBlock errorBlock:(void(^)(NSError *error))errorBlock;

/**
 *  Filtering array of users by current environment.
 *
 *  @return Filtered array of users from memory storage by current unvironment.
 */
- (NSArray *)filteredUsersByCurrentEnvironment;

@end
