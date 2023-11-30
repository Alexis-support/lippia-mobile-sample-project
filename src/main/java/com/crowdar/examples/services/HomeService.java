package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.crowdar.core.actions.MobileActionManager.*;
import static com.crowdar.examples.constants.HomeConstants.*;


public class HomeService {

    public static final ThreadLocal<Boolean> DARKMODE_STATUS = new ThreadLocal<>();

    public static void isViewLoaded() {
        waitVisibility(ADD_TIME_BUTTON_LOCATOR);
        Assert.assertTrue(isVisible(ADD_TIME_BUTTON_LOCATOR), "Login fallido");
    }

    public static void clickBotonAddTime(String btn) {
        waitVisibility(ADD_TIME_BUTTON_LOCATOR);
        click(ADD_TIME_BUTTON_LOCATOR, btn);
    }

    public static void clickSaveButton(String btn) throws InterruptedException {
        Thread.sleep(2000);
        MobileActionManager.click(BUTTON_SAVE, btn);
    }

    public static void projectCreated(String project) throws InterruptedException {
        String projectos = MobileActionManager.getText(HomeConstants.CROWDAR_PROJECT + project + "']");
        Assert.assertEquals(projectos, "NewProjectAcademy2");
    }

    public static void entryHours(String hours) {
        WebElement element = MobileActionManager.getElement(INPUT_HOURS);
        while (!element.getText().equals(hours)) {
            MobileActionManager.click(HOURS_BUTTON);
        }
    }

    public static void entryMinutes(String minutes) {
        WebElement element = MobileActionManager.getElement(INPUT_MINUTES);
        while (!element.getText().equals(minutes)) {
            MobileActionManager.click(MINUTES_BUTTON);
        }
    }

    public static void selectProject(String project) {
        MobileActionManager.click(HomeConstants.PROJECT_BUTTON);
        MobileActionManager.waitVisibility(HomeConstants.LOCATOR_PROJECTS_SECTION_FIRST);
        MobileActionManager.click(HomeConstants.CROWDAR_PROJECT + project + "']");
    }

    public static void logout() {
        MobileActionManager.click(HomeConstants.LOCATOR_NAVIGATIONDRAWER);
        MobileActionManager.click(HomeConstants.LOCATOR_LOGOUTDRAWER);
        MobileActionManager.click(HomeConstants.LOCATOR_LOGOUTCONFIRM_BUTTON);
    }

    public static void enterInSettings() {
        MobileActionManager.click(HomeConstants.LOCATOR_NAVIGATIONDRAWER);
        MobileActionManager.click(HomeConstants.LOCATOR_SETTINGDRAWER);
    }

    public static void checkDarkModeInSettings() {
        String darkmodeStatus = MobileActionManager.getElement(HomeConstants.LOCATOR_DARKMODE_TOGGLE).getAttribute("text");
        if (darkmodeStatus.equals("ON")) {
            DARKMODE_STATUS.set(Boolean.TRUE);
        } else {
            DARKMODE_STATUS.set(Boolean.FALSE);
        }
    }

    public static void changeDarkModeStatus() {
        MobileActionManager.click(HomeConstants.LOCATOR_DARKMODE_TOGGLE);
    }

    public static void validateDarkModeStatus() {
        Boolean initialStatus = DARKMODE_STATUS.get();
        Boolean currentStatus = MobileActionManager.getElement(HomeConstants.LOCATOR_DARKMODE_TOGGLE).getAttribute("text").equals("ON");
        Assert.assertFalse(initialStatus && currentStatus);
    }

}
