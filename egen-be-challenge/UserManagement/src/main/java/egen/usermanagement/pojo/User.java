package egen.usermanagement.pojo;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/*
 * Declaring the User pojo or collection, which will be stored in 
 * MongoDB, @Entity is used as a part of Morpho API, to declare 
 * User as entity. Implemented Serizable, so that document can be 
 * serialized while storing
 */
@Entity
public class User implements Serializable {
	
	/* 
	 * Each document within collection  should have an ObjectID
	 * by declaring @Id annotation, we are making id as ObjectId
	 * for storing a document
	 */
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	/*
	 * Embedded annotation is used for defining that Address is 
	 * another Collection, but it is stored as Embedded document 
	 * with User. Although we can save same as Reference Document
	 * i.e., create a separate collection for same. For that we can
	 * use Reference Annotation. Selection Reference and Embedded
	 * Document depends on the requirement
	 */
	@Embedded
	private Address address;
	
	private String dateCreated;
	
	@Embedded
	private Company company;
	
	private String profilePic;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	/*
	 * Override the toString() method, so that whenever
	 * User object is called, it will first and last name
	 */
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}		
		
}
