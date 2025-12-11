package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;


public class PostPage {

    // Locatori (privați, pentru encapsulare)
    private By postText = By.name("post_text");
    private By postButton = By.name("post");
    private final By postFeedItems = By.cssSelector(".post_body_content");

    // Metode de acțiune
    public void openPage() {
        open("/index.php"); // Folosește baseUrl din Hooks
    }

    public void createPost(String text) {
        $(postText).setValue(text);
        $(postButton).click();
    }

    public void verifyPost(String content) {
        // Găsește postarea pe feed după text
        $$(postFeedItems).findBy(text(content)).shouldBe(visible);
    }


}