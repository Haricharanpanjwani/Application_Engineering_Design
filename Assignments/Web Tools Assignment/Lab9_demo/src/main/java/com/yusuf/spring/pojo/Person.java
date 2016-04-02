package com.yusuf.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "personID", unique=true, nullable = false)
	private long personID;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	public Person(){
		
	}

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
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

}
