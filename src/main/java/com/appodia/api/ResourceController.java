package com.appodia.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api/resource")
public class ResourceController {

    @GetMapping("/{id}")
    public String getResourceById(@PathVariable int id){
        return "Test.";
    }

}
