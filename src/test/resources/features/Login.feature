@smoke @login
Feature: Autentificarea în HapifyMe
  Pentru accesarea platformei
  Utlizatorii trebuie sa se poate autentifica

  @valid
  Scenario: Login cu succes folosind credențiale valide
    Given utilizatorul deschide pagina de login
    When utilizatorul se autentifică cu emailul "adibelean6@gmail.com" și parola "Cursqa01@"
    Then utilizatorul ar trebui să fie redirecționat către homepage

# rafinare teste cu Scenario Outline
  @regression @negative
  Scenario Outline: Login esuat cu date invalide
    Given utilizatorul deschide pagina de login
    When utilizatorul se autentifică cu emailul "<email>" și parola "<password>"
    Then utilizatorul ar trebui să vadă un mesaj de eroare "<error_message>"

    Examples:
      | email                    | password       | error_message                   |
      | adibelean6@gmail.com     | Cursqa01a@      | Email or password was incorrect |
      | test11@aaa.com           | abcD@123       | Email or password was incorrect |
      | test.test1@sca.com       | abc111         | Email or password was incorrect |

