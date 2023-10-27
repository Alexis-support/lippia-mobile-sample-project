package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.java.en.Then;


public class LoginSteps extends PageSteps {
    @Given("Estar en la pagina de login")
    public void isLoginPageVisible() {
        LoginService.isViewLoaded();
    }

    @When("el usuario se loguea con (.*) y (.*)")
    public void doLoginProcess(String email, String password) {
        LoginService.doLogin(email, password);
    }

    @Then("se visualiza la pagina principal")
    public void verify_Home(){
        HomeService.verifyPage();
    }

}
