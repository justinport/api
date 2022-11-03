package com.sample.api.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sample.api.models.FoodItem;
import com.sample.api.models.FoodNutrient;
import com.sample.api.models.SearchResults;
import com.sample.api.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private String GetfoodListFromFoodDataCentral() {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {


            String apiUrl = "https://api.nal.usda.gov/fdc/v1/foods/list?api_key=DEMO_KEY";

            apiUrl = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=DEMO_KEY&query=Cheddar%20Cheese&pageSize=10";

            final HttpGet httpget = new HttpGet(apiUrl);


            // Create a custom response handler
            HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final ClassicHttpResponse response) throws IOException {
                    final int status = response.getCode();
                    if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
                        final HttpEntity entity = response.getEntity();
                        try {
                            return entity != null ? EntityUtils.toString(entity) : null;
                        } catch (final ParseException ex) {
                            throw new ClientProtocolException(ex);
                        }
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            return httpclient.execute(httpget, responseHandler);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Get User information by Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error",
                    content = @Content)})
    @GetMapping(produces = {"application/json"})
    public User getUserById(@PathVariable int id) {

        try {


            Gson gson = new GsonBuilder()
                    .create();

            Type listOfFoodItem = new TypeToken<SearchResults>() {
            }.getType();

          //  List<FoodItem> responseFromApi = gson.fromJson(new FileReader("/Users/justinport/Documents/GitHub/api/src/main/resources/food_list.json"), listOfFoodItem);

            String apiResponse = GetfoodListFromFoodDataCentral();

            SearchResults responseFromApi = gson.fromJson(apiResponse, listOfFoodItem);

           LinkedList<FoodItem> foodItemsFromSearch = responseFromApi.getFoods();

            User mockUser = new User();
            mockUser.setUserName("jport@ric.edu");
            mockUser.setFirstName("justin");
            mockUser.setLastName("port");
            return mockUser;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Operation(summary = "Get all users in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error",
                    content = @Content)})
    @GetMapping(produces = {"application/json"})
    public List<User> getUsers() {

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
