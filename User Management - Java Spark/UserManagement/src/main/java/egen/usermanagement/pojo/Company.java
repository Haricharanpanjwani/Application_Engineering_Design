package egen.usermanagement.pojo;

import java.io.Serializable;
import java.util.Map;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

public class Company implements Serializable {
	
	/* 
	 * Each document within collection  should have an ObjectID
	 * by declaring @Id annotation, we are making id as ObjectId
	 * of bson type for storing a document
	 */
	@Id
	private ObjectId id;
	
	private String name;
	
	private String website;

	public String getName() {
		return name;
	}

	public void setName(String companyName) {
		this.name = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String companyWebsite) {
		this.website = companyWebsite;
	}
	
	/*
	 * Override the toString() method, so that whenever
	 * Company object is called, it will company name
	 * and company website
	 */
	@Override
	public String toString() {
		return "Company [Name=" + name + ", Website=" + website + "]";
	}	
	
}
