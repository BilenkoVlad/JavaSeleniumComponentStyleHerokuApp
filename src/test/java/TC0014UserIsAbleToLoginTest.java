import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0014UserIsAbleToLoginTest extends BaseClass {

    @Test
    public void UserIsAbleToLoginTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Form Authentication").click();

        assertEquals(homePage.formAuthenticationPage().headersPage().getText(), "Login Page");
        assertEquals(homePage.formAuthenticationPage().bodyText().getText(), "This is where you can log into the secure area. Enter tomsmith" +
                " for the username and SuperSecretPassword! for the password. If the information is wrong you should " +
                "see error messages.");

        assertEquals(homePage.formAuthenticationPage().usernameLabel().getText(), "Username");
        assertTrue(homePage.formAuthenticationPage().usernameField().isDisplayed());
        assertTrue(homePage.formAuthenticationPage().usernameField().isEnabled());

        assertEquals(homePage.formAuthenticationPage().passwordLabel().getText(), "Password");
        assertTrue(homePage.formAuthenticationPage().passwordField().isDisplayed());
        assertTrue(homePage.formAuthenticationPage().passwordField().isEnabled());

        assertEquals(homePage.formAuthenticationPage().loginButtonLabel().getText().trim(), "Login");
        assertTrue(homePage.formAuthenticationPage().loginButton().isDisplayed());
        assertTrue(homePage.formAuthenticationPage().loginButton().isEnabled());

        homePage.formAuthenticationPage().usernameField().sendKeys("invalidUsername");
        homePage.formAuthenticationPage().passwordField().sendKeys("invalidPassword");

        homePage.formAuthenticationPage().loginButton().click();

        assertTrue(homePage.formAuthenticationPage().alert().isDisplayed());
        assertEquals(homePage.formAuthenticationPage().alert().message().getText().trim(), "Your username is invalid!\n×");

        homePage.formAuthenticationPage().usernameField().sendKeys(homePage.formAuthenticationPage().credentialsList().get(0).getText());
        homePage.formAuthenticationPage().passwordField().sendKeys(homePage.formAuthenticationPage().credentialsList().get(1).getText());

        homePage.formAuthenticationPage().loginButton().click();

        assertTrue(homePage.securePage().alert().message().isDisplayed());
        assertEquals(homePage.securePage().alert().message().getText().trim(), "You logged into a secure area!\n×");
        assertEquals(homePage.securePage().headersPage().getText().trim(), "Secure Area");
        assertEquals(homePage.securePage().bodyText().getText(), "Welcome to the Secure Area. When you are done click logout below.");

        assertEquals(homePage.securePage().logoutButtonLabel().getText().trim(), "Logout");
        assertTrue(homePage.securePage().logoutButton().isDisplayed());
        assertTrue(homePage.securePage().logoutButton().isEnabled());

        homePage.securePage().logoutButton().click();

        assertTrue(homePage.formAuthenticationPage().alert().message().isDisplayed());
        assertEquals(homePage.formAuthenticationPage().alert().message().getText().trim(), "You logged out of the secure area!\n×");
    }
}
