package egen.usermanagement.service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.google.gson.Gson;
import com.mongodb.MongoClient;

import egen.usermanagement.pojo.Address;
import egen.usermanagement.pojo.Company;
import egen.usermanagement.pojo.User;

public class UserService	{	
	
	private MongoClient mongo;	
	private Morphia morphia;
	private Datastore datastore;
	
	public UserService() { 		
		/*
		 * Getting datastore to perform various CRUD operations,
		 * by calling getDatastore method.
		 */
		datastore = getDataStore();
	}
	
	public Datastore getDataStore() {	
		
		System.out.println("getting connection");
		
		try {
			// connection to mongodb
			mongo = new MongoClient( "localhost" , 27017 );
			// getting the morphia object
			morphia = new Morphia();
			// creating the datastore for performing CRUD operation
			datastore = morphia.createDatastore(mongo, "UserManagementDB");
			// this ensures the indexes are managed or persist
			datastore.ensureIndexes();
			
			morphia.mapPackage("egen.usermanagement.pojo");
			
			System.out.println("Database Connection establisthed!!");
						
		}
		catch (UnknownHostException e) {
			System.out.println("Exception occurred, could not get the DB connection");
		}
		// returning the created datastore
		return datastore;
	}
	
	// returns a list of all users
	public List<User> getAllUsers() {										
		
		/*
		 * Initialzing the User object list to store
		 * the user retreived from the database
		 */
		List<User> users = new ArrayList<User>();
		
		/*
		 * Retrieve the collection of user using find() method
		 * with the help of datastore using User.class to specify the document
		 * type. Later using asList, converting the retreived collection to 
		 * list type 
		 */
		users = datastore.find(User.class).asList();				        
		
		// Printing the size of list
		System.out.println("User from the list: " + users.size());
		
		// Printing the detail of each user using the foreach loop
		for(User u : users) {
			System.out.println(u + "\nCompany: "+ u.getCompany() + "\nAddress: " + u.getAddress());
		}
		
		// returning the list of users
		return users;
	}
	 
	  // creates a new user
	  public Boolean createUser(String jsonInput) { 		  
		  
		  boolean success = false;
		  
		  try{			  			  			  
			  
			  System.out.println("Creating the user \n" + jsonInput);			  			  
			  
			  // Converting the json input to User document
			  User user = new Gson().fromJson(jsonInput, User.class);			  
			  
			  /*
			   *  Using the get() method of morrphia api to get the user with the
			   *  user.getId(), creating from input json data. We can use other parameter 
			   *  and condition using .field() method with get to get the user with different 
			   *  description. Since, id is unique I have used that to retrieve the user
			   */			  
			  User findUser = datastore.get(User.class, user.getId());
			  
			  /*
			   * If the findUser object is null, then user is 
			   * not available in the database.
			   */
			  if(findUser == null) {
				  
				  /* 
				   * Using morphia object to map User class, i.e., convert
				   * the object to hashmap, to store. Further map company and address
				   * document for the same user and store it as Embedded document 
				   */
				  morphia.map(User.class).map(Company.class).map(Address.class);
				  
				  // save the user to MongoDB, along with Company and address POJO
				  datastore.save(user);
				  
				  System.out.println("User successfully inserted into the database");
				  
				  success = true;
			  }
			  // If the user is already present in the database.
			  else {
				  System.out.println("User already exists");
				  success = false;
			  }				    			  		  			  			  	  
		  }
		  catch(Exception e) {
			  System.out.println("Exception occurred!!");
			  e.printStackTrace();
		  }
		  
		return success;	  
	  }	  	  
	 
	  // updates an existing user
	  public int updateUser(String jsonInput) {
		  
		  int status = 404;
		  
		  // Converting the json input to User document
		  User user = new Gson().fromJson(jsonInput, User.class);			  
		  
		  /*
		   *  Using the get() method of morrphia api to get the user with the
		   *  user.getId(), creating from input json data. We can use other parameter 
		   *  and condition using .field() method with get to get the user with different 
		   *  description. Since, id is unique I have used that to retrieve the user
		   */
		  User findUser = datastore.get(User.class, user.getId());
		  
		  /*
		   * If the findUser object is null, then user is 
		   * not available in the database.
		   */
		  if(findUser != null) {
			  
			// The Mapper class also provides a public static of the default _id field name for us...
			  //Query<User> updateQuery = datastore.createQuery(User.class).field(Mapper.ID_KEY).equal(user.getId());
			  
			  // Creating the new Company object withe given data as input
			  Company company = findUser.getCompany();
			  company.setName(user.getCompany().getName());
			  company.setWebsite(user.getCompany().getWebsite());
			  
			  // Creating the new Address object withe given data as input
			  Address address = findUser.getAddress();
			  address.setStreet(user.getAddress().getStreet());
			  address.setCity(user.getAddress().getCity());
			  address.setState(user.getAddress().getState());
			  address.setCountry(user.getAddress().getCountry());
			  address.setZip(user.getAddress().getZip());
			  
			  /*
			   *  Preparing the findUser object with given data as input
			   *  and updated company, address. so that can be save in the database
			   */			  
			  findUser.setFirstName(user.getFirstName());
			  findUser.setLastName(user.getLastName());
			  findUser.setEmail(user.getEmail());
			  findUser.setDateCreated(user.getDateCreated());			  
			  findUser.setProfilePic(user.getProfilePic());
			  findUser.setCompany(company);
			  findUser.setAddress(address);
			  
			  /* 
			   * saving the findUser with the updated data
			   * We can use QueryMapper to retreive the documents
			   * and use UpdateOperations to perform functions like, add, increment
			   * on that object. But over here we just need to update the new field of
			   * specific object
			   */
			  datastore.save(findUser);
			  
			  // return the status at 200
		      status = 200;
			  			  
			  System.out.println("User successfully updated into the database");				  
		  }
		  // When the user is not in the database, returning 404, user not found
		  else {
			  System.out.println("User not found in the database!!");
			  status = 404;
		  }	
		  
		  return status;
	  }
}
