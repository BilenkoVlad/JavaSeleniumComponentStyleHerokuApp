import org.testng.annotations.Test;
import pages.HomePage;
import utils.Waiters;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0011UserIsAbleToSeeModalWindowAndCanCloseItTest extends BaseClass {
    @Test
    public void UserIsAbleToSeeModalWindowAndCanCloseItTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Entry Ad").click();
        List<String> text = Arrays.asList("Displays an ad on page load.", "If closed, it will not appear " +
                "on subsequent page loads.", "To re-enable it, click here.");

        Waiters.waitUntilCondition(() -> homePage.entryAdPage().modalWindow().isDisplayed(), 5, "Modal window is opened");
        assertTrue(homePage.entryAdPage().modalWindow().isDisplayed());
        assertEquals(homePage.entryAdPage().modalWindow().title().getText(), "This is a modal window".toUpperCase());
        assertEquals(homePage.entryAdPage().modalWindow().text().getText(), "It's commonly used to encourage a user to take an action " +
                "(e.g., give their e-mail address to sign up for something or disable their ad blocker).");
        assertEquals(homePage.entryAdPage().modalWindow().closeButton().getText(), "Close");

        homePage.entryAdPage().modalWindow().closeButton().click();

        assertEquals(homePage.entryAdPage().headersPage().getText(), "Entry Ad");
        for (int i = 0; i < homePage.entryAdPage().bodyTextList().size(); i++) {
            assertEquals(homePage.entryAdPage().bodyTextList().get(i).getText(), text.get(i));
        }
        assertEquals(homePage.entryAdPage().clickHereLink().getTagName(), "a");
        assertTrue(homePage.entryAdPage().clickHereLink().isDisplayed());

        while (homePage.entryAdPage().modalWindow().isNotDisplayed()) {
            homePage.entryAdPage().clickHereLink().click();
        }

        assertTrue(homePage.entryAdPage().modalWindow().isDisplayed());
        assertEquals(homePage.entryAdPage().modalWindow().title().getText(), "This is a modal window".toUpperCase());
        assertEquals(homePage.entryAdPage().modalWindow().text().getText(), "It's commonly used to encourage a user to take an action " +
                "(e.g., give their e-mail address to sign up for something or disable their ad blocker).");
        assertEquals(homePage.entryAdPage().modalWindow().closeButton().getText(), "Close");

        homePage.entryAdPage().modalWindow().closeButton().click();
    }
}
