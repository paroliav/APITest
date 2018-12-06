package com.commerce.fluent.tests;

import com.commerce.fluent.beans.User;
import com.commerce.fluent.constants.API;
import com.commerce.fluent.constants.Login;
import com.commerce.fluent.utils.RestHelper;
import io.restassured.response.Response;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class QueryAPI {

    JSONObject body;

    @BeforeEach
    public void setUp() {
        body = new JSONObject();
    }

    @Test
    public void testLoginFailureHTTPCodeWithoutUsername() {
        body.put("password", Login.password);
        Response response = RestHelper.post(API.LOGIN_ENDPOINT, body);
        assertEquals(400, response.statusCode());
    }

    @Test
    public void testLoginFailureMessageWithoutUsername() {
        body.put("password", Login.password);
        Response response = RestHelper.post(API.LOGIN_ENDPOINT, body);
        assertEquals("Missing email or username", response.getBody().jsonPath().getString("error"));
    }

    @Test
    public void testTokenValueAfterSuccessfulLogin() {
        body.put("email", Login.email);
        body.put("password", Login.password);
        Response response = RestHelper.post(API.LOGIN_ENDPOINT, body);
        assertEquals("QpwL5tke4Pnpja7X", response.getBody().jsonPath().getString("token"));
    }

    @Test
    public void testGetUserWithId() {
        Response response = RestHelper.get(API.GET_USER_ENDPOINT+getIdForTobias());
        Map<String, Object> user = response.getBody().jsonPath().getMap("data");
        assertEquals(9, user.get("id"));
        assertEquals("Tobias", user.get("first_name"));
    }

    private int getIdForTobias() {
        int id = 0;
        Response response = RestHelper.get(API.GET_USERS_ENDPOINT);
        List<User> users = response.getBody().jsonPath().getList("data", User.class);
        for(User user : users){
            if(user.getFirst_name().equals("Tobias")){
                id = user.getId();
                break;
            }
        }
        return id;
    }


    @AfterEach
    public void tearDown(){
        body = null;
    }


}
