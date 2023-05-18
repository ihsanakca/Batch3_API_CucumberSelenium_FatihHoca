package com.exlab.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiUtils {
    public static Map<String, Object> getTokenWithMap(String email, String password) {
        Response response = given()
                .accept(ContentType.MULTIPART)
                .formParam("email", email)
                .formParam("password", password)
                .when().log().all()
                .post("/allusers/login");
        Map<String, Object> map = new HashMap<>();
        map.put("token", response.path("token"));

        return map;
    }
}