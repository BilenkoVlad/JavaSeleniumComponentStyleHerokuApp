import org.testng.annotations.Test;
import pages.HomePage;
import utils.browsers.BrowserManager;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC008UserIsAbleToSelectValueFromDropdownListTest extends BaseClass {
    @Test
    public void UserIsAbleToSelectValueFromDropdownListTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Dropdown").click();
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");

        assertEquals(homePage.dropdownPage().headerPage().getText().trim(), "Dropdown List");
        assertTrue(homePage.dropdownPage().dropdown().isDisplayed(), "Dropdown is not displayed");
        assertEquals(homePage.dropdownPage().dropdown().getOptions(), expectedOptions);

        homePage.dropdownPage().dropdown().selectByVisibleText("Option 1");
        assertEquals(homePage.dropdownPage().dropdown().getFirstSelectedOption(), "Option 1");

        homePage.dropdownPage().dropdown().selectByVisibleText("Option 2");
        assertEquals(homePage.dropdownPage().dropdown().getFirstSelectedOption(), "Option 2");

        BrowserManager.refreshPage();

        assertEquals(homePage.dropdownPage().headerPage().getText().trim(), "Dropdown List");
        assertTrue(homePage.dropdownPage().dropdown().isDisplayed(), "Dropdown is not displayed");
        assertEquals(homePage.dropdownPage().dropdown().getOptions(), expectedOptions);
    }
}
