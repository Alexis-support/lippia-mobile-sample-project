package com.crowdar.examples.steps;

import com.crowdar.core.PropertyManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;

public class LoginSteps {

    @Given("The app is loaded correctly")
    @Then("Login page is displayed")
    public void isLoginPageVisible() {
        LoginService.isViewLoaded();
    }

    @When("^The user enter his email (.*)$")
    public void theUserEnterHisEmail(String email) {
        LoginService.setEmail(email);
    }

    @And("^The user enter password (.*)$")
    public void theUserEnterPassword(String password) {
        LoginService.setPassword(password);
    }

    @And("user login")
    public void userLogin() {
        LoginService.clickLoginButton();
    }

}

