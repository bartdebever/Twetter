package com.bartdebever.twetter.resources;

public class ReplyResource {
    private String content;
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public String getContent() {
        return content;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
