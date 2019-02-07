package com.bartdebever.twetter.models;

import com.bartdebever.twetter.models.interfaces.IEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * A class that stores the data for a post (Twit).
 */
@Entity
@Table(name = "Twits")
public class Twit implements IEntity {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    private String content;
    private Date postedAt;
    @ManyToOne
    private User user;
    private int userId;
    @ManyToMany
    private List<User> likes;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the content of the Twit.
     * @return the content of the Twit.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the Twit.
     * @param content the content wanting to be set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the date the Twit was posted at.
     * @return the date the Twit was posted at.
     */
    public Date getPostedAt() {
        return postedAt;
    }

    /**
     * Sets the date the Twit was posted at.
     * @param postedAt the value wanting to be set.
     */
    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
}
