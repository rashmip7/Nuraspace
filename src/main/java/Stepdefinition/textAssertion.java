package Stepdefinition;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.List;
public class textAssertion {
    Playwright playwright = Playwright.create();

    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

    @Given("the user login to {string}")
    public void navigateToUrlText(String url) {
        page.navigate(url);
        page.fill("input[name='email']", "tester.nura@nuraspace.com");
        page.click("//span[@class='MuiButton-label']");
        page.fill("input[name='password']", "tester@Nura1");
        page.click("//*[@id=\"app\"]/div/div[1]/div/div/div[3]/div[2]/div/div/form/div/button/span[1]\n");
        String expectedURL = "https://dashboard-testing.nuraspace.com/live"; // Change this to match your application
        page.waitForURL(expectedURL);
    }

    @When("the user checks the page text")
    public void checkPageText() {
        String pageText = page.textContent("body");
        System.out.println(pageText);
    }

    @Then("the page should contain the following text")
    public void verifyMultipleTextElements(List<String> expectedTextList) {
        String pageText = page.textContent("body");

        for (String expectedText : expectedTextList) {
            System.out.println("Expected Text: " + expectedText);
            System.out.println("Page Text: " + pageText);
            Assert.assertTrue("Text not found: " + expectedText, pageText.contains(expectedText));
        }

    }
}

