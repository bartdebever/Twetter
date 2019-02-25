package com.bartdebever.twetter.resources;

import java.util.List;

public class UserResource extends BasicUserResource {
    List<TwitResource> twits;
    List<BasicUserResource> following;

    public List<TwitResource> getTwits() {
        return twits;
    }

    public void setTwits(List<TwitResource> twits) {
        this.twits = twits;
    }

    public List<BasicUserResource> getFollowing() {
        return following;
    }

    public void setFollowing(List<BasicUserResource> following) {
        this.following = following;
    }
}
