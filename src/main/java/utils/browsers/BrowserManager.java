package utils.browsers;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import utils.logger.TAFLogger;
import utils.settings.Settings;

import java.io.File;
import java.nio.file.Paths;

public class BrowserManager {
    protected static final Logger logger = TAFLogger.logger;
    private static BaseBrowser browser;
    private final Settings tafSetting = Settings.getTAFSettings();

    public static BaseBrowser getBrowser() {
        if (browser == null) {
            new BrowserManager().initDriver();
        }
        return browser;
    }

    public static void quitSession() {
        getBrowser().getDriver().quit();
        browser = null;
    }

    public static void closeBrowser() {
        getBrowser().getDriver().close();
    }

    public static boolean switchToTheTabByUrl(String url) {
        WebDriver driver = BrowserManager.getBrowser().getDriver();
        for (String tab : driver.getWindowHandles()) {
            if (driver.switchTo().window(tab).getCurrentUrl().equals(url))
                return true;
        }
        return false;
    }

    public static boolean isFileDownloaded(String fileName) {
        String downloadedFile = Paths.get("").toAbsolutePath() + String.format("\\src\\main\\resources\\downloads\\%s", fileName);
        File file = new File(downloadedFile);

        return file.getName().equals(fileName);
    }

    public static void refreshPage() {
        getBrowser().getDriver().navigate().refresh();
    }

    public static void navigateBackInPage() {
        getBrowser().getDriver().navigate().back();
    }

    public static void switchToFrame(WebElement webElement) {
        getBrowser().getDriver().switchTo().frame(webElement);
    }

    public static void switchToDefaultContent() {
        getBrowser().getDriver().switchTo().defaultContent();
    }

    public static boolean alertIsPresent() {
        try {
            getBrowser().getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static String alertText() {
        return getBrowser().getDriver().switchTo().alert().getText().trim();
    }

    public static void acceptAlert() {
        getBrowser().getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        getBrowser().getDriver().switchTo().alert().dismiss();
    }

    public static void sendKeysToAlert(String text) {
        getBrowser().getDriver().switchTo().alert().sendKeys(text);
    }

    public static boolean isElementPresent(By element) {
        try {
            getBrowser().getDriver().findElement(element);
            return true;
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    private void initDriver() {
        if (tafSetting.isChrome()) {
            browser = new ChromeBrowser();
        }
    }

    public File getScreenshot() {
        return ((TakesScreenshot) getBrowser().getDriver()).getScreenshotAs(OutputType.FILE);
    }
}