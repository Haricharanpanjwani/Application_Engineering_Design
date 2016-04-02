/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dev
 */
public class User {
    private int id;
    private String first;
    private String last;
    private String gender;
    private String email;
    private String aboutMe;
    private String photoName; // Map with hibernate
    private MultipartFile photo; // Use by Data Binder

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" + "first=" + first + ", last=" + last + ", gender=" + gender + ", email=" + email + ", aboutMe=" + aboutMe + '}';
    }
    
    
    
}
