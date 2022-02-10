import org.testng.annotations.Test;
import pages.HomePage;
import utils.Waiters;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TC006VerifyingThatHiddenItemCanBeShownAfterPollingThePageTest extends BaseClass {
    @Test
    public void VerifyingThatHiddenItemCanBeShownAfterPollingThePageTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Disappearing Elements").click();
        List<String> BUTTON_NAMES = Arrays.asList("Home", "About", "Contact Us", "Portfolio", "Gallery");

        assertEquals(homePage.disappearingElementsPage().headerPage().getText().trim(), "Disappearing Elements");
        assertEquals(homePage.disappearingElementsPage().bodyText().getText().trim(), "This example demonstrates when elements on a page change " +
                "by disappearing/reappearing on each page load.");

        for (int i = 0; i < homePage.disappearingElementsPage().buttonsList().size(); i++) {
            assertTrue(homePage.disappearingElementsPage().buttonsList().get(i).isDisplayed());
            assertEquals(homePage.disappearingElementsPage().buttonsList().get(i).getText(), BUTTON_NAMES.get(i));
        }

        assertTrue(Waiters.pollUntilCondition(() -> homePage.disappearingElementsPage().buttonsList().size() == 5, "Button is appeared"));
        assertTrue(homePage.disappearingElementsPage().hiddenButton().isDisplayed());
        assertTrue(Waiters.pollUntilCondition(() -> homePage.disappearingElementsPage().buttonsList().size() == 4, "Button is disappeared"));
    }
}
