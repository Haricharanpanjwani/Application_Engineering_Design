package egen.usermanagement.test;

/*
 * Response Utility is a helper class which is use
 * for transforming message to JSON.
 */
public class ResponseUtility {

	private String message;
	 
	public ResponseUtility(String message) {
	    this.message = String.format(message);
	}
	 
	public ResponseUtility(Exception e) {
	    this.message = e.getMessage();
	}
	   
	public String getMessage() {
	    return this.message;
	}
	
}
