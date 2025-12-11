package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProfilePage;

public class ProfileSteps {

    private ProfilePage profilePage = new ProfilePage();
    private String lastSearchedUser;

    @When("utilizatorul caută {string} în bara de navigare")
    public void searchBar(String query) {
        lastSearchedUser = query;
        profilePage.searchAndNavigateToResultsPage(query);
    }
    @Then("ar trebui să vadă o listă de rezultate care conține {string}")
    public void searchList(String expectedName) {
        profilePage.verifyResultsContain(expectedName);
    }
    @Then("alege primul utlizator si intra pe profil la el")
    public void FirstUseropen() {
        profilePage.selectFirstUserAndGoToProfile(lastSearchedUser);
    }
}