import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0018UserIsAbleToEnterNumberInTheFieldTest extends BaseClass {
    @Test
    public void UserIsAbleToEnterNumberInTheFieldViaKeyboard() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Inputs").click();

        assertEquals(homePage.inputsPage().headersPage().getText(), "Inputs");
        assertEquals(homePage.inputsPage().bodyText().getText(), "Number");
        assertEquals(homePage.inputsPage().inputField().getAttribute("type"), "number");
        assertTrue(homePage.inputsPage().inputField().isDisplayed());
        assertTrue(homePage.inputsPage().inputField().isEnabled());

        homePage.inputsPage().inputField().sendKeys("any test chars");
        homePage.inputsPage().inputField().sendKeys("eee");
        homePage.inputsPage().inputField().clear();
        homePage.inputsPage().inputField().sendKeys("123");
        homePage.inputsPage().inputField().clear();
        homePage.inputsPage().inputField().sendKeys("4561e4641");
        homePage.inputsPage().inputField().clear();

        homePage.inputsPage().inputField().click();

        for (int i = 0; i < 50; i++) {
            homePage.inputsPage().inputField().sendKeysWithoutClick(Keys.ARROW_UP);
        }

        homePage.inputsPage().inputField().clear();

        for (int i = 0; i < 50; i++) {
            homePage.inputsPage().inputField().sendKeysWithoutClick(Keys.ARROW_DOWN);
        }
    }
}
