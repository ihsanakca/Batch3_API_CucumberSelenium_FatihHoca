package com.exlab.request;

import com.exlab.common.DataForApi;
import com.exlab.utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExlabRequest {
    static Response response;
    static int userID;

    private static Response registerNewUser(String name, String email, String password, String about, String terms) {
        response = given().accept(ContentType.JSON)
                .and()
                .body(DataForApi.registerUserBody(name, email, password, about, terms))
                .when()
                .post(ConfigurationReader.get("postRegisterUser"));

         userID = response.path("id");
        System.out.println("userID = " + userID);

        return response;
    }
}