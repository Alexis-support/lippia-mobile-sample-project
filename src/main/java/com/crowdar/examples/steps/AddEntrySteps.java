package com.crowdar.examples.steps;

import com.crowdar.examples.services.AddEntryService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEntrySteps {
    @When("El usuario descarta la adición de la nueva entrada de tiempo")
    public void theUserDiscardsTheAdditionOfTheNewTimeEntry() {
        AddEntryService.discardNewEntryAddition();
    }

    @Then("La entrada de tiempo no se guarda y no aparece en la lista de entradas '(.*)'")
    public void theTimeEntryIsNotSavedAndDoesnTAppearInTheEntriesList(String sintimeEntry) {
        AddEntryService.validarTimeEntryNoCreado(sintimeEntry);
    }

    @And("The user set calendar with day: (.*), month: (.*), year: (.*)")
    public void setCalendar(String day, String month, String year) {
        AddEntryService.setCalendar(day,month,year);
    }

    @Then("el usuario ve la entrada de horas guardadas correctamente con el nombre '(.*)'")
    public void elUsuarioVeLaEntradaDeHorasGuardadasCorrectamente(String description) {
        AddEntryService.entryHoursVerification(description);

    }
}
