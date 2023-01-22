Feature: Añadir al carrito productos

  Scenario: El usuario quiere comprar tres productos

    Given Usuario entra en la web en categoria moviles
    When Elige un movil A "Samsung galaxy s7"
    Then Se confirma que se añade la compra


    When Elige un movil B "Samsung galaxy s6"
    Then Se confirma que se añade la compra 2


    When Elige un portatil "Sony vaio 5"
    Then Se confirma que se añade la compra 3


