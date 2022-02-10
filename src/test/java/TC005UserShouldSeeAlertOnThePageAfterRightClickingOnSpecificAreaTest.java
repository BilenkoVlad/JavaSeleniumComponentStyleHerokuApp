import org.testng.annotations.Test;
import pages.HomePage;
import utils.browsers.BrowserManager;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TC005UserShouldSeeAlertOnThePageAfterRightClickingOnSpecificAreaTest extends BaseClass {
    @Test
    public void UserShouldSeeAlertOnThePageAfterRightClickingOnSpecificAreaTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Context Menu").click();

        assertEquals(homePage.contextMenuPage().headerPage().getText().trim(), "Context Menu");
        assertEquals(homePage.contextMenuPage().bodyTextList().get(0).getText(), "Context menu items are custom " +
                "additions that appear in the right-click menu.");
        assertEquals(homePage.contextMenuPage().bodyTextList().get(1).getText(), "Right-click in the box below to see " +
                "one called 'the-internet'. When you click it, it will trigger a JavaScript alert.");
        assertTrue(homePage.contextMenuPage().contextBox().isDisplayed());

        homePage.contextMenuPage().contextBox().click();
        assertFalse(BrowserManager.alertIsPresent());

        homePage.contextMenuPage().headerPage().rightClick();
        assertFalse(BrowserManager.alertIsPresent());

        homePage.contextMenuPage().contextBox().rightClick();

        assertTrue(BrowserManager.alertIsPresent());
        assertEquals(BrowserManager.alertText(), "You selected a context menu");

        BrowserManager.acceptAlert();
        assertFalse(BrowserManager.alertIsPresent());
    }
}
