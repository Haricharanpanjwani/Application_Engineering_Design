//
//  CornerView.h
//  sample-chat
//
//

#import <UIKit/UIKit.h>

@interface CornerView : UIView

@property (strong, nonatomic) UIColor *bgColor;
@property (strong, nonatomic) NSString *title;
@property (assign, nonatomic) CGFloat cornerRadius;
@property (assign, nonatomic) CGFloat fontSize;
@property (copy, nonatomic) void(^touchesEndAction)(void);

@end