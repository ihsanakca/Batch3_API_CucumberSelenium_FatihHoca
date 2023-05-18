package com.exlab.request;

import com.exlab.common.DataForApi;
import com.exlab.utilities.ApiUtils;
import com.exlab.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ExlabRequest {
    public static Response response;
    public static int userID;
    public static String token;
    public static String name;
    public static String email;

    public static int  experienceID;
    public static String experienceJob;

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

    public static Response updateUserProfileWithPatch(String name,String password,String admin,String about,String terms,
                                                      String job,String company,String website,String location, String skills){
        response = given().accept(ContentType.JSON)
                .and()
                .body(DataForApi.updateUserWithPatchBody(name, password, admin, about, terms, job, company, website, location, skills))
                .and()
                .header("token", ConfigurationReader.get("newUserToken"))
                .when()
                .patch(ConfigurationReader.get("patchUserProfile"));

        response.prettyPrint();

        return response;
    }

    public static Response getUserOwnProfile(){
        response = given().accept(ContentType.JSON)
                .and()
                .header("token", ConfigurationReader.get("newUserToken"))
                .when()
                .get(ConfigurationReader.get("getUserOwnProfile"));

        response.prettyPrint();

        name=response.path("name[0]");
        email=response.path("[0].email");

        System.out.println("name = " + name);
        System.out.println("email = " + email);

        return response;
    }

    public static Response postExperience(String job,String company,String location,String fromdate,
                                          String todate,String current,String description){
        response = given().accept(ContentType.JSON)
                .body(DataForApi.addExperienceBody(job, company, location, fromdate, todate, current, description))
                .and()
//                .headers(ApiUtils.getTokenWithMap(email,ConfigurationReader.get("password")))
                .headers(ApiUtils.getTokenWithMap(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password")))
                .when()
                .post(ConfigurationReader.get("postExperience"));

        experienceID=response.path("id");
        experienceJob=response.path("job");
        return response;
    }
}
