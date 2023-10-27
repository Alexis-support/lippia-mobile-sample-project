Feature: Como usuario del sistema quiero interactuar con la aplicacion para registrar las horas de trabajo

  Background:
    Given Estar en la pagina de login

  @Login
  Scenario Outline: Login exitoso
    When el usuario se loguea con <email> y <password>
    Then se visualiza la pagina principal

    Examples:
      | email                  | password  |
      | elalesipe123@gmail.com | asdasd123 |