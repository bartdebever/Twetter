package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.models.Twit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * A controller used to execute actions around the Twit object.
 */
@RestController
@Api("The endpoint to handle Twits.")
public class TwitController {

    private ITwitBean twitBean;

    /**
     * Gets a Twit by it's id.
     * @param id the id of the twit.
     */
    @ApiOperation(value = "Gets a full Twit based on it's id.")
    @GetMapping("/twit/{id}")
    public Twit getTwit(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        return twitBean.getTwit(idInt);
    }

    /**
     * Adds a Twit for the currently logged in account.
     * @param content the twit wanting to be posted.
     */
    @ApiOperation(value = "Creates a Twit for the user.")
    @PostMapping("/twit/")
    public void postTwit(@RequestBody String content) {
        Twit twit = new Twit();
        twit.setPostedAt(new Date());
        twit.setContent(content);
        twitBean.postTwit(twit);
    }

    /**
     * Deletes a Twit if it belongs to the current user.
     * @param id the id of the twit.
     */
    @ApiOperation(value = "Remove the Twit if it belongs to the current user.")
    @DeleteMapping("/twit/{id}")
    public void removeTwit(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        Twit twit = twitBean.getTwit(idInt);
        twitBean.removeTwit(twit);
    }

    /**
     * Likes a Twit based on it's id.
     * @param id the id of the Twit.
     */
    @ApiOperation(value = "Likes a Twit for the current user.")
    @PostMapping("/twit/like/{id}")
    public void likeTwit(@PathVariable String id) {

    }
}
