package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.Twit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("The endpoint to handle Twits.")
public class TwitController {

    /**
     * Gets a Twit by it's id.
     * @param id the id of the twit.
     */
    @ApiOperation(value = "Gets a full Twit based on it's id.")
    @GetMapping("/twit/{id}")
    public void getTwit(@PathVariable String id) {

    }

    /**
     * Adds a Twit for the currently logged in account.
     * @param twit the twit wanting to be posted.
     */
    @ApiOperation(value = "Creates a Twit for the user.")
    @PostMapping("/twit/")
    public void postTwit(@RequestBody Twit twit) {

    }

    /**
     * Deletes a Twit if it belongs to the current user.
     * @param id the id of the twit.
     */
    @ApiOperation(value = "Remove the Twit if it belongs to the current user.")
    @DeleteMapping("/twit/{id}")
    public void removeTwit(@PathVariable String id) {

    }

    @ApiOperation(value = "Likes a Twit for the current user.")
    @PostMapping("/twit/like/{id}")
    public void likeTwit(@PathVariable String id) {

    }
}
