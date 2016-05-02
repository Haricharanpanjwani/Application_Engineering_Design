//
//  UsersDataSource.h
//  sample-chat
//
//

#import <Foundation/Foundation.h>

/**
 Users datasource for table view.
 */
@interface UsersDataSource : NSObject<UITableViewDataSource>

- (instancetype)initWithUsers:(NSArray *)users;

/**
 *  Adds users to datasource.
 *
 *  @param users NSArray of users to add.
 */
- (void)addUsers:(NSArray *)users;

/**
 *  Default: empty []
 *  Excludes users with given ids from data source
 */

/**
 *  @return Array of QBUUser instances
 */
@property (nonatomic, strong, readonly) NSArray *users;
@property (nonatomic, strong) NSArray *excludeUsersIDs;
@property (nonatomic, assign) BOOL isLoginDataSource;

- (NSUInteger)indexOfUser:(QBUUser *)user;
- (UIColor *)colorForUser:(QBUUser *)user;

@end
