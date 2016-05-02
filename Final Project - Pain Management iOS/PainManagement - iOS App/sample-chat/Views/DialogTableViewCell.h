//
//  DialogTableViewCell.h
//  sample-chat
//
//

#import <UIKit/UIKit.h>

@interface DialogTableViewCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UIView *unreadContainerView;
@property (weak, nonatomic) IBOutlet UILabel *unreadCountLabel;
@property (weak, nonatomic) IBOutlet UIImageView *dialogImageView;
@property (weak, nonatomic) IBOutlet UILabel *dialogNameLabel;
@property (weak, nonatomic) IBOutlet UILabel *lastMessageTextLabel;

@end
