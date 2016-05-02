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

@interface AccordionViewControllerTableViewController ()

@end

@implementation AccordionViewControllerTableViewController
@synthesize jsonData,data,ua;

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
    
    SWRevealViewController *revealViewController = self.revealViewController;
    if(revealViewController){
        [self.sidebarButton setTarget:self.revealViewController];
        [self.sidebarButton setAction:@selector(revealToggle:)];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
        self.ua = revealViewController.ua;
    }
    
    self.title = @"Toolbox";
    
    NSDictionary *newData = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithLong:self.ua.userId],@"userid",self.ua.username,@"username",self.ua.password,nil];
    NSData * dataVal = [NSJSONSerialization dataWithJSONObject:newData options:kNilOptions error:nil];
    
    NSString *stringUrl = [NSString stringWithFormat:@"%@programs",Url];
    NSURL *url = [NSURL URLWithString:stringUrl];
    
    //NSURL *url = [NSURL URLWithString:@"http://localhost:8080/finalproject/programs"];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url];
    
    
    [request setHTTPMethod:@"POST"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request setValue:@"application/json" forHTTPHeaderField:@"Accept"];
    [request setValue:[NSString stringWithFormat:@"%ul",(unsigned)[dataVal length]] forHTTPHeaderField:@"Content-length"];
    [request setHTTPBody:dataVal];
    
    NSLog(@"JSON summary : %@",[[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding]);
    
    NSHTTPURLResponse *response = nil;
    
    NSData *result = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    // NSLog(result);
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
    if ([response statusCode] >= 200 && [response statusCode] < 300)
    {
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
        
        
        for(id object in objects){
            
            MainCategory *mc=[[MainCategory alloc]init];
            mc.categoryName =[object objectForKey:@"categoryname"];
            id subobjects =[object objectForKey:@"list"];
            for(id objSC in subobjects){
                SubCategory *sc=[[SubCategory alloc]init];
                sc.subCategoryname = [objSC objectForKey:@"subcategoryname"];
                id programObj = [objSC objectForKey:@"list"];
                for(id o in programObj){
                    ProgramDetails *pg = [[ProgramDetails alloc]init];
                    pg.programId = [[o objectForKey:@"programid"]integerValue];
                    pg.programName=[o objectForKey:@"programname"];
                    pg.programDetails=[o objectForKey:@"programdetail"];
                    pg.programUrl=[o objectForKey:@"programurl"];
                    pg.subCategory=[[o objectForKey:@"subcategory"]integerValue];
                    [sc.programDetailsList addObject:pg];
                }
                
                [mc.subcategoryModelList addObject:sc];
                
            }
            [dataArray addObject:mc];
            
        }
        
        // jsonData =@[@"Mind Body technique",@"Food as medicine",@"Self-Care tool box",@"Move my body",@"Medical tool box"];
        
        [dataArray enumerateObjectsUsingBlock:^(id object, NSUInteger idx, BOOL *stop) {
            
            // do something with object
            AccordionGenericobject *prod = [[AccordionGenericobject alloc] init];
            prod.name = [object categoryName];
            
            // prod.children = [object subcategoryModelList];
            prod.parent = @"";
            prod.isExpanded = NO;
            prod.level = 0;
            prod.type  = OBJECT_TYPE_PROGRAM;
            // Randomly assign canBeExpanded status
            prod.canBeExpanded  = YES;
            
            
            [dataArray2 addObject:prod];
            
        }];
        
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
    return [dataArray2 count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    static NSString *CellIdentifier =@"Cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier forIndexPath:indexPath];
    
    AccordionGenericobject *prod = [dataArray2 objectAtIndex:indexPath.row];
    cell.textLabel.text = prod.name;
    cell.textLabel.numberOfLines = 0;
    cell.detailTextLabel.text = prod.parent;
    cell.indentationLevel = prod.level;
    cell.indentationWidth = indendationWidth;
    
    cell.textLabel.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.textLabel.textColor = [UIColor brownColor];
    cell.textLabel.font = [UIFont boldSystemFontOfSize:18.0f];
    
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    cell.backgroundView = imageview;
    
    //show disclosure only if cell can expand
    if(prod.canBeExpanded){
        cell.accessoryView = [self viewForDisclosureForState:prod.isExpanded];
    }else{
        cell.accessoryView = nil;
    }
    
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

//utility class to create childrens for a selected parent class
-(void)fetchChildrenForParent:(AccordionGenericobject*)parentProg{
    
    if(parentProg.canBeExpanded){
        if([parentProg.children count]>0){
            return;
        }
        
        if(parentProg.type == OBJECT_TYPE_PROGRAM){
            
            [dataArray enumerateObjectsUsingBlock:^(id object, NSUInteger idx, BOOL *stop) {
                
                if([parentProg.name isEqualToString:[object categoryName]]){
                    [[object subcategoryModelList] enumerateObjectsUsingBlock:^(id objP, NSUInteger idx, BOOL *stop) {
                        AccordionGenericobject *prod = [[AccordionGenericobject alloc]init];
                        
                        prod.name = [objP subCategoryname];;
                        prod.level = parentProg.level +1;
                        prod.type = OBJECT_TYPE_SUBPROGRAM;
                        prod.isExpanded = NO;
                        // prod.canBeExpanded = YES;
                        
                        //     prog.canBeExpanded = NO;
                        
                        [parentProg.children addObject:prod];
                    }];
                }
            }];
        }
    }
}


// Method to collapse the cell if it is already expanded
- (void)collapseCellsFromIndexOf:(AccordionGenericobject *)prod indexPath:(NSIndexPath *)indexPath tableView:(UITableView *)tableView
{
    // Find the number of childrens opened under the parent recursively as there can be expanded children also
    int collapseCol = [self numberOfCellsToBeCollapsed:prod];
    
    // Find the range from the parent index and the length to be removed.
    NSRange collapseRange = NSMakeRange(indexPath.row+1, collapseCol);
    // Remove all the objects in that range from the main array so that number of rows are maintained properly
    [dataArray2 removeObjectsInRange:collapseRange];
    prod.isExpanded = NO;
    // Create index paths for the number of rows to be removed
    NSMutableArray *indexPaths = [[NSMutableArray alloc] init];
    for (int i = 0; i<collapseRange.length; i++) {
        [indexPaths addObject:[NSIndexPath indexPathForRow:collapseRange.location+i inSection:0]];
    }
    // Animate and delete
    [tableView deleteRowsAtIndexPaths:indexPaths
                     withRowAnimation:UITableViewRowAnimationLeft];
}

// Method to collapse the cell if it is already expanded
- (void)expandCellsFromIndexOf:(AccordionGenericobject *)prod tableView:(UITableView *)tableView indexPath:(NSIndexPath *)indexPath
{
    // NSMutableArray *watever = [[NSMutableArray alloc]init];
    
    // Create dummy children
    [self fetchChildrenForParent:prod];
    // Expand only if children are available
    if([prod.children count]>0)
    {
        prod.isExpanded = YES;
        int i =0;
        // Insert all the child to the main array just after the parent
        for (AccordionGenericobject *prod1 in prod.children) {
            // SubCategory *sc=[[SubCategory alloc]init];
            // sc.subCategoryname = [prod1 valueForKey:@"subcategoryname"];
            //sc.programDetailsList = [prod1 valueForKey:@"list"];
            [dataArray2 insertObject:prod1 atIndex:indexPath.row+i+1];
            i++;
        }
        // Find the range for insertion
        NSRange expandedRange = NSMakeRange(indexPath.row, i);
        NSMutableArray *indexPaths = [[NSMutableArray alloc] init];
        // Create index paths for the range
        for (int i = 0; i<expandedRange.length; i++) {
            [indexPaths addObject:[NSIndexPath indexPathForRow:expandedRange.location+i+1 inSection:0]];
        }
        // Insert the rows
        
        // if (expandedRange.length == indexPaths.count)
        //  [tableView deleteSections:[NSIndexSet indexSetWithIndex:0] withRowAnimation:UITableViewRowAnimationFade];
        
        [tableView insertRowsAtIndexPaths:indexPaths
                         withRowAnimation:UITableViewRowAnimationLeft];
    }
    
}

// Find the number of cells to be collapsed
-(int) numberOfCellsToBeCollapsed:(AccordionGenericobject*) products
{
    int total = 0;
    if(products.isExpanded)
    {
        // Set the expanded status to no
        products.isExpanded = NO;
        NSMutableArray *child = products.children;
        total =(int)[child count];
        // traverse through all the children of the parent and get the count.
        for(AccordionGenericobject *prod in child)
        {
            total += [self numberOfCellsToBeCollapsed:prod];
        }
    }
    return total;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    AccordionGenericobject *prog = [dataArray2 objectAtIndex:indexPath.row];
    UITableViewCell *selectedCell = [tableView cellForRowAtIndexPath:indexPath];
    UIImageView *imageview = [[UIImageView alloc]initWithImage:[UIImage imageNamed:@"bg18.jpg"]];
    selectedCell.backgroundView = imageview;
    
    if(prog.canBeExpanded)
    {
        
        if(prog.isExpanded)
        {
            
            [self collapseCellsFromIndexOf:prog indexPath:indexPath tableView:tableView];
            selectedCell.accessoryView = [self viewForDisclosureForState:NO];
        }
        else{
            NSLog(@"Can be expanded");
            [self expandCellsFromIndexOf:prog tableView:tableView indexPath:indexPath];
            
            selectedCell.accessoryView = [self viewForDisclosureForState:YES];
            
        }
        
    }else{
        obj = prog;
        if ([prog.name isEqualToString:@"Take a Prescription Medication"]) {
            NSLog(@"Select Medical Tool Box");
            [self performSegueWithIdentifier:@"medicationview" sender:self];
        }else{
            [self performSegueWithIdentifier:@"programview" sender:self];
        }
    }
    
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    NSMutableArray *programData = [[NSMutableArray alloc]init];
    if ([segue.identifier isEqualToString:@"medicationview"]) {
        MedicationViewController *mvc = (MedicationViewController *)[segue destinationViewController];
        mvc.ua = self.ua;
    }
    if([segue.identifier isEqualToString:@"programview"]){
        
        if(obj.type == OBJECT_TYPE_SUBPROGRAM){
            
            [dataArray enumerateObjectsUsingBlock:^(id object, NSUInteger idx, BOOL *stop) {
                
                [[object subcategoryModelList] enumerateObjectsUsingBlock:^(id obj1, NSUInteger idx, BOOL *stop) {
                    
                    if([obj.name isEqualToString:[obj1 subCategoryname]]){
                        [[obj1 programDetailsList] enumerateObjectsUsingBlock:^(id objProg, NSUInteger idx, BOOL *stop) {
                            [programData addObject:objProg];
                        }];
                        
                    }
                }];
            }];
            
            // UINavigationController* navController = segue.destinationViewController;
            ProgramViewController *pvc = (ProgramViewController*)[segue destinationViewController];
            pvc.content = programData;
            pvc.ua = self.ua; 
        }
    }
}


@end
