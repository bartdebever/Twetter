package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModeratorController {
    @ApiOperation(value = "Creates a role based on the given body.")
    @PutMapping("/role/create")
    public void createRole(@RequestBody Role role) {

    }

    @ApiOperation(value = "Deletes a Twit from the system")
    @DeleteMapping("/mod/delete/{id}")
    public void deleteTwit(@PathVariable String id) {

    }

}
