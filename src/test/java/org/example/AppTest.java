package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public static class responseassertion {
    }

    public static class login {
        Playwright playwright = Playwright.create();
        BrowserType firefox = playwright.firefox();
        Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
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
            System.out.println("Successfully logged In");// Write code here that turns the phrase above into concrete actions

        }




    //        @After
    //        public void tearDown() {
    //            page.close();
    //            context.close();
    //            browser.close();
    //        }


    }
}
