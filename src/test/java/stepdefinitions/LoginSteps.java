package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

// Importăm explicit clasa By din Selenium
import org.openqa.selenium.By;
import pages.LoginPage;

// Importuri statice Selenide
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginSteps {

    // Inainte de POM

    @Given("utilizatorul deschide pagina de login {string}")
    public void openLoginPage(String url) {
        open(url);
    }

    @When("utilizatorul introduce emailul {string}")
    public void enterEmail(String email) {
        // Locator din login_register.php: name="log_email"
        $(By.name("log_email")).setValue(email);
    }

    @And("utilizatorul introduce parola {string}")
    public void enterPassword(String password) {
        // Locator din login_register.php: name="log_password"
        $(By.name("log_password")).setValue(password);
    }

    @And("utilizatorul apasă butonul de login")
    public void clickLogin() {
        // Locator din login_register.php: name="login_button"
        $(By.name("login_button")).click();
    }

    @Then("utilizatorul ar trebui să fie redirecționat către homepage")
    public void verifyHomepage() {
        // Verificăm un element care există doar în index.php (după login)
        // De exemplu, div-ul cu clasa .posts_area sau .user_details
        $(".posts_area").shouldBe(visible);
    }

    @Then("utilizatorul ar trebui să vadă un mesaj de eroare {string}")
    public void verifyErrorMessage(String expectedError) {
        // Verificăm dacă textul așteptat apare în body (HapifyMe afișează erorile ca text simplu uneori)
        // Sau căutăm un element specific de eroare dacă există
        $("body").shouldHave(text(expectedError));
    }


    // Dupa POM

    // Instanțiem Page Object-ul
    LoginPage loginPage = new LoginPage();

    @Given("utilizatorul deschide pagina de login")
    public void openApp() {
        loginPage.openPage();
    }

    @When("utilizatorul se autentifică cu emailul {string} și parola {string}")
    public void performLogin(String email, String password) {
        // Toată logica complexă e ascunsă în metoda login() din Page Object
        loginPage.login(email, password);
    }
}