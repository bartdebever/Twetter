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

    @ApiOperation("Method used to reply to other Twits.")
    @PostMapping("/reply/")
    public void PostReply(@RequestBody ReplyResource reply) {

    }

    @ApiOperation("Get's the replies to a Twit")
    @GetMapping("/reply/{parentId}")
    public List<Reply> GetReplies(@PathVariable int parentId) {
        return null;
    }
}
