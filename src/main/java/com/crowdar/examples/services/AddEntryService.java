package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.examples.constants.AddEntryConstants;
import com.crowdar.examples.constants.HomeConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.crowdar.core.actions.ActionManager.click;
import static com.crowdar.core.actions.ActionManager.isPresent;
import static java.lang.Integer.parseInt;

public class AddEntryService {

    public static void discardNewEntryAddition() {
        click(AddEntryConstants.LOCATOR_BACK_BUTTON);
        click(AddEntryConstants.LOCATOR_DISCARDCONFIRM_BUTTON);
    }
    public static void setDescription(String description) {
        MobileActionManager.setInput(HomeConstants.INPUT_DESCRIPTION, description);
    }

    public static void validarTimeEntryNoCreado(String sinTime) {
        List<String> lista = AddEntryService.getAllElements(HomeConstants.LOCATOR_LISTITEMS);
        boolean textIsNotThere = lista.contains(sinTime);
        if (!textIsNotThere) {
            System.out.println("El Time entry no fue guardado!");
        } else {
            throw new Error("El Time entry se encuentra en la lista! FALLO!!!");
        }
    }
    public static void entryHoursVerification(String description){
        MobileActionManager.waitVisibility(AddEntryConstants.DIV_HOURS_DESCRIPTION);
        Assert.assertTrue(MobileActionManager.isVisible(AddEntryConstants.DISCARD_BUTTON_LOCATOR,description));
    }

    public static void setCalendar(String day, String month, String year){
        String calendar = day+" "+month+" "+year;

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int yearNow  = localDate.getYear();

        int yearInt =  parseInt(year);
        MobileActionManager.click(AddEntryConstants.ADD_DATES);

        while (!isPresent(AddEntryConstants.CALENDAR_LOCATOR.replace("%s",calendar))) {
            if (yearInt < yearNow) {
                click(AddEntryConstants.PREVIUS_MONTH_BUTTON_LOCATOR);
                break;
            }else{
                click(AddEntryConstants.NEXT_MONTH_BUTTON_LOCATOR);
            }
        }
        click(AddEntryConstants.CALENDAR_LOCATOR.replace("%s",calendar));
    }

    public static List<String> getAllElements(String locator){
        List<WebElement> list = WebActionManager.getElements(locator);
        List<String> stringsFromList = new ArrayList<String>();

        for (WebElement e : list){
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }


}
