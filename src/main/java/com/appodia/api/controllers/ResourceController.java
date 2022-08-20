package com.appodia.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getResourceById(@PathVariable int id){
        return "Test.";
    }

}
