package com.yusuf.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person{
	
	@Column(name="name")
    private String name;
	
	@Column(name="password")
    private String password;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
    private Email email;
	

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    protected long getId() {
//        return id;
//    }
//
//    protected void setId(long id) {
//        this.id = id;
//    }

	public Email getEmail() {
		return email;
		
	}

	public void setEmail(Email email) {
		this.email = email;
	}
//	
//	public Person getPerson() {
//		return person;
//	}
//
//	public void setPerson(Person person) {
//		this.person = person;
//	}
}