package com.bartdebever.twetter.resources;

import java.util.List;

public class UserResource extends BasicUserResource {
    List<TwitResource> twits;

    public List<TwitResource> getTwits() {
        return twits;
    }

    public void setTwits(List<TwitResource> twits) {
        this.twits = twits;
    }
}
