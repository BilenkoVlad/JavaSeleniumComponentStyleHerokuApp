import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0021CorrectInformationAboutPressedKeyInKeyboardIsShownOnThePageTest extends BaseClass {
    @Test
    public void CorrectInformationAboutPressedKeyInKeyboardIsShownOnThePageTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Key Presses").click();


        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.ARROW_UP);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: UP");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.ARROW_DOWN);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: DOWN");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.ARROW_LEFT);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: LEFT");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.ARROW_RIGHT);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: RIGHT");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.CONTROL);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: CONTROL");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.SHIFT);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: SHIFT");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.TAB);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: TAB");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(Keys.ESCAPE);
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: ESCAPE");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick("a");
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: A");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick("q");
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: Q");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick("c");
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: C");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick(",");
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: COMMA");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick("/");
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: SLASH");

        homePage.keyPressesPage().inputField().sendKeysWithoutClick("[");
        assertTrue(homePage.keyPressesPage().resultText().isDisplayed());
        assertEquals(homePage.keyPressesPage().resultText().getText(), "You entered: OPEN_BRACKET");
    }
}
