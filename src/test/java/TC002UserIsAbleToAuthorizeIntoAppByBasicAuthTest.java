import org.testng.annotations.*;
import pages.HomePage;
import utils.settings.Settings;

import static org.testng.Assert.assertEquals;

public class TC002UserIsAbleToAuthorizeIntoAppByBasicAuthTest extends BaseClass {
    @Test
    public void basicAuthValidLogin() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Basic Auth").click();

        homePage.basicAuthPage().loginToPage("admin", "admin");
        assertEquals(homePage.authorizedPage().pageNameText().getText().trim(), "Basic Auth");
        assertEquals(homePage.authorizedPage().pageBodyText().getText().trim(), "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void basicAuthInvalidLogin() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Basic Auth").click();

        homePage.basicAuthPage().loginToPage("invalidAdmin", "invalidAdmin");
    }

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
}
