package com.appodia.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/api/resource")
public class ResourceController {

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @ApiOperation(value = "Return the application version.", response = String.class)
    public String getResourceById(@PathVariable int id){
        return "Test.";
    }

}
