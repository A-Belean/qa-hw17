package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;


public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("utilizatorul deschide pagina de login")
    public void openApp() {
        loginPage.openPage();
    }

    @When("utilizatorul se autentifică cu emailul {string} și parola {string}")
    public void performLogin(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("utilizatorul ar trebui să vadă un mesaj de eroare {string}")
    public void verifyErrorMessage(String expectedError) {
        loginPage.verifyError(expectedError);
    }

    @Then("utilizatorul ar trebui să fie redirecționat către homepage")
    public void verifyHomepage() {
        loginPage.verifyHomepage();
    }
}