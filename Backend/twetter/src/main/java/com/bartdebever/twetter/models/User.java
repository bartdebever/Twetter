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

    /**
     * Gets the password hashed using BCrypt.
     * @return the hashed password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password the value wanting to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the username.
     * @return the username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     * @param userName the name wanting to be set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the featured website of the user.
     * @return an url or null.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Gets the user's featured website.
     * @param website the website wanting to be set.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets the user's bio.
     * @return the user's bio or null.
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets the user's bio.
     * @param bio the value intended to be set.
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Gets the user's profile picture.
     * @return the url of the user's profile picture.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the user's profile picture to an url.
     * @param imageUrl the url wanting to be set.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the role of the user.
     * @return the role that the user has.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the user's role.
     * @param role the role wanting to be set.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the user's who follow this user.
     * @return a collection of user objects.
     */
    public List<User> getFollowing() {
        return following;
    }

    /**
     * Gets the Twits the user has posted.
     * @return a collection of Twit objects.
     */
    public List<Twit> getTwits() {
        return twits;
    }

    /**
     * Adds a user to the list of following users
     * @param user the user intending to follow.
     */
    public void addFollowing(User user){
        if (following == null) {
            following = new ArrayList<>();
        }
        following.add(user);
    }

    /**
     * Creates a new user object from the NewUser object.
     * @param newUser the object wanting to be converted.
     * @return an user object.
     */
    public static User CreateUserFromNew(NewUser newUser){
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());

        return user;
    }
}
