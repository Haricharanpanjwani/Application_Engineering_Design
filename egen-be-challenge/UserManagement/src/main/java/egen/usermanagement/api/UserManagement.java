package egen.usermanagement.api;


import static spark.SparkBase.setIpAddress;
import static spark.SparkBase.setPort;
import static spark.SparkBase.staticFileLocation;

import egen.usermanagement.controller.UserController;
import egen.usermanagement.service.UserService;

public class UserManagement {
	
	private static final String IP_ADDRESS = "localhost";	
    private static final int PORT = 8080;

	public static void main(String[] args) {
		
		// Setting the IP_Address as "localhost"
		setIpAddress(IP_ADDRESS);
		// Setting the port 8080
        setPort(PORT);
        // Setting the file location of html and other jsp file as /public
		staticFileLocation("/public");
		
		// this is the entry point for the application
		// calling the controller with UserService as argument
		// Controller will redirect the application to required url and
		// retrieve the response and use UserService for performing CRUD operations within DB
		new UserController(new UserService());
		
	}
}
