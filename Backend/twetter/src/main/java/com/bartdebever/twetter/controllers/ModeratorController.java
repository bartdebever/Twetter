package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * A controller used to execute moderator actions.
 */
@RestController
public class ModeratorController {

    /**
     * Creates a new role.
     * @param role the new role wanting to be created.
     */
    @ApiOperation(value = "Creates a role based on the given body.")
    @PutMapping("/role/create")
    public void createRole(@RequestBody Role role) {

    }

    /**
     * Deletes a Twit from the system.
     * @param id the id of the Twit.
     */
    @ApiOperation(value = "Deletes a Twit from the system")
    @DeleteMapping("/mod/delete/{id}")
    public void deleteTwit(@PathVariable String id) {

    }

}
