@smoke @search
Feature: Căutare utilizatori

  Background:
    # Acesta este pasul de legătură.
    # Nu repetăm pașii de "Introduce user", "Apasa buton".
    Given utilizatorul este logat în aplicație

  Scenario: Căutare după nume existent
    When utilizatorul caută "George" în bara de navigare
    Then ar trebui să vadă o listă de rezultate care conține "George"