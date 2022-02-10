import org.testng.annotations.Test;
import pages.HomePage;
import utils.browsers.BrowserManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC004UserIsAbleToCheckAndUncheckCheckboxesTest extends BaseClass {
    @Test
    public void UserIsAbleToCheckAndUncheckCheckboxesTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Checkboxes").click();

        assertEquals(homePage.checkboxesPage().headerPage().getText().trim(), "Checkboxes");
        assertTrue(homePage.checkboxesPage().checkboxList().get(0).isUnselected());
        assertTrue(homePage.checkboxesPage().checkboxList().get(1).isSelected());

        homePage.checkboxesPage().checkboxList().get(0).click();
        assertTrue(homePage.checkboxesPage().checkboxList().get(0).isSelected());

        for (int i = 0; i < homePage.checkboxesPage().checkboxList().size(); i++) {
            homePage.checkboxesPage().checkboxList().get(i).click();
            assertTrue(homePage.checkboxesPage().checkboxList().get(i).isUnselected());
        }

        homePage.checkboxesPage().checkboxList().get(0).click();
        assertTrue(homePage.checkboxesPage().checkboxList().get(0).isSelected());

        BrowserManager.refreshPage();

        assertEquals(homePage.checkboxesPage().headerPage().getText().trim(), "Checkboxes");
        assertTrue(homePage.checkboxesPage().checkboxList().get(0).isUnselected());
        assertTrue(homePage.checkboxesPage().checkboxList().get(1).isSelected());
    }
}
