Feature: Fournisseur rest API test

  Scenario: Test de l'appel DELETE du WS
    Given on a bien une fournisseur entree/payloadEntree_Creation.json
    When l'utilisateur fait un appel DELETE 1
    Then la fournisseur en question doit etre supprimée 200

  Scenario: Test de l'appel DELETE du WS avec erreur
    When l'utilisateur supprime une fournisseur non existante 5
    Then une exception est generée 404

