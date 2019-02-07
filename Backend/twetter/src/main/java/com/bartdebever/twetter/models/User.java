package com.bartdebever.twetter.models;

import com.bartdebever.twetter.models.interfaces.IEntity;
import com.bartdebever.twetter.resources.NewUser;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements IEntity {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    private String userName;
    private String email;
    private String password;
    private String bio;
    private String website;
    private String imageUrl;
    @ManyToOne
    private Role role;
    @ManyToMany
    private List<User> following;
    @OneToMany
    private List<Twit> twits;

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

    public List<Twit> getTwits() {
        return twits;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public void addFollowing(User user){
        if (following == null) {
            following = new ArrayList<>();
        }
        following.add(user);
    }

    public static User CreateUserFromNew(NewUser newUser){
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());

        return user;
    }
}
