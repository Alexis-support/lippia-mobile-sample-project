package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;

import static com.crowdar.examples.constants.HomeConstants.VIEW_DISPLAYED;


public class HomeService {

    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(HomeConstants.SIGN_OUT_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.CHANGE_LANGUAGE_BUTTON_LOCATOR), HomeConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }
    public static void verifyPage() {
        MobileActionManager.waitVisibility(VIEW_DISPLAYED);
        Assert.assertTrue(MobileActionManager.isVisible(VIEW_DISPLAYED));
    }
}
