package egen.usermanagement.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.List;

import egen.usermanagement.pojo.User;
import egen.usermanagement.service.JsonTransformer;
import egen.usermanagement.service.UserService;
import egen.usermanagement.test.ResponseUtility;

public class UserController {		
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
		setupEndpoints();
	}

    private void setupEndpoints() {
    	
    	System.out.println("In controller");
    	
    	/* 
    	 * Writing the route method for post and requested url is "/createUser.htm",
    	 * and  passing HTTP request & response as argument and data 
    	 * and within method definition we are calling userService.createUser method
    	 * for creating  a user, which take json data as input. 
    	 * Response status is set to 201, user created successfully
    	 * else it will send User already exist.
    	*/
    	post("/createUser.htm", "application/json", (request, response) -> {
            if(userService.createUser(request.body())) {  
            	response.status(201);
            	return new ResponseUtility("User has been successfully created!!");
            }
            else {
            	return new ResponseUtility("User already exist!");
            }
        }, new JsonTransformer());            
    	
    	/* 
    	 * Writing the route method for get and requested url is "/listUsers.htm",
    	 * and  passing HTTP request & response as argument and data 
    	 * and within method definition we are calling userService.listUser method
    	 * for retrieving the list of all user. Later checking if the size of retrieved
    	 * list is zero, we are using Response Utility class to display the message
    	 * in json format. Else in console detail of user is printed
    	*/
        get("/listUsers.htm", "application/json", (request, response) -> {
        		List<User> users = userService.getAllUsers();
        		if(users.size() == 0)
        			return new ResponseUtility("There are no users in the database");
        		else
        			return response;
        		}
        , new JsonTransformer());
        
        /* 
    	 * Writing the route method for put and requested url is "/updateUser.htm",
    	 * and  passing HTTP request & response as argument and data 
    	 * and within method definition we are calling userService.updateUser method
    	 * for updating the user, which take json data as input. Later checking the 
    	 * response status if 200, displaying user updated suscess else user is not
    	 * found in the database using Response Utility 
    	*/
        put("/updateUser.htm", "application/json", (request, response) -> {                
                if(userService.updateUser(request.body()) == 200) {
                	response.status(200);
                	return new ResponseUtility("User is successfully updated!!") ;
                }
                else {
                	response.status(404);
                	return new ResponseUtility("No user with this description is found") ;
                }
        },new JsonTransformer());
        
        /* 
         * Creating customing error page when 404, page not found error occurred
         */
        get("/404", (request, response) -> {
        	       response.type("text/html");
        	       return "Error page 404";
        	   });
    }
}
