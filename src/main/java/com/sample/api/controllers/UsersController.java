package com.sample.api.controllers;

import com.sample.api.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:63342")
public class UsersController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Get User information by Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error",
                    content = @Content)})
    @GetMapping(produces = { "application/json" })
    public User getUserById(@PathVariable String id){
        if(!id.contains("@")){
            //return status code of 400 with message saying bad input
        }

        //write code to connect to the database


        //get response and return as json

        User mockUser = new User();
        mockUser.setUserName("jport@ric.edu");
        mockUser.setFirstName("justin");
        mockUser.setLastName("port");

        return mockUser;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Operation(summary = "Get all users in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error",
                    content = @Content)})
    @GetMapping(produces = { "application/json" })
    public List<User> getUsers(){

        List<User> users = new LinkedList<User>();

        User mockUser = new User();
        mockUser.setUserName("jport@ric.edu");
        mockUser.setFirstName("justin");
        mockUser.setLastName("port");

        users.add(mockUser);

        mockUser = new User();
        mockUser.setUserName("aport@ric.edu");
        mockUser.setFirstName("Ari");
        mockUser.setLastName("Port");

        users.add(mockUser);


        return users;
    }


}
