import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utils.settings.Settings;

public class BaseClass {
    @BeforeTest
    public void browserInitialize() {
        HomePage.initSite(Settings.getTAFSettings().getEnvURL());
    }

    @AfterTest
    public void browserFinalization() {
        HomePage.resetSite();
    }
}
