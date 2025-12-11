package context;

import java.util.ArrayList;
import java.util.List;

public class TestContext {
    private String generatedEmail;
    private String createdPostContent;
    private List<String> createdPosts = new ArrayList<>();

    // Getters and Setters
    public String getGeneratedEmail() { return generatedEmail; }
    public void setGeneratedEmail(String email) { this.generatedEmail = email; }

    public String getCreatedPostContent() { return createdPostContent; }
    public void setCreatedPostContent(String content) { this.createdPostContent = content; }

    public void addPost(String post) {
        createdPosts.add(post);
    }

    public List<String> getCreatedPosts() {
        return createdPosts;
    }
}