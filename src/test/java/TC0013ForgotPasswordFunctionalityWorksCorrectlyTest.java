import org.testng.annotations.Test;
import pages.HomePage;
import utils.generator.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0013ForgotPasswordFunctionalityWorksCorrectlyTest extends BaseClass {
    @Test
    public void ForgotPasswordFunctionalityWorksCorrectlyTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Forgot Password").click();

        String email = Generator.emailGenerator();

        assertEquals(homePage.forgotPasswordPage().headersPage().getText(), "Forgot Password");
        assertEquals(homePage.forgotPasswordPage().fieldLabel().getText(), "E-mail");
        assertTrue(homePage.forgotPasswordPage().emailField().isDisplayed());
        assertTrue(homePage.forgotPasswordPage().emailField().isEnabled());
        assertEquals(homePage.forgotPasswordPage().buttonName().getText(), "Retrieve password");
        assertTrue(homePage.forgotPasswordPage().retrievePasswordButton().isDisplayed());
        assertTrue(homePage.forgotPasswordPage().retrievePasswordButton().isEnabled());

        homePage.forgotPasswordPage().emailField().sendKeys(email);
        homePage.forgotPasswordPage().retrievePasswordButton().click();
    }
}
