package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.Role;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModeratorController {
    @PutMapping("/role/create")
    public void createRole(@RequestBody Role role) {

    }

    @DeleteMapping("/mod/delete/{id}")
    public void deleteTwit(@PathVariable String id) {

    }

}
