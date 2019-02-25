package com.bartdebever.twetter.resources;

import java.io.Serializable;

public class TwitResource implements Serializable {
    private BasicUserResource user;
    private String content;
    private int id;

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public BasicUserResource getUser() {
        return user;
    }

    public void setUser(BasicUserResource user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }
}
