package com.bartdebever.twetter.models;

import com.bartdebever.twetter.models.interfaces.IEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * A class that stores the data for a post (Twit).
 */
@Entity
@Table(name = "TWITS")
public class Twit implements IEntity {
    @Id
    @GeneratedValue()
    private int id;
    private String content;
    private Date postedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @Lazy
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

    /**
     * Gets the user's id.
     * @return the user's id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user's id.
     * @param userId the id wanting to be set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the author of the Twit.
     * @return the user object.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the author of the Twit.
     * @param user the user wanting to be set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets all users who have liked this Twit.
     * @return the users who have liked this Twit.
     */
    public List<User> getLikes() {
        return likes;
    }
}
