import org.testng.annotations.Test;
import pages.HomePage;
import utils.Waiters;
import utils.browsers.BrowserManager;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0010VerifyThatElementsDynamicallyLoadedTest extends BaseClass {
    @Test
    public void VerifyThatElementsDynamicallyLoadedTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Dynamic Loading").click();

        List<String> bodyText = Arrays.asList("It's common to see an action get triggered that returns a result dynamically. " +
                "It does not rely on the page to reload or finish loading. The page automatically gets updated " +
                "(e.g. hiding elements, showing elements, updating copy, etc) through the use of JavaScript.", "There are two examples. One in which an element already exists on the page but it" +
                " is not displayed. And anonther where the element is not on the page and gets added in.");
        List<String> linksText = Arrays.asList("Example 1: Element on page that is hidden", "Example 2: Element rendered after the fact");

        assertEquals(homePage.dynamicLoadingPage().headersPage().getText(), "Dynamically Loaded Page Elements");
        for (int i = 0; i < homePage.dynamicLoadingPage().bodyLinksList().size(); i++) {
            assertEquals(homePage.dynamicLoadingPage().bodyLinksList().get(i).getText(), linksText.get(i));
        }
        for (int i = 0; i < homePage.dynamicLoadingPage().bodyTextList().size(); i++) {
            assertEquals(homePage.dynamicLoadingPage().bodyTextList().get(i).getText(), bodyText.get(i));
        }

        homePage.dynamicLoadingPage().bodyLinksList().get(0).click();

        assertEquals(homePage.example1HiddenElementsPage().headersPage().getText(), "Dynamically Loaded Page Elements");
        assertEquals(homePage.example1HiddenElementsPage().bodyText().getText(), "Example 1: Element on page that is hidden");
        assertTrue(homePage.example1HiddenElementsPage().startButton().isDisplayed());
        assertTrue(homePage.example1HiddenElementsPage().startButton().isEnabled());

        homePage.example1HiddenElementsPage().startButton().click();
        assertEquals(homePage.example1HiddenElementsPage().loader().getText(), "Loading...");
        assertTrue(homePage.example1HiddenElementsPage().loader().isDisplayed());
        Waiters.waitUntilCondition(() -> homePage.example1HiddenElementsPage().hiddenText().isDisplayed(), 5, "Hidden text is displayed");
        assertTrue(homePage.example1HiddenElementsPage().hiddenText().isDisplayed());
        assertEquals(homePage.example1HiddenElementsPage().hiddenText().getText(), "Hello World!");

        BrowserManager.navigateBackInPage();

        homePage.dynamicLoadingPage().bodyLinksList().get(1).click();

        assertEquals(homePage.example2ElementRendered().headersPage().getText(), "Dynamically Loaded Page Elements");
        assertEquals(homePage.example2ElementRendered().bodyText().getText(), "Example 2: Element rendered after the fact");
        assertTrue(homePage.example2ElementRendered().startButton().isDisplayed());
        assertTrue(homePage.example2ElementRendered().startButton().isEnabled());

        homePage.example2ElementRendered().startButton().click();
        assertEquals(homePage.example2ElementRendered().loader().getText(), "Loading...");
        assertTrue(homePage.example2ElementRendered().loader().isDisplayed());
        Waiters.waitUntilCondition(() -> homePage.example2ElementRendered().hiddenText().isDisplayed(), 5, "Hidden text is displayed");
        assertTrue(homePage.example2ElementRendered().hiddenText().isDisplayed());
        assertEquals(homePage.example2ElementRendered().hiddenText().getText(), "Hello World!");
    }
}
