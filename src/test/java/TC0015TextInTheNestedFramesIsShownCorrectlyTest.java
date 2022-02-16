import org.testng.annotations.Test;
import pages.HomePage;
import utils.browsers.BrowserManager;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TC0015TextInTheNestedFramesIsShownCorrectlyTest extends BaseClass {
    @Test
    public void TextInTheNestedFramesIsShownCorrectlyTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Frames").click();
        List<String> linksNames = Arrays.asList("Nested Frames", "iFrame");

        assertEquals(homePage.framesPage().headersPage().getText(), "Frames");

        for (int i = 0; i < homePage.framesPage().items().size(); i++) {
            assertEquals(homePage.framesPage().items().keySet().toArray()[i], linksNames.get(i));
        }

        homePage.framesPage().items().get("Nested Frames").click();

        BrowserManager.switchToFrame(homePage.nestedFramesPage().middleFrameset().getWebElement());
        BrowserManager.switchToFrame(homePage.nestedFramesPage().leftFrame().getWebElement());
        assertEquals(homePage.nestedFramesPage().text().getText().trim(), "LEFT");
        BrowserManager.switchToDefaultContent();

        BrowserManager.switchToFrame(homePage.nestedFramesPage().middleFrameset().getWebElement());
        BrowserManager.switchToFrame(homePage.nestedFramesPage().middleFrame().getWebElement());
        assertEquals(homePage.nestedFramesPage().middleText().getText().trim(), "MIDDLE");
        BrowserManager.switchToDefaultContent();

        BrowserManager.switchToFrame(homePage.nestedFramesPage().middleFrameset().getWebElement());
        BrowserManager.switchToFrame(homePage.nestedFramesPage().rightFrame().getWebElement());
        assertEquals(homePage.nestedFramesPage().text().getText().trim(), "RIGHT");
        BrowserManager.switchToDefaultContent();

        BrowserManager.switchToFrame(homePage.nestedFramesPage().bottomFrame().getWebElement());
        assertEquals(homePage.nestedFramesPage().text().getText().trim(), "BOTTOM");
        BrowserManager.switchToDefaultContent();
    }
}
