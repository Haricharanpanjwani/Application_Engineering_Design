//
//  UserTableViewCell.h
//  sample-chat
//
//

#import <UIKit/UIKit.h>

@interface UserTableViewCell : UITableViewCell

@property (nonatomic, strong) QBUUser *user;
@property (nonatomic, strong) NSString *userDescription;

- (void)setColorMarkerText:(NSString *)text andColor:(UIColor *)color;

@end
