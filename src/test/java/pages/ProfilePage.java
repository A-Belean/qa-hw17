package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

public class ProfilePage {
    private final By searchInput = By.cssSelector("input[name='q']");
    private final By searchResultsPageContainer = By.id("main_column");
    private final By searchResultsBlocks = By.cssSelector("#main_column .search_result");

    public void searchAndNavigateToResultsPage(String query) {
        $(searchInput).should(appear).setValue(query).pressEnter();

        $(searchResultsPageContainer).should(appear);
    }

    public boolean verifyResultsContain(String expectedName) {
        return $$(searchResultsBlocks)
                .findBy(text(expectedName))
                .should(exist)
                .isDisplayed();
    }
    public void selectFirstUserAndGoToProfile(String expectedName) {

        ElementsCollection results = $$(searchResultsBlocks)
                .filterBy(text(expectedName))
                .shouldHave(sizeGreaterThan(0));
        SelenideElement first = results.first();
        SelenideElement profileLink = first.$("a[href]");

        profileLink.shouldBe(visible).click();
    }


}