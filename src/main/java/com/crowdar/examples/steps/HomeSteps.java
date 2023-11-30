package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import com.crowdar.examples.services.AddEntryService;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomeSteps extends PageSteps {

    @Then("Home page is displayed")
    public void isHomePageVisible() {
        HomeService.isViewLoaded();
    }
    @Given("El usuario esta logeado")
    public void elUsuarioEstaLogeado() {
        LoginService.doLogin(PropertyManager.getProperty("email"), PropertyManager.getProperty("password"));
    }
    @When("^hace click en el boton (.*)$")
    public void haceClickEnElBotonAddEntry(String btn) {
        HomeService.clickBotonAddTime(btn);
    }
    @Then("se visualiza el proyecto creado en el dashboard de la aplicacion '(.*)'")
    public void seVisualizaElProyectoCreadoEnElDashboardDeLaAplicacion(String project) throws InterruptedException {
        HomeService.projectCreated(project);
    }
    @And("^clickea en el boton (.*)$")
    public void clickeaEnElBotonSave(String btn) throws InterruptedException {
        HomeService.clickSaveButton(btn);
    }
    @And("^setea las horas '(.*)' y los minutos '(.*)'$")
    public void setTheHoursAndMinutes(String horas, String min) {
        HomeService.entryHours(horas);
        HomeService.entryMinutes(min);
    }
    @And("seleccciona el proyecto '(.*)' en el Project Menu")
    public void selectTheCrowdarAcademyProjectOnTheProjectMenu(String project) {
        HomeService.selectProject(project);

    }
    @And("^setea la descripcion '(.*)'$")
    public void setTheDescription(String description) {
        AddEntryService.setDescription(description);
    }

    @When("el usuario cierra sesion")
    public void theUserLogsOut() {
        HomeService.logout();
    }
    @When("El usuario ingresa a la configuración y verifica el estado actual del modo oscuro")
    public void theUserEntersInSettingsAndChecksTheCurrentDarkModeStatus() {
        HomeService.enterInSettings();
        HomeService.checkDarkModeInSettings();
    }

    @And("El usuario clickea 'Habilitar modo oscuro'")
    public void theUserTapsOnTheEnableDarkModeToggle() {
        HomeService.changeDarkModeStatus();
    }

    @io.cucumber.java.en.Then("El estado del modo oscuro ahora se ve en la pantalla inicial")
    public void theDarkModeStatusIsNowTheOppositeOfTheInitialOne() {
        HomeService.validateDarkModeStatus();
    }

}
