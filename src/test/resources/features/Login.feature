@smoke @login
Feature: Autentificarea în HapifyMe
# scenariul simplu
  Background:
    Given utilizatorul deschide pagina de login "https://test.hapifyme.com/login_register.php"

  @valid
  Scenario: Login cu succes folosind credențiale valide
    When utilizatorul introduce emailul "george.datcu@hotmail.com"
    And utilizatorul introduce parola "qazXSW@13"
    And utilizatorul apasă butonul de login
    Then utilizatorul ar trebui să fie redirecționat către homepage


# rafinare teste cu Scenario Outline
  @regression @negative
  Scenario Outline: Login eșuat cu date invalide
    When utilizatorul introduce emailul "<email>"
    And utilizatorul introduce parola "<password>"
    And utilizatorul apasă butonul de login
    Then utilizatorul ar trebui să vadă un mesaj de eroare "<error_message>"

    Examples:
      | email                    | password       | error_message                   |
      | user.inexistent@test.com | parola123      | Email or password was incorrect |
      | george.datcu@hotmail.com | gresita123     | Email or password was incorrect |
      | delia.raio@abc.com       | abcD@123       | Email or password was incorrect |

