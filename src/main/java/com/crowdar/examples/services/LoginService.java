package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.MobileActionManager.*;

public class LoginService {

    public static void doLogin(String email, String password){
        setInput(LoginConstants.EMAIL_INPUT_LOCATOR, email);
        setInput(LoginConstants.PASSWORD_INPUT_LOCATOR, password);
        click(LoginConstants.SIGN_IN_BUTTON_LOCATOR);
    }

    public static void isViewLoaded(){
        waitVisibility(LoginConstants.SIGN_UP_BUTTON_LOCATOR);
        Assert.assertTrue(isVisible(LoginConstants.EMAIL_INPUT_LOCATOR));
    }

    public static void setPassword(String password) {
        setInput(LoginConstants.PASSWORD_INPUT_LOCATOR, password);
    }

    public static void clickLoginButton() {
        click(LoginConstants.SIGN_IN_BUTTON_LOCATOR);
    }

    public static void setEmail(String email){
        setInput(LoginConstants.EMAIL_INPUT_LOCATOR, email);
    }




}
