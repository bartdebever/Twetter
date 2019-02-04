package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.Twit;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("The endpoint to handle Twits.")
public class TwitController {

    /**
     * Gets a Twit by it's id.
     * @param id the id of the twit.
     */
    @GetMapping("/twit/{id}")
    public void getTwit(@PathVariable String id) {

    }

    /**
     * Adds a Twit for the currently logged in account.
     * @param twit the twit wanting to be posted.
     */
    @PostMapping("/twit/")
    public void postTwit(@RequestBody Twit twit) {

    }

    /**
     * Deletes a Twit if it belongs to the current user.
     * @param id the id of the twit.
     */
    @DeleteMapping("/twit/{id}")
    public void removeTwit(@PathVariable String id) {

    }

    @PostMapping("/twit/like/{id}")
    public void likeTwit(@PathVariable String id) {

    }
}
