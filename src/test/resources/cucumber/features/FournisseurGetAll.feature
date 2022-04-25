Feature: Fournisseur rest API test Get ALL

  Scenario: Test de l'appel Get du WS ok
    When l'utilisateur fait un appel GET All payloadEntree_CreationListe.json
    Then le serveur retourne l'ensemble des données 200

  Scenario: Test de l'appel Get du WS not ok
    When l'utilisateur fait un appel GET All alors que la bdd est vide payloadEntree_CreationListeVide.json
    Then le serveur retourne rien 404


