package com.yusuf.spring.pojo;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private long id;
    private String title;
    private Set<Advert> adverts = new HashSet<Advert>();

    public Category(String title) {
        this.title = title;
        this.adverts = new HashSet<Advert>();
    }

    Category() {
    }

    public Set<Advert> getAdverts() {
        return adverts;
    }

    void setAdverts(Set<Advert> adverts) {
        this.adverts = adverts;
    }

    public void addAdvert(Advert advert) {
        getAdverts().add(advert);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}