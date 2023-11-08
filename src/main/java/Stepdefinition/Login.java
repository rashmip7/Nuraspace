package Stepdefinition;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class Login {
    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

    private final String username = System.getenv("Username");
    private final String password = System.getenv("Password");



    @Given("the user is on the login page")
    public void openLoginPage() {
        page.navigate("https://dashboard-testing.nuraspace.com/login");
    }

    @When("the user enters valid username {string} and password {string}")
    public void enterValidCredentials(String username, String password) {
        page.fill("input[name='email']", username);
        page.click("//span[@class='MuiButton-label']");
        page.fill("input[name='password']", password);
    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        System.out.println("Successfully logged In");

    }
}

