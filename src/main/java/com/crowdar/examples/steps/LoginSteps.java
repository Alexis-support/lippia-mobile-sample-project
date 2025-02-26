package com.crowdar.examples.steps;

import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;

public class LoginSteps {

    @Given("The app is loaded correctly")
    @Then("se ve la página de inicio de sesión")
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

