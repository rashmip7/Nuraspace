package Stepdefinition;
import com.microsoft.playwright.*;

import java.util.List;

public class imageAssertion {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            // Navigate to the webpage and check image presence
            page.navigate("https://dashboard-testing.nuraspace.com/login");
            boolean hasImages = checkForImages(page);

            if (hasImages) {
                System.out.println("The webpage contains images.");
            } else {
                System.out.println("The webpage does not contain any images.");
            }
            page.close();
            browser.close();
        }
    }
    public static boolean checkForImages(Page page) {
        try {
            // Use Playwright to query all image elements
            List<ElementHandle> imageElements = page.querySelectorAll("img");

            // Check if any image elements were found
            return !imageElements.isEmpty();
        } catch (PlaywrightException e) {
            return false;
        }
    }
}