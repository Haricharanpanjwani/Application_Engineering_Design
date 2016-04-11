package egen.usermanagement.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.json.JSONException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import egen.usermanagement.api.UserManagement;
import spark.Spark;
import spark.utils.IOUtils;

public class UserManagementTest {
	
	private static Server server;				
	
	@BeforeClass
	// the main method will run at the start of the application testing
	public static void beforeClass() {
		UserManagement.main(null);
	}
	
	@AfterClass
	// spark will  be stopped at the end of test execution.
	public static void afterClass() {
		Spark.stop();	
	}
	
	/* checks the response returned for list of all the user.
	 * if response status is not 200 it shows fail message "Method is not successfully executed".
	 */
	@Test	
	public void aListUserTest() throws JSONException {
		
		TestResponse response = request("GET", "/listUsers.htm");
		assertEquals(200, response.status);
		
		if(response.status != 200)
			fail("Method is not successfully executed");
		else
			System.out.println("List of all users method success");
	}
	
	/* 
	 * checks the response returned for create a user.
	 * if response status is not 200 it shows fail message "Method is not successfully executed".
	 * Else print Create User method success
	 */
	@Test	
	public void aCreateUserTest() throws JSONException {
		
		TestResponse response = request("POST", "/createUser.htm");		
		
		String result = response.body;
        assertNotNull(response);
        assertNotNull(response.body);
        assertEquals(200, response.status);
		
		if(response.status != 201 && response.status != 200)
			fail("Method is not successfully executed");
		else
			System.out.println("Create User method success");	
	}
	
	/* 
	 * checks the response returned for update a user.
	 * if response status is not 200 it shows fail message "Method is not successfully executed".
	 * Else print Update User method success
	 */
	@Test	
	public void aUpdateUserTest() throws JSONException {
		
		TestResponse response = request("POST", "/createUser.htm");		
		
		String result = response.body;
        assertNotNull(response);
        assertNotNull(response.body);
        assertEquals(200, response.status);
		
		if(response.status != 200 && response.status != 404)
			fail("Method is not successfully executed");
		else
			System.out.println("Update User method success");	
	}
	
	// Calling TestResponse class constructor, to set up the 
	// http connection
	private TestResponse request(String method, String path) {
		try {						
			//url that will be called along with the path which is equal to /listUsers
			URL url = new URL("http://localhost:8080" + path);
			// establishing the connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);			
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}

	private static class TestResponse {

		public final String body;
		public final int status;

		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}
		
		public Map<String,String> json() {
			return new Gson().fromJson(body, HashMap.class);
		}
	}

}
