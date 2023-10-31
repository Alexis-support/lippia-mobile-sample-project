package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
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
    @Then("se visualiza el proyecto creado en el dashboard de la aplicacion")
    public void seVisualizaElProyectoCreadoEnElDashboardDeLaAplicacion() throws InterruptedException {
        HomeService.proyectoCreado();
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
    @And("seleccciona el proyecto the NewProjectAcademy2 en el Project Menu")
    public void selectTheCrowdarAcademyProjectOnTheProjectMenu() {
        HomeService.selectProject();
        HomeService.selectCrowdarProject();
    }
    @And("^setea la descripcion '(.*)'$")
    public void setTheDescription(String description) {
        HomeService.setDescription(description);
    }
}
