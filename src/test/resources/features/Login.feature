@Smoke
Feature: Login

  Background:
    Given The app is loaded correctly

  @Login
  Scenario Outline: The user log in to the app.
    When The user enter his email <user>
    And The user enter password <password>
    And user login
    Then Home page is displayed

    Examples:
      | user                   | password  |
      | elalesipe123@gmail.com | asdasd123 |

  @EntradaSimple
  Scenario Outline: Successful Time Entry
    Given El usuario esta logeado
    When hace click en el boton Add entry
    And setea las horas '<hours>' y los minutos '<minutes>'
    And setea la descripcion '<description>'
    And seleccciona el proyecto the NewProjectAcademy2 en el Project Menu
    And clickea en el boton Save
    Then se visualiza el proyecto creado en el dashboard de la aplicacion

    Examples:
      | hours | minutes | description     |
      | 03    | 05      | Primer Proyecto |

