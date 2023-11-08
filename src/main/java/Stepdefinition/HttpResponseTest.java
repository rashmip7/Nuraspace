package Stepdefinition;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HttpResponseTest {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        APIRequest request = playwright.request();
        APIRequestContext requestContext = request.newContext();
        APIResponse apiResponse= requestContext.get("https://dashboard-testing.nuraspace.com/login");


        @Given(value = "the user navigates to {string}")
        public void navigateToUrl(String url) {
            page.navigate(url);
        }

        @When("the user checks the HTTP response")
        public void checkHttpResponse() {
            APIRequest request = playwright.request();
            APIRequestContext requestContext = request.newContext();
            APIResponse apiResponse= requestContext.get("https://dashboard-testing.nuraspace.com/login");

         }

        @Then("the HTTP status code should be {int}")
        public void verifyHttpStatusCode(int expectedStatusCode) {
            int actualStatusCode = apiResponse.status();
            Assert.assertEquals(expectedStatusCode, actualStatusCode);
        }


}
