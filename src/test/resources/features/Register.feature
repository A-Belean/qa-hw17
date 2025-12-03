Feature: Înregistrare Utilizator

  Scenario: Înregistrare cu succes
    Given utilizatorul deschide pagina de login "https://test.hapifyme.com/login_register.php"
    # Formularul de înregistrare este ascuns implicit. Trebuie să facem click pe link-ul "Need an account?".
    And utilizatorul accesează formularul de înregistrare
    When completează formularul de înregistrare:
      | First Name | Last Name | Email          | Password |
      | Ion        | Popescu   | ion@test.com   | Pass@123 |
      | Ion        | Ionescu   | jon@test.com   | Pass@321 |

    Then contul este creat cu succes