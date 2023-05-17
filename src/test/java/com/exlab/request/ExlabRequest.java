package com.exlab.request;

import com.exlab.common.DataForApi;
import com.exlab.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ExlabRequest {
    public static Response response;
    public static int userID;
    public static String token;

    public static Response registerNewUser(String name, String email, String password, String about, String terms) {
        response = given().accept(ContentType.JSON)
                .and()
                .body(DataForApi.registerUserBody(name, email, password, about, terms))
                .when()
                .post(ConfigurationReader.get("postRegisterUser"));

        userID = response.path("id");
        System.out.println("userID = " + userID);
        token=response.path("token");

        return response;
    }
}
