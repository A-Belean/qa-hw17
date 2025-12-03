package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;

public class CommonSteps {

    // 1. Instanțiem Page Object-ul creat la Pasul A
    LoginPage loginPage = new LoginPage();

    // 2. Mapăm textul din Gherkin (Pasul B)
    @Given("utilizatorul este logat în aplicație")
    public void performBackgroundLogin() {
        System.out.println("--- Background: Se execută Login automat ---");

        // 3. Reutilizăm logica de business din Page Object
        loginPage.openPage();

        // Folosim un cont de test valid (hardcodat sau din config)
        loginPage.login("george.datcu@hotmail.com", "qazXSW@13");

        System.out.println("--- Background: Login complet. Începe testul de Search ---");
    }
}