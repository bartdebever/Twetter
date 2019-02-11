package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.models.Role;
import com.bartdebever.twetter.models.Twit;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A controller used to execute moderator actions.
 */
@RestController
public class ModeratorController {

    @Autowired
    private IRoleBean roleBean;

    @Autowired
    private ITwitBean twitBean;

    /**
     * Creates a new role.
     * @param role the new role wanting to be created.
     */
    @ApiOperation(value = "Creates a role based on the given body.")
    @PutMapping("/role/create")
    public void createRole(@RequestBody Role role) {
        roleBean.AddRole(role);
    }

    /**
     * Deletes a Twit from the system.
     * @param id the id of the Twit.
     */
    @ApiOperation(value = "Deletes a Twit from the system")
    @DeleteMapping("/mod/delete/{id}")
    public void deleteTwit(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        Twit twit = twitBean.getTwit(idInt);
        twitBean.removeTwit(twit);
    }

}
