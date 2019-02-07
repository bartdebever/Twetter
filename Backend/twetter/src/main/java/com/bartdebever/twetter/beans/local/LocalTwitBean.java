package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;

import java.util.ArrayList;
import java.util.List;

public class LocalTwitBean implements ITwitBean {

    private List<Twit> _twitList;

    @Override
    public void postTwit(Twit twit) {
        _twitList.add(twit);
    }

    @Override
    public void removeTwit(Twit twit) {
        _twitList.remove(firstOrDefault(twit.getId()));
    }

    @Override
    public Twit getTwit(int id) {
        return firstOrDefault(id);
    }

    @Override
    public List<Twit> getAllTwits() {
        return _twitList;
    }

    @Override
    public List<Twit> getTimelineTwits(User user) {
        return null;
    }

    @Override
    public List<Twit> getTwitsByUser(User user) {
        List<Twit> result = new ArrayList<>();
        for (Twit twit : _twitList) {
            // Twit.user == user;
        }

        return result;
    }

    private Twit firstOrDefault(int id) {
        for (Twit twit: _twitList) {
            if (twit.getId() == id) {
                return twit;
            }
        }

        return null;
    }
}
