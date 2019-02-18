package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.services.Local.LocalTwitService;
import org.junit.Before;
import org.junit.Test;

public class TwitBeanTests {
    private ITwitBean twitBean;

    @Before
    public void reset() {
        twitBean = new TwitBean(new LocalTwitService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNull() {
        twitBean.postTwit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWrongId() {
        twitBean.getTwit(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNull() {
        twitBean.removeTwit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void timelineNull() {
        twitBean.getTimelineTwits(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void userTwitsNull() {
        twitBean.getTwitsByUser(null);
    }
}
