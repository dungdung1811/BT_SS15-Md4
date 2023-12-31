package com.ra.model.entity;

public class User {
    private Integer id;
    private String userName;
    private  String email;
    private  String password;
    private  boolean role;

    public boolean isRole() {
        return role;
    }

    public User() {

    }
    
    public User(Integer id, String userName, String email, String password, boolean role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public void setRole(boolean role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
