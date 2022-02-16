import org.testng.annotations.Test;
import pages.HomePage;
import utils.Waiters;
import utils.browsers.BrowserManager;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0020UserIsAbleToWorkWithAlertsTest extends BaseClass {
    @Test
    public void UserIsAbleToWorkWithAlertsTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("JavaScript Alerts").click();

        List<String> jsNames = Arrays.asList("Click for JS Alert", "Click for JS Confirm", "Click for JS Prompt");

        assertEquals(homePage.javaScriptAlertsPage().headersPage().getText(), "JavaScript Alerts");
        assertEquals(homePage.javaScriptAlertsPage().bodyText().getText(), "Here are some examples of different JavaScript alerts which " +
                "can be troublesome for automation");
        for (int i = 0; i < homePage.javaScriptAlertsPage().jsButtonsList().size(); i++) {
            assertTrue(homePage.javaScriptAlertsPage().jsButtonsList().get(i).isDisplayed());
            assertTrue(homePage.javaScriptAlertsPage().jsButtonsList().get(i).isEnabled());
            assertEquals(homePage.javaScriptAlertsPage().jsButtonsList().get(i).getText(), jsNames.get(i));
        }
        assertEquals(homePage.javaScriptAlertsPage().resultText().getText(), "Result:");
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "");

        homePage.javaScriptAlertsPage().jsAlert().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS Alert");

        BrowserManager.acceptAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You successfully clicked an alert");

        homePage.javaScriptAlertsPage().jsConfirm().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS Confirm");
        BrowserManager.acceptAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You clicked: Ok");

        homePage.javaScriptAlertsPage().jsConfirm().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS Confirm");
        BrowserManager.dismissAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You clicked: Cancel");

        homePage.javaScriptAlertsPage().jsPrompt().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS prompt");
        BrowserManager.sendKeysToAlert("Test text with !@#$%^&*()");
        BrowserManager.acceptAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You entered: Test text with !@#$%^&*()");

        homePage.javaScriptAlertsPage().jsPrompt().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS prompt");
        BrowserManager.sendKeysToAlert("Test text with !@#$%^&*()");
        BrowserManager.dismissAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You entered: null");

        homePage.javaScriptAlertsPage().jsPrompt().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS prompt");
        BrowserManager.acceptAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You entered:");

        homePage.javaScriptAlertsPage().jsPrompt().click();

        Waiters.waitUntilCondition(BrowserManager::alertIsPresent, 5, "Alert presented");
        assertEquals(BrowserManager.alertText(), "I am a JS prompt");
        BrowserManager.dismissAlert();
        assertEquals(homePage.javaScriptAlertsPage().resultMessage().getText(), "You entered: null");
    }
}
