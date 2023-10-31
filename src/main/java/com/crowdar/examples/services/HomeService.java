package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.crowdar.core.actions.MobileActionManager.*;
import static com.crowdar.examples.constants.HomeConstants.*;


public class HomeService {

    public static void isViewLoaded() {
        waitVisibility(ADD_TIME_BUTTON_LOCATOR);
        Assert.assertTrue(isVisible(ADD_TIME_BUTTON_LOCATOR), "Login fallido");
    }

    public static void clickBotonAddTime(String btn){
        waitVisibility(ADD_TIME_BUTTON_LOCATOR);
        click(ADD_TIME_BUTTON_LOCATOR,btn);
    }

    public static void clickSaveButton(String btn) throws InterruptedException {
        MobileActionManager.waitPresence(BUTTON_SAVE);
        MobileActionManager.click(BUTTON_SAVE,btn);
    }


    public static void proyectoCreado() throws InterruptedException {
        waitVisibility(CROWDAR_PROJECT);
        Assert.assertTrue(isVisible(CROWDAR_PROJECT), "Login fallido");
    }

    public static void entryHours(String hours) {
        WebElement element = MobileActionManager.getElement(INPUT_HOURS);
        while (!element.getText().equals(hours)){
            MobileActionManager.click(HOURS_BUTTON);
        }
    }

    public static void entryMinutes(String minutes) {
        WebElement element = MobileActionManager.getElement(INPUT_MINUTES);
        while (!element.getText().equals(minutes)){
            MobileActionManager.click(MINUTES_BUTTON);
        }
    }

    public static void selectProject(){
        MobileActionManager.click(HomeConstants.PROJECT_BUTTON);
    }

    public static void selectCrowdarProject(){
        MobileActionManager.click(HomeConstants.CROWDAR_PROJECT);
    }

    public static void setDescription(String description){
        MobileActionManager.setInput(HomeConstants.INPUT_DESCRIPTION, description);
    }

}
