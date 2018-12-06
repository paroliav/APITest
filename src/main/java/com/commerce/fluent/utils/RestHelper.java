package com.commerce.fluent.utils;

import com.commerce.fluent.constants.API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class RestHelper {

	public static Response get(String endpoint){
        System.out.println("Request sent: \n" + endpoint);
        Response response = apiConfig().
                when().
                	get(endpoint);
		System.out.println("Response received: \n" + response.asString());
		return response;
	}
	
	public static Response post(String endpoint, JSONObject body){
		System.out.println("With body: "+body.toString(4));
		Response response = apiConfig()
							.body(body.toString())
							.post(endpoint);
		System.out.println("Response received: \n" + response.asString());
		return response;
	}
	
    private static RequestSpecification apiConfig() {
    	RestAssured.baseURI = API.BASE_URL;
        return RestAssured.given()
        		.header("Accept", "text/plain")
                .header("Content-Type", "application/json");
	}
	
}
