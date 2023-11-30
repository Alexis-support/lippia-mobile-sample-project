@TPFinal
Feature: Como cliente potencial quiero interactuar con la aplicación móvil

  @AddTimeEntryWithDates
  Scenario Outline: El usuario agrega una nueva hora con fecha exitosamente y la fecha debe ser menor o igual a la fecha actual
    Given El usuario esta logeado
    And Home page is displayed
    When hace click en el boton Add entry
    And setea la descripcion '<description>'
    And setea las horas '<hours>' y los minutos '<minutes>'
    And seleccciona el proyecto '<project>' en el Project Menu
    And The user set calendar with day: <day>, month: <month>, year: <year>
    And clickea en el boton Save
    And clickea en el boton Save
    Then se visualiza el proyecto creado en el dashboard de la aplicacion '<project>'
    @Success
    Examples:
      | hours | minutes | description | project            | day | month    | year |
      | 02    | 04      | TestsFinal  | NewProjectAcademy2 | 17  | December | 2023 |

  @CancelAddTimeEntry
  Scenario Outline: El usuario comienza a agregar una nueva entrada de tiempo y cancela el proceso
    Given El usuario esta logeado
    And Home page is displayed
    When hace click en el boton Add entry
    And setea las horas '<hours>' y los minutos '<minutes>'
    And setea la descripcion '<description>'
    And seleccciona el proyecto '<project>' en el Project Menu
    When El usuario descarta la adición de la nueva entrada de tiempo
    Then La entrada de tiempo no se guarda y no aparece en la lista de entradas '<project>'
    Examples:
      | hours | minutes | description | project            |
      | 02    | 06      | TestsFinal  | NewProjectAcademy2 |

  @DarkMode
  Scenario: El usuario cambia el estado del modo oscuro en la configuración
    Given El usuario esta logeado
    And Home page is displayed
    When El usuario ingresa a la configuración y verifica el estado actual del modo oscuro
    And El usuario clickea 'Habilitar modo oscuro'
    Then El estado del modo oscuro ahora se ve en la pantalla inicial

  @Logout
  Scenario: El usuario inicia sesión y luego cierra la sesión correctamente
    Given El usuario esta logeado
    And Home page is displayed
    When el usuario cierra sesion
    Then se ve la página de inicio de sesión
