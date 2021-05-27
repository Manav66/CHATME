package com.example.chatme.Models;

public class User {
    private  String uid;
    private String name;
    private String phoneNumber;
    private String profileImage;
    private String email;
    private String gender;
    private String work;

    public User(String uid, String name, String phone, String no_image){

    }

    public User(String uid, String name, String phoneNumber, String email, String gender, String work, String profileImage) {
        this.uid = uid;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.work = work;
        this.profileImage = profileImage;

    }

    public User(){
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
