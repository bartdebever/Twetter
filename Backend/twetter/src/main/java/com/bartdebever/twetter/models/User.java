package com.bartdebever.twetter.models;

import com.bartdebever.twetter.models.interfaces.IEntity;

import java.util.List;

public class User implements IEntity {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String bio;
    private String website;
    private String imageUrl;
    private Role role;
    private List<User> following;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the value wanting to be set for the user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void addFollowing(User user){
        following.add(user);
    }
}
