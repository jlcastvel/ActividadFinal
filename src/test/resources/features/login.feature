Feature: Login en una aplicacion

  Scenario: Login exitoso en una web de informatica
    Given Abrir sitio web
    When Se escriben las credenciales usando para usuario "testM4" y para contraseña "test"
    Then El usuario clica en Login y se logea