package com.bartdebever.twetter.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A Twit that is a reply to another Twit.
 * This effect can stack multiple times.
 */
@Entity
@Table(name = "Replies")
public class Reply extends Twit {
    private Integer parentId;

    /**
     * Gets the parent Twit's Id.
     * @return the parent's id.
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * Sets the parent Twit's id.
     * @param parentId the id of the parent's Twit.
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
