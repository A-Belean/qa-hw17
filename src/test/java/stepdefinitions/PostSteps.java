package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.PostPage;
import context.TestContext;

import java.util.List;
import java.util.Map;

public class PostSteps {

    private final PostPage postPage = new PostPage();
    private final TestContext context;

    public PostSteps(TestContext context) {
        this.context = context;
    }

    // --- Pas pentru Data Table ---
    @When("Eu creez urmatoarele postari")
    public void eu_creez_urmatoarele_postari(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String text = row.get("text");

            postPage.createPost(text);
            context.addPost(text);
        }
    }

    @Then("Postarile trebuie sa apara pe feed")
    public void postarile_trebuie_sa_apara_pe_feed() {
        for (String post : context.getCreatedPosts()) {
            postPage.verifyPost(post);
        }
    }
}
