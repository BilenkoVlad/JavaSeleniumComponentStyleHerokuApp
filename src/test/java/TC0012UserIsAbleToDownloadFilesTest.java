import org.testng.annotations.Test;
import pages.HomePage;
import utils.browsers.BrowserManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC0012UserIsAbleToDownloadFilesTest extends BaseClass {
    @Test
    public void UserIsAbleToDownloadFilesTest() {
        HomePage homePage = HomePage.getSiteInstance();
        homePage.linkToPages("File Download").click();

        assertEquals(homePage.fileDownloadPage().headersPage().getText(), "File Downloader");
        for (int i = 0; i < homePage.fileDownloadPage().filesList().size(); i++) {
            assertEquals(homePage.fileDownloadPage().filesList().get(i).getTagName(), "a");
            assertTrue(homePage.fileDownloadPage().filesList().get(i).isDisplayed());
        }
        for (int i = 0; i < homePage.fileDownloadPage().filesList().size(); i++) {
            homePage.fileDownloadPage().filesList().get(i).click();
            assertTrue(BrowserManager.isFileDownloaded(homePage.fileDownloadPage().filesList().get(i).getText()));
        }
    }
}
