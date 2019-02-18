package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.ITwitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TwitBean extends TwetterBean implements ITwitBean {

    private final ITwitService twitService;

    @Autowired
    public TwitBean(ITwitService twitService) {
        this.twitService = twitService;
    }

    @Override
    public void postTwit(Twit twit) throws IllegalArgumentException {
        checkForNull(twit);
        twitService.insert(twit);
    }

    @Override
    public void removeTwit(Twit twit) throws IllegalArgumentException {
        checkForNull(twit);
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
        checkForNull(user);
        return null;
    }

    @Override
    public List<Twit> getTwitsByUser(User user) throws IllegalArgumentException {
        checkForNull(user);
        return null;
    }
}
