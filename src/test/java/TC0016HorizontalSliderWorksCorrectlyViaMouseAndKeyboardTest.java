import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import pages.HomePage;
import utils.settings.Settings;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0016HorizontalSliderWorksCorrectlyViaMouseAndKeyboardTest extends BaseClass {
    @BeforeTest
    @BeforeMethod
    public void browserInitialize() {
        HomePage.initSite(Settings.getTAFSettings().getEnvURL());
    }

    @AfterTest
    @AfterMethod
    public void browserFinalization() {
        HomePage.resetSite();
    }

    @Test
    public void HorizontalSliderWorksCorrectlyViaMouseTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Horizontal Slider").click();

        assertEquals(homePage.horizontalSliderPage().headersPage().getText(), "Horizontal Slider");
        assertEquals(homePage.horizontalSliderPage().bodyText().getText(), "Set the focus on the slider (by clicking on it) and use the" +
                " arrow keys to move it right and left. Or click and drag the slider with your mouse. It will " +
                "indicate the value of the slider to the right.");
        assertTrue(homePage.horizontalSliderPage().slider().isDisplayed());
        assertTrue(homePage.horizontalSliderPage().slider().isEnabled());
        assertEquals(homePage.horizontalSliderPage().rangeNumber().getText(), "0");

        homePage.horizontalSliderPage().slider().moveSliderUpByMouse();
        homePage.horizontalSliderPage().slider().moveSliderDownByMouse();
    }

    @Test
    public void HorizontalSliderWorksCorrectlyViaKeyboardTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Horizontal Slider").click();

        assertEquals(homePage.horizontalSliderPage().headersPage().getText(), "Horizontal Slider");
        assertEquals(homePage.horizontalSliderPage().bodyText().getText(), "Set the focus on the slider (by clicking on it) and use the" +
                " arrow keys to move it right and left. Or click and drag the slider with your mouse. It will " +
                "indicate the value of the slider to the right.");
        assertTrue(homePage.horizontalSliderPage().slider().isDisplayed());
        assertTrue(homePage.horizontalSliderPage().slider().isEnabled());
        assertEquals(homePage.horizontalSliderPage().rangeNumber().getText(), "0");

        for (int i = 0; i < 50; i = i + 5) {
            homePage.horizontalSliderPage().slider().moveToElement(-25, 0);
            homePage.horizontalSliderPage().slider().sendKeys(Keys.ARROW_UP);
        }

        for (int i = 50; i > 0; i = i - 5) {
            homePage.horizontalSliderPage().slider().moveToElement(-25, 0);
            homePage.horizontalSliderPage().slider().sendKeys(Keys.ARROW_DOWN);
        }
    }
}
