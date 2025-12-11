@smoke @post
Feature: Crearea unor postari pe Feed folosind Data Table
  Ca un utilizator inregistrat
  Vreau sa creez mai multe postari pe Feed (index.php)

  Background:
    Given utilizatorul este logat în aplicație

  Scenario: Creez mai multe postari folosind Data Table
    When Eu creez urmatoarele postari
      | text                       |
      | Salut, primele postari!    |
      | QA ROCKS                   |
      | Postare automată nr. 3     |
    Then Postarile trebuie sa apara pe feed


