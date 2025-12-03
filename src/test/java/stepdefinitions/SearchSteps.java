package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SearchSteps {

    @When("utilizatorul caută {string} în bara de navigare")
    public void searchUser(String query) {
        // Locator pentru bara de search (din header.php/style.css)
        // De obicei este input[name='q'] sau clasa .search_text_input
        $(By.cssSelector("input[name='q']")).setValue(query);
    }

    @Then("ar trebui să vadă o listă de rezultate care conține {string}")
    public void verifyResults(String expectedName) {
        // Așteptăm ca dropdown-ul de rezultate să apară
        $(".search_results").shouldBe(visible);
        // Verificăm textul
        $(".search_results").shouldHave(text(expectedName));
    }
}