package egen.usermanagement.pojo;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Address implements Serializable {
	
	private String street;
	
	private String city;
	
	private String zip;
	
	private String state;
	
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
		
	/*
	 * Override the toString() method, so that whenever
	 * Address object is called, it will print city
	 * and zip code.
	 */
	@Override
	public String toString() {
		return "Address [City=" + city + ", Zip code=" + zip + "]";
	}	
}
