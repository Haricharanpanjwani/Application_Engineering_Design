package com.yusuf.spring.pojo;

public class Advert {

    private long id;
    private String title;
    private String message;
    private String postedBy;
    private User user;
    private String category_name;
    private long category;

    public Advert(String title, String message, User user,long category_id) {
        this.title = title;
        this.message = message;
        this.user = user;
        this.category = category_id;
    }

    Advert() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getPostedBy() {
        return this.postedBy;
    }

    public void setPostedBy(String pb) {
        this.postedBy = pb;
    }

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}
}