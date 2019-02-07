package com.bartdebever.twetter.beans.local;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;

import java.util.ArrayList;
import java.util.List;

public class LocalTwitBean implements ITwitBean {

    private List<Twit> twitList;

    public LocalTwitBean() {
        twitList = new ArrayList<>();
    }

    @Override
    public void postTwit(Twit twit) {
        twitList.add(twit);
    }

    @Override
    public void removeTwit(Twit twit) {
        Twit oldTwit = CSharp.firstOrDefault(twitList, twit.getId());
        twitList.remove(oldTwit);
    }

    @Override
    public Twit getTwit(int id) {
        return CSharp.firstOrDefault(twitList, id);
    }

    @Override
    public List<Twit> getAllTwits() {
        return twitList;
    }

    @Override
    public List<Twit> getTimelineTwits(User user) {
        return null;
    }

    @Override
    public List<Twit> getTwitsByUser(User user) {
        List<Twit> result = new ArrayList<>();
        for (Twit twit : twitList) {
            if (twit.getUser() == user) {
                result.add(twit);
            }
        }

        return result;
    }
}
