package com.exlab.stepDefs;

import com.exlab.pages.LoginPage;
import com.exlab.pages.OverviewPage;
import com.exlab.request.ExlabRequest;
import com.exlab.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddExperienceStepDefs {
    @When("The user creates a POST request for add a new experience with {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_creates_a_POST_request_for_add_a_new_experience_with_and_and_and_and_and_and(
            String job, String company, String location, String fromdate, String todate, String current, String description) {
        ExlabRequest.postExperience(job, company, location, fromdate, todate, current, description);
    }

    @Then("The user is on the Dashboard page")
    public void the_user_is_on_the_Dashboard_page() {
        new LoginPage().setUp();
    }

    @Then("The user verifies that UI experience and API experience must be match job is {string}")
    public void the_user_verifies_that_UI_experience_and_API_experience_must_be_match_job_is(String expectedJob) {
//        from UI
        String actualJobFromUI = new OverviewPage().addedExperienceName(expectedJob);
//        from API
        String actualJobFromAPI=ExlabRequest.experienceJob;
//        compare
        Assert.assertEquals(actualJobFromAPI,actualJobFromUI);
        Driver.closeDriver();

    }

}
