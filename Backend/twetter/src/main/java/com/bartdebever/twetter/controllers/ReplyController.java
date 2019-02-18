package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.Reply;
import com.bartdebever.twetter.resources.ReplyResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("The endpoint to post replies and navigate to parents.")
public class ReplyController {

    /**
     * Replies to a Twit based on the given body.
     * @param reply the body containing the content and the Twit wanting to reply to.
     */
    @ApiOperation("Method used to reply to other Twits.")
    @PostMapping("/reply/")
    public void PostReply(@RequestBody ReplyResource reply) {

    }

    /**
     * Gets the replies that have been made to the Twit.
     * @param parentId the twit's id that the replies should be found for.
     * @return a collection of reply objects.
     */
    @ApiOperation("Gets the replies to a Twit")
    @GetMapping("/reply/{parentId}")
    public List<Reply> GetReplies(@PathVariable int parentId) {
        return null;
    }
}
