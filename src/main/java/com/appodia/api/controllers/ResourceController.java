package com.appodia.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    @GetMapping("/{id}")
    public String getResourceById(@PathVariable int id){
        return "Test.";
    }

}
