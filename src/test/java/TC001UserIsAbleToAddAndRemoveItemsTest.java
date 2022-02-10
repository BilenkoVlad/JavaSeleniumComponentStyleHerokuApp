import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC001UserIsAbleToAddAndRemoveItemsTest extends BaseClass {
    @Test
    public void UserIsAbleToAddAndRemoveItemsTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Add/Remove Elements").click();

        homePage.addRemoveElementsPage().addButton().click();
        assertTrue(homePage.addRemoveElementsPage().deleteButton().isDisplayed(), "Delete button is not displayed");

        homePage.addRemoveElementsPage().deleteButton().click();
        assertTrue(homePage.addRemoveElementsPage().deleteButton().isNotDisplayed(0), "Delete button is displayed");

        for (int i = 0; i < 10; i++) {
            homePage.addRemoveElementsPage().addButton().click();
            assertTrue(homePage.addRemoveElementsPage().deleteButtonsList().get(i).isDisplayed(), "Delete button is not displayed");
        }
        assertEquals(homePage.addRemoveElementsPage().deleteButtonsList().size(), 10);

        for (int i = homePage.addRemoveElementsPage().deleteButtonsList().size() - 1; i >= 0; i--) {
            homePage.addRemoveElementsPage().deleteButtonsList().get(i).click();
        }
        assertEquals(homePage.addRemoveElementsPage().deleteButtonsList().size(), 0);
    }
}
