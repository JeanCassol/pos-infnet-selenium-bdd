Feature: Busca o melhor time no GE

  Scenario: Entra no site do GE e seleciona o melhor time do mundo
    Given Entra no GE
    When busca por "Grêmio"
    And seleciona primeiro da lista
    Then mostra nome do time