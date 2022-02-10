package utils.java_script_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utils.browsers.BrowserManager;
import utils.logger.TAFLogger;
import utils.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class JSExecutor {
    protected static final Logger logger = TAFLogger.logger;
    protected static HashMap<String, String> scriptsCache = new HashMap<>();

    private static String parseJSCommandFile(String scriptFileName) {
        String currentDir = Settings.getTAFSettings().getCurrentWorkDirectory();
        String fullScriptPath = String.format(currentDir + "/src/main/java/utils/java_script_executor/js_commands/%s", scriptFileName);
        try {
            return new String(Files.readAllBytes(Paths.get(fullScriptPath)));
        } catch (IOException e) {
            logger.error("Cannot parse JSON commands file '" + fullScriptPath + "'");
        }
        return "";
    }

    private static Object executeJSScript(String scriptFileName, Object... args) {
        String jsCommand;
        if (scriptsCache.containsKey(scriptFileName)) {
            logger.debug(String.format("Found script '%s' in cache, using cache data", scriptFileName));
            jsCommand = scriptsCache.get(scriptFileName);
        } else {
            jsCommand = parseJSCommandFile(scriptFileName);
            scriptsCache.put(scriptFileName, jsCommand);
        }

        WebDriver driver = BrowserManager.getBrowser().getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        return js.executeScript(jsCommand, args);
    }

    public static void scrollTo(WebElement webElement) {
        executeJSScript("scroll_to_element.js", webElement);
    }

    public static String documentReady() {
        String result = (String) executeJSScript("document_ready.js");
        logger.debug(String.format("Document ready status is '%s'", result));
        return result;
    }

    public static Long jQueryActive() {
        Long result = (Long) executeJSScript("jquery_active.js");
        logger.debug(String.format("Document ready status is '%s'", result));
        return result;
    }

    public static void setLocalStorageData(String key, Object value) {
        executeJSScript("set_local_storage_data.js", key, value);
    }

    public static void setVideosCache() {
        setLocalStorageData("videos", "Object");
    }

    public static void clearInput(WebElement webElement) {
        executeJSScript("clear_input.js", webElement);
    }

    public static Object click(WebElement webElement) {
        return executeJSScript("click.js", webElement);
    }

    public static String getCssContent(WebElement webElement, String nodeName) {
        return (String) executeJSScript("get_css_content.js", webElement, nodeName);
    }

    public static void setAttribute(WebElement webElement, String attribute, String value) {
        executeJSScript("set_attribute.js", webElement, attribute, value);
    }
}
