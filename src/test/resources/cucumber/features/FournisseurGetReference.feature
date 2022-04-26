Feature: Fournisseur rest API test

  Scenario: Test de l'appel GET avec param reference du WS cas nominal
    Given on a un fournisseur payloadEntree_GetByRef.json
    When l'utilisateur fait un appel GET ref = REF_APPLE_STORE_1
    Then le serveur gere l'appel du GET avec success 200

  Scenario: Test de l'appel GET avec param reference du WS cas fournisseur non trouvable
    Given on a un fournisseur en entree payloadEntree_GetByRef.json
    When l'utilisateur fait un appel GET avec reference non valide
    Then le serveur gere l'appel GET avec Not_Found exception 404
