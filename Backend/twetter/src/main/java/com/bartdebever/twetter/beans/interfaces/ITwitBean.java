package com.bartdebever.twetter.beans.interfaces;

import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;

import java.util.List;

public interface ITwitBean {

    /**
     * Posts a Twit to the application.
     * @param twit the twit wanting to be posted.
     */
    void postTwit(Twit twit) throws IllegalArgumentException;

    /**
     * Removes a Twit from the application.
     * @param twit the twit wanting to be removed.
     */
    void removeTwit(Twit twit) throws IllegalArgumentException;

    /**
     * Gets a Twit from the application based on it's id.
     * @param id the id of the Twit wanting to be looked for.
     * @return the Twit object or null.
     */
    Twit getTwit(int id) throws IllegalArgumentException;

    /**
     * Gets all Twits in the application.
     * @return a collection of Twits.
     */
    List<Twit> getAllTwits();

    /**
     * Gets the Twits that are featured on the user's timeline.
     * @param user the user wanting the Twits for.
     * @return a collection of Twit objects.
     */
    List<Twit> getTimelineTwits(User user) throws IllegalArgumentException;

    /**
     * Gets the Twits made by a single user.
     * @param user the user wanting to be looked for.
     * @return a collection of Twit objects.
     */
    List<Twit> getTwitsByUser(User user) throws IllegalArgumentException;
}
