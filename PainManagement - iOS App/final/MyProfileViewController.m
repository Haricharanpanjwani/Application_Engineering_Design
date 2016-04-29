//
//  MyProfileViewController.m medicineDetails
//  final
//
//  Created by apple on 7/18/15.
//  Copyright (c) 2015 Priya Dilipkumar Poptani. All rights reserved.
//

//
//  AccordionViewControllerTableViewController.m
//  SidebarDemo
//
//  Created by Priya Dilipkumar Poptani on 4/30/15.
//  Copyright (c) 2015 Appcoda. All rights reserved.
//

#import "AccordionViewControllerTableViewController.h"
#import "AccordionGenericobject.h"
#import "SWRevealViewController.h"
#import "MainCategory.h"
#import "SubCategory.h"
#import "ProgramDetails.h"
#import "ProgramViewController.h"
#import "Constants.h"
#import "MyProfileViewController.h"
#import "PatientProfile.h"
#import "Profile.h"

@interface MyProfileViewController ()

@end

@implementation MyProfileViewController
@synthesize jsonData,data,ua,profile;

- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    jsonData = [[NSArray alloc]init];
    profile= [[PatientProfile alloc]init];
    
    
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sidebarButton setTarget:self.revealViewController];
        [self.sidebarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
        self.ua = revealViewController.ua;
    }
    
    self.title = [NSString stringWithFormat:@"%@'s Profile",self.ua.username];
    
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithLong:self.ua.userId],@"userid",self.ua.username,@"username",self.ua.password,nil];
    NSData * dataVal = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];
    
    
    NSString *stringUrl = [NSString stringWithFormat:@"%@patientproflie",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    //NSURL *url = [NSURL URLWithString:@"http://localhost:8080/finalproject/programs"];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[dataVal length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:dataVal];
    
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:dataVal encoding:NSUTF8StringEncoding]);
    
    NSHTTPURLResponse *response = nil;
    NSError *error;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:&error];
    
    if(!error) {
         NSLog(@"%@",result);
    }
    else {
        NSLog(@"%@",error);
    }
    
   
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
    if ([response statusCode] >= 200 && [response statusCode] < 300)
    {
        NSString *responseData = [[NSString alloc]initWithData:result encoding:NSUTF8StringEncoding];
        NSLog(@"Response ==> %@", responseData);
        
        NSError *error = nil;
        NSDictionary *jsonData = [NSJSONSerialization
                                  JSONObjectWithData:result
                                  options:NSJSONReadingMutableContainers
                                  error:&error];

        
        dataArray = [[NSMutableArray alloc] init];
        dataArray2 = [[NSMutableArray alloc] init];
        //childArray = [[NSMutableArray alloc] init];
        //filteredChildArray = [[NSArray alloc] init];
        //dataArray = result;
        indentationlevel = 0;
        indendationWidth = 20;
        // Create a sample array of parent objects
        //
        //    NSString *resultstring = [[NSString alloc]initWithData:result encoding:NSUTF8StringEncoding];
        //    //NSLog(resultstring);
        
       id objects = [NSJSONSerialization JSONObjectWithData:result options:kNilOptions error:nil];
        
        profile.firstName = [objects objectForKey:@"firstname"];
        profile.lastName = [objects objectForKey:@"lastname"];
        profile.gender = [objects objectForKey:@"gender"];
        profile.userId = [[objects objectForKey:@"userid"] integerValue];
        profile.currentlyWorking = [objects objectForKey:@"currentlyWorking"];
        profile.doctorId = [[objects objectForKey:@"doctorId"]integerValue ];
        profile.enthnonym = [objects objectForKey:@"enthnonym"];
        profile.enthnicity = [objects objectForKey:@"enthnicity"];
        profile.feet = [[objects objectForKey:@"feet"]integerValue];
        profile.inches = [[objects objectForKey:@"inches"]integerValue];
        profile.language = [objects objectForKey:@"language"];
        profile.lastGradeSchool = [objects objectForKey:@"lastGradeSchool"];
        profile.weight = [[objects objectForKey:@"weight"]integerValue ];
        profile.startDate = [objects objectForKey:@"date"];
        
        NSLog(@"Patient User ID: %ld",(long)profile.userId);
        
        Profile *p = [Profile new];
        p.question = @"Firstname";
        p.answer =[objects objectForKey:@"firstname"];
        
        Profile *p1 = [Profile new];
        p1.question = @"Lastname";
        p1.answer =[objects objectForKey:@"lastname"];
       
        Profile *p2 = [Profile new];
        p2.question = @"Gender";
        p2.answer =[objects objectForKey:@"gender"];
        
        Profile *p3 = [Profile new];
        p3.question = @"Language";
        p3.answer =[objects objectForKey:@"language"];
        
        Profile *p4 = [Profile new];
        p4.question = @"Treatment Start Date";
        p4.answer =[objects objectForKey:@"date"];
        
        Profile *p5 = [Profile new];
        p5.question = @"Hispanic/Latin";
        p5.answer =[objects objectForKey:@"enthnonym"];
        
        Profile *p6 = [Profile new];
        p6.question = @"Enthnicity";
        p6.answer =[objects objectForKey:@"enthnicity"];
        
        Profile *p7 = [Profile new];
        p7.question = @"Currently Working";
        p7.answer =[objects objectForKey:@"currentlyWorking"];
        
//        Profile *p8 = [Profile new];
//        p8.question = @"Height";
//        NSString *hw = [NSString stringWithFormat:@"\n %@ feet %@ inches", [objects objectForKey:@"feet"],[objects objectForKey:@"inches"]];
//        p8.answer =hw;
        
        Profile *p9 = [Profile new];
        p9.question = @"Weight";
        p9.answer =[NSString stringWithFormat:@"%@",[objects objectForKey:@"weight"]];
        
        dataArray =[NSMutableArray arrayWithObjects:p,p1,p2,p3,p4,p5,p6,p7,p9 ,nil];
        
        if(profile.firstName != nil) {            
            self.editButton.enabled = NO;
        }
        
        UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
        self.tableView.backgroundView = imageview;
        
    } else {
        
        [self alertStatus:@"Connection Failed" :@"Try connecting after sometimes!" :0];
    }
}

- (void) alertStatus:(NSString *)msg :(NSString *)title :(int) tag
{
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:title
                                                        message:msg
                                                       delegate:self
                                              cancelButtonTitle:@"Ok"
                                              otherButtonTitles:nil, nil];
    alertView.tag = tag;
    [alertView show];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    // Return the number of rows in the section.
    return [dataArray count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    static NSString *CellIdentifier =@"Cell";
    UITableViewCell *cell = nil;
    cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if(cell == nil)
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:CellIdentifier];
    
    Profile *prod = [dataArray objectAtIndex:indexPath.row];
    cell.textLabel.text = prod.question;
    cell.textLabel.numberOfLines = 0;
    if(prod.answer != [NSNull null])
        cell.detailTextLabel.text = prod.answer;
    else
        cell.detailTextLabel.text = @"";
    
    cell.indentationWidth = indendationWidth;
    
    cell.textLabel.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.textLabel.textColor = [UIColor brownColor];
    cell.textLabel.font = [UIFont boldSystemFontOfSize:18.0f];
    
    cell.detailTextLabel.backgroundColor =[UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.detailTextLabel.textColor = [UIColor brownColor];
    cell.detailTextLabel.font =[UIFont boldSystemFontOfSize:16.0f];
    
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.backgroundView = imageview;
    
    //show disclosure only if cell can expand
    
    // Configure the cell...
    
    
    
    return cell;
}

-(UIView*) viewForDisclosureForState:(BOOL) isExpanded
{
    NSString *imageName;
    if(isExpanded)
    {
        imageName = @"ArrowD_blue.png";
    }
    else
    {
        imageName = @"ArrowR_blue.png";
    }
    UIView *myView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 40, 40)];
    UIImageView *imgView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:imageName]];
    [imgView setFrame:CGRectMake(0, 6, 24, 24)];
    [myView addSubview:imgView];
    return myView;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
//    Profile *prog = [dataArray2 objectAtIndex:indexPath.row];
//    UITableViewCell *selectedCell = [tableView cellForRowAtIndexPath:indexPath];
//    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
//    selectedCell.backgroundView = imageview;
//    
//    if(prog.canBeExpanded)
//    {
//        
//        if(prog.isExpanded)
//        {
//            
//            [self collapseCellsFromIndexOf:prog indexPath:indexPath tableView:tableView];
//            selectedCell.accessoryView = [self viewForDisclosureForState:NO];
//        }
//        else{
//            NSLog(@"Can be expanded");
//            [self expandCellsFromIndexOf:prog tableView:tableView indexPath:indexPath];
//            
//            selectedCell.accessoryView = [self viewForDisclosureForState:YES];
//            
//        }
//        
//    }else{
//        obj = prog;
//        [self performSegueWithIdentifier:@"medicineDetails" sender:self];
//    }
    
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
//- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
//    // Get the new view controller using [segue destinationViewController].
//    // Pass the selected object to the new view controller.
//    NSMutableArray *programData = [[NSMutableArray alloc]init];
//    
//    if([segue.identifier isEqualToString:@"medicineDetails"]){
//        
//        if(obj.type == OBJECT_TYPE_SUBPROGRAM){
//            
//            [dataArray enumerateObjectsUsingBlock:^(id object, NSUInteger idx, BOOL *stop) {
//                
//                [[object subcategoryModelList] enumerateObjectsUsingBlock:^(id obj1, NSUInteger idx, BOOL *stop) {
//                    
//                    if([obj.name isEqualToString:[obj1 subCategoryname]]){
//                        [[obj1 programDetailsList] enumerateObjectsUsingBlock:^(id objProg, NSUInteger idx, BOOL *stop) {
//                            [programData addObject:objProg];
//                        }];
//                        
//                    }
//                }];
//            }];
//            
//            // UINavigationController* navController = segue.destinationViewController;
//           // ProgramViewController *pvc = (ProgramViewController*)[segue destinationViewController];
//            //pvc.content = programData;
//           // pvc.ua = self.ua;
//        }
//    }
//}


- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    if([segue.identifier isEqualToString:@"editprofile"]){
        EditProfileViewController *svc= (EditProfileViewController*)[segue destinationViewController];
        svc.delegate = self;
        svc.profile=self.profile;
        svc.ua = self.ua;
        
    }
}



@end
