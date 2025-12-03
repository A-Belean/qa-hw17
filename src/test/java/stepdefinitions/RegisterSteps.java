package stepdefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegisterSteps {

    TestContext context;

    // Constructor Injection
    public RegisterSteps(TestContext context) {
        this.context = context;
    }

    @And("utilizatorul accesează formularul de înregistrare")
    public void accessRegisterForm() {
        // Facem click pe linkul care afișează formularul de register (id="signup")
        $(By.id("signup")).click();

        // Așteptăm ca div-ul care conține formularul de register (id="second") să devină vizibil
        $(By.id("second")).shouldBe(visible);
    }

    @When("completează formularul de înregistrare:")
    public void fillRegisterForm(DataTable dataTable) {
        // Convertim tabelul Gherkin în List<Map<String, String>>
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Extragem datele din primul rând (index 0)
        String fName = data.get(0).get("First Name");
        String lName = data.get(0).get("Last Name");
        String emailOriginal = data.get(0).get("Email");
        String pass  = data.get(0).get("Password");

        // GENERARE EMAIL UNIC: Modificăm "ion@test.com" în "ion_1700000000@test.com"
        // Astfel, la fiecare rulare, userul va fi unic.
        String uniqueEmail = emailOriginal.replace("@", "_" + System.currentTimeMillis() + "@");

        System.out.println("Registering user with email: " + uniqueEmail);

        // Completăm formularul (Locatori din login_register.php, div-ul #second)
        $(By.name("reg_fname")).setValue(fName);
        $(By.name("reg_lname")).setValue(lName);

        // Folosim adresa unică generată
        $(By.name("reg_email")).setValue(uniqueEmail);
        $(By.name("reg_email2")).setValue(uniqueEmail); // Confirmare email

        $(By.name("reg_password")).setValue(pass);
        $(By.name("reg_password2")).setValue(pass); // Confirmare parolă

        $(By.name("register_button")).click();

        // SALVĂM în context
        context.setGeneratedEmail(uniqueEmail);
    }

    @Then("contul este creat cu succes")
    public void verifyRegistration() {
        // Verificăm mesajul de succes "You're all set!..."
        $$(".success-message span").shouldHave(texts(
                "You're all set! Go ahead and login!",
                "Please check your email to activate your account."
        ));
    }
}