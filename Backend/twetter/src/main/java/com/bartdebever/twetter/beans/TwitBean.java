package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.ITwitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TwitBean implements ITwitBean {

    @Autowired
    private ITwitService twitService;

    @Override
    public void postTwit(Twit twit) throws IllegalArgumentException {
        twitService.insert(twit);
    }

    @Override
    public void removeTwit(Twit twit) throws IllegalArgumentException {
        twitService.delete(twit);
    }

    @Override
    public Twit getTwit(int id) throws IllegalArgumentException {
        return twitService.getById(id);
    }

    @Override
    public List<Twit> getAllTwits() {
        return twitService.getAll();
    }

    @Override
    public List<Twit> getTimelineTwits(User user) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Twit> getTwitsByUser(User user) throws IllegalArgumentException {
        return null;
    }
}
