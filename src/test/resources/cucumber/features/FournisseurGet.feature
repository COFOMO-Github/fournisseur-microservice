Feature: Fournisseur rest API test

  Scenario: Test de l'appel GET du WS cas nominal
    Given on a une fournisseur entree/payloadEntree_Get.json
    When l'utilisateur fait un appel GET 1
    Then le serveur gere l'appel GET avec success 200

  Scenario: Test de l'appel GET du WS cas fournisseur non trouvable
    Given on a une fournisseur en entree entree/payloadEntree_Get.json
    When l'utilisateur fait un appel GET avec id non valide 5
    Then le serveur gere l'appel GET avec Not_Found excpetion 404