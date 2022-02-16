import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0017UserIsAbleToSeeAdditionalInformationAfterHoverTheMouseOntoAvatarTest extends BaseClass {
    @Test
    public void UserIsAbleToSeeAdditionalInformationAfterHoverTheMouseOntoAvatarTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("Hovers").click();

        List<String> avatarName = Arrays.asList("name: user1", "name: user2", "name: user3");

        assertEquals(homePage.hoversPage().headersPage().getText(), "Hovers");
        assertEquals(homePage.hoversPage().bodyText().getText(), "Hover over the image for additional information");

        for (int i = 0; i < homePage.hoversPage().avatarsList().size(); i++) {
            assertTrue(homePage.hoversPage().avatarsList().get(i).isDisplayed());
        }

        for (int i = 0; i < homePage.hoversPage().avatarsList().size(); i++) {
            homePage.hoversPage().avatarsList().get(i).moveToElement();
            assertTrue(homePage.hoversPage().avatarsNamesList().get(i).isDisplayed());
            assertTrue(homePage.hoversPage().avatarsLinksList().get(i).isDisplayed());
            assertEquals(homePage.hoversPage().avatarsNamesList().get(i).getText(), avatarName.get(i));
            assertEquals(homePage.hoversPage().avatarsLinksList().get(i).getText(), "View profile");
        }
    }
}
