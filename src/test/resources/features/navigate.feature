Feature: Navegar por las catergorias de la web

  Scenario: Navegar por todas las categorias del homepage

    Given Usuario entra en la web
    When Usuario clica en "categoria" Phone
    Then  Usuario clica en "categoria" Laptops
    Then Usuario clica en "categoria" Monitors


