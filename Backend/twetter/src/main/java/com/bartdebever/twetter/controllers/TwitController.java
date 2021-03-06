package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.helpers.SpringTokenHelper;
import com.bartdebever.twetter.helpers.Twetter;
import com.bartdebever.twetter.helpers.interfaces.IUserAuthHelper;
import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.TwitResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * A controller used to execute actions around the Twit object.
 */
@RestController
@Api("The endpoint to handle Twits.")
public class TwitController {

    @Autowired
    private ITwitBean twitBean;

    @Autowired
    private IUserAuthHelper authHelper;

    /**
     * Gets a list of Twit object to display on the user's timeline.
     * @param page the page that should be loaded 1 based index.
     * @return a collection of Twit objects.
     */
    @ApiOperation("Get's the user's timeline twits.")
    @GetMapping("/twit/timeline/{page}")
    public ResponseEntity<List<Twit>> getTwits(@PathVariable String page) {

        return ResponseEntity.ok(null);
    }

    /**
     * Gets a Twit by it's id.
     * @param id the id of the twit.
     */
    @ApiOperation(value = "Gets a full Twit based on it's id.")
    @GetMapping("/twit/{id}")
    public TwitResource getTwit(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        Twit twit = twitBean.getTwit(idInt);

        ModelMapper mapper = Twetter.getMapper();
        return mapper.map(twit, TwitResource.class);
    }

    /**
     * Adds a Twit for the currently logged in account.
     * @param content the twit wanting to be posted.
     */
    @ApiOperation(value = "Creates a Twit for the user.")
    @PostMapping("/twit/")
    public void postTwit(@RequestBody String content, @RequestHeader HttpHeaders headers) {
        String token = SpringTokenHelper.getTokenFromHeader(headers);
        User user = authHelper.getUserByToken(token);
        Twit twit = new Twit();
        twit.setPostedAt(new Date());
        twit.setContent(content);
        twit.setUser(user);
        twitBean.postTwit(twit);
    }

    /**
     * Deletes a Twit if it belongs to the current user.
     * @param id the id of the twit.
     */
    @ApiOperation(value = "Remove the Twit if it belongs to the current user.")
    @DeleteMapping("/twit/{id}")
    public void removeTwit(@PathVariable String id, @RequestHeader HttpHeaders headers) {
        String token = SpringTokenHelper.getTokenFromHeader(headers);
        User user = authHelper.getUserByToken(token);

        int idInt = Integer.parseInt(id);
        Twit twit = twitBean.getTwit(idInt);
        if (twit.getUserId() == user.getId()) {
            twitBean.removeTwit(twit);
        }
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
