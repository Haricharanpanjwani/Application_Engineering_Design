package com.yusuf.spring.pojo;

public class User {

    private long id;
    private String name;
    private String password;
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

    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
}