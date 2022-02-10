import org.testng.annotations.Test;
import pages.HomePage;
import utils.Waiters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC009UserIsAbleToEnableDisableInputFieldAndAddDeleteCheckboxTest extends BaseClass {
    @Test
    public void UserIsAbleToEnableDisableInputFieldAndAddDeleteCheckboxTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Dynamic Controls").click();

        assertEquals(homePage.dynamicControlsPage().headerPageList().get(0).getText().trim(), "Dynamic Controls");
        assertEquals(homePage.dynamicControlsPage().headerPageList().get(1).getText().trim(), "Remove/add");
        assertEquals(homePage.dynamicControlsPage().headerPageList().get(2).getText().trim(), "Enable/disable");
        assertEquals(homePage.dynamicControlsPage().bodyText().getText().trim(), "This example demonstrates when elements " +
                "(e.g., checkbox, input field, etc.) are changed asynchronously.");
        assertTrue(homePage.dynamicControlsPage().checkbox().isUnselected());
        assertTrue(homePage.dynamicControlsPage().removeButton().isEnabled() && homePage.dynamicControlsPage().removeButton().isDisplayed());
        assertTrue(homePage.dynamicControlsPage().enableButton().isEnabled() && homePage.dynamicControlsPage().enableButton().isDisplayed());
        assertTrue(homePage.dynamicControlsPage().textField().isDisabled());

        homePage.dynamicControlsPage().checkbox().click();
        assertTrue(homePage.dynamicControlsPage().checkbox().isSelected());

        homePage.dynamicControlsPage().removeButton().click();
        assertTrue(homePage.dynamicControlsPage().checkboxLoadingList().get(0).isDisplayed());
        assertTrue(Waiters.waitUntilCondition(() -> homePage.dynamicControlsPage().message().isDisplayed(), 5, "Message is shown"));
        assertEquals(homePage.dynamicControlsPage().message().getText().trim(), "It's gone!");
        assertTrue(homePage.dynamicControlsPage().checkbox().isNotDisplayed());
        assertTrue(homePage.dynamicControlsPage().addButton().isEnabled() && homePage.dynamicControlsPage().addButton().isDisplayed());

        homePage.dynamicControlsPage().addButton().click();
        assertTrue(homePage.dynamicControlsPage().checkboxLoadingList().get(0).isDisplayed());
        assertTrue(Waiters.waitUntilCondition(() -> homePage.dynamicControlsPage().message().isDisplayed(), 5, "Message is shown"));
        assertEquals(homePage.dynamicControlsPage().message().getText().trim(), "It's back!");
        assertTrue(homePage.dynamicControlsPage().checkbox().isDisplayed());
        assertTrue(homePage.dynamicControlsPage().checkbox().isUnselected());

        homePage.dynamicControlsPage().enableButton().click();
        assertTrue(homePage.dynamicControlsPage().inputLoading().isDisplayed());
        assertTrue(Waiters.waitUntilCondition(() -> homePage.dynamicControlsPage().message().isDisplayed(), 5, "Message is shown"));
        assertEquals(homePage.dynamicControlsPage().message().getText().trim(), "It's enabled!");
        assertTrue(homePage.dynamicControlsPage().textField().isEnabled());
        assertTrue((homePage.dynamicControlsPage().disableButton().isEnabled() && (homePage.dynamicControlsPage().disableButton().isDisplayed())));

        homePage.dynamicControlsPage().textField().sendKeys("Test text is automatically added");
        homePage.dynamicControlsPage().disableButton().click();
        assertTrue(homePage.dynamicControlsPage().inputLoading().isDisplayed());
        assertTrue(Waiters.waitUntilCondition(() -> homePage.dynamicControlsPage().message().isDisplayed(), 5, "Message is shown"));
        assertEquals(homePage.dynamicControlsPage().message().getText().trim(), "It's disabled!");
        assertTrue(homePage.dynamicControlsPage().textField().isDisabled());
        assertTrue(homePage.dynamicControlsPage().enableButton().isEnabled() && homePage.dynamicControlsPage().enableButton().isDisplayed());
        assertEquals(homePage.dynamicControlsPage().textField().getValue().trim().replaceAll("\uE000", ""), "Test text is automatically added");
    }
}
