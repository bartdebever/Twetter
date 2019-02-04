package com.bartdebever.twetter.models;

import com.bartdebever.twetter.models.interfaces.IEntity;

import java.util.Date;

public class Twit implements IEntity {
    private int id;
    private String content;
    private Date postedAt;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
}
