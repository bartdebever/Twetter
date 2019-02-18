package com.bartdebever.twetter.resources;

public class ReplyResource {
    private String content;
    private int parentId;

    /**
     * Gets the parent Twit's id.
     * @return the parent Twit's id.
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * Gets the content of the reply.
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the parent Twit's id.
     * @param parentId the value intending to be set.
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * Sets the content of the reply.
     * @param content the content wanting to be set.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
