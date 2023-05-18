package com.exlab.stepDefs;

import com.exlab.request.ExlabRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class UpdateProfileStepDefs {
    @When("The user creates a PATCH request and send the token {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_creates_a_PATCH_request_and_send_the_token_and_and_and_and_and_and_and_and_and(String name, String password, String admin, String about, String terms,
                                                                                                        String job, String company, String website, String location, String skills) {
        ExlabRequest.updateUserProfileWithPatch(name, password, admin, about, terms, job, company, website, location, skills);
    }

    @Then("The user creates a GET request to get user own profile with token")
    public void the_user_creates_a_GET_request_to_get_user_own_profile_with_token() {
        ExlabRequest.getUserOwnProfile();
    }

    @Then("The user verfiys that name as {string} and email as {string}")
    public void the_user_verfiys_that_name_as_and_email_as(String expectedName, String expectedEmail) {
        assertEquals(expectedName, ExlabRequest.getUserOwnProfile().path("[0].name"));
        assertEquals(expectedEmail, ExlabRequest.email);
    }
}
