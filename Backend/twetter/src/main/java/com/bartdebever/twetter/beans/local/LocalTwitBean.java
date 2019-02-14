package com.bartdebever.twetter.beans.local;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;

import java.util.ArrayList;
import java.util.List;

public class LocalTwitBean extends LocalBean implements ITwitBean {

    private List<Twit> twitList;

    public LocalTwitBean() {
        twitList = new ArrayList<>();
    }

    @Override
    public void postTwit(Twit twit) throws IllegalArgumentException {
        checkForNull(twit, "Twit can not be null");
        twitList.add(twit);
    }

    @Override
    public void removeTwit(Twit twit) throws IllegalArgumentException {
        checkForNull(twit, "Twit can not be null");
        Twit oldTwit = CSharp.firstOrDefault(twitList, twit.getId());
        twitList.remove(oldTwit);
    }

    @Override
    public Twit getTwit(int id) throws IllegalArgumentException {
        checkId(id);
        return CSharp.firstOrDefault(twitList, id);
    }

    @Override
    public List<Twit> getAllTwits() {
        return twitList;
    }

    @Override
    public List<Twit> getTimelineTwits(User user) {
        checkForNull(user, "User can not be null");
        return null;
    }

    @Override
    public List<Twit> getTwitsByUser(User user) throws IllegalArgumentException {
        checkForNull(user, "User can not be null");
        List<Twit> result = new ArrayList<>();
        for (Twit twit : twitList) {
            if (twit.getUser() == user) {
                result.add(twit);
            }
        }

        return result;
    }
}
