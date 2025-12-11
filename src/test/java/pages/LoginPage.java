package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    // Locatori (privați, pentru encapsulare)
    private By emailInput = By.name("log_email");
    private By passwordInput = By.name("log_password");
    private By loginButton = By.name("login_button");

    // Metode de acțiune
    public void openPage() {
        open("/login_register.php"); // Folosește baseUrl din Hooks
    }

    public void login(String email, String password) {
        $(emailInput).setValue(email);
        $(passwordInput).setValue(password);
        $(loginButton).click();
    }
    public void verifyError(String expectedError) {
        $("body").shouldHave(text(expectedError)); // <--- aici
    }
    public void verifyHomepage() {
        $(".posts_area").shouldBe(visible); // sau alt element vizibil doar după login
    }
}