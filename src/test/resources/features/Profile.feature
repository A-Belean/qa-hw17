@smoke @profile
Feature: Căutare utilizatori
  Pentru a gasi si accesa profilul altor persoane
  Ca utilizator autentificat

  Background:
    Given utilizatorul este logat în aplicație

  Scenario: Căutare după nume existent
    When utilizatorul caută "George" în bara de navigare
    Then ar trebui să vadă o listă de rezultate care conține "George"
    Then alege primul utlizator si intra pe profil la el

