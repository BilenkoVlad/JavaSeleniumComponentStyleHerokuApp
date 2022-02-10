package utils.browsers;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import utils.logger.TAFLogger;
import utils.settings.Settings;

import java.io.File;

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
        String downloadDir = "";
        File dir = new File(downloadDir + "\\src\\main\\resources\\downloads");
        File[] dirContents = dir.listFiles();

        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                dirContent.delete();
                return true;
            }
        }
        return false;
    }

    public static void refreshPage() {
        getBrowser().getDriver().navigate().refresh();
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