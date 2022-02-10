package utils.settings;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import utils.logger.TAFLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {
    protected static final Logger logger = TAFLogger.logger;
    private static Settings tafSettings;
    private String browser = null;
    private String envType = null;
    private String envURL;

    public Settings() {
        Properties property = getSettingReader();
        JSONObject settingsJSON = parseSettingsJSON();

        if (this.browser == null)
            this.browser = property.getProperty("browser", "");
        if (this.envType == null)
            this.envType = property.getProperty("env", "");
        if (this.envType != null) {
            this.envURL = (String) settingsJSON.get(this.envType);
        }
    }

    public static Settings getTAFSettings() {
        if (tafSettings == null) {
            tafSettings = new Settings();
        }
        return tafSettings;
    }

    private Properties getSettingReader() {
        FileInputStream propertyFile;
        Properties property = new Properties();
        try {
            String filePath = getFilePropertyPath();
            propertyFile = new FileInputStream(filePath);
            property.load(propertyFile);
        } catch (IOException e) {
            logger.error("Cannot read property file");
        }

        return property;
    }

    public JSONObject parseSettingsJSON() {

        try {
            String jsonFile = "src/main/java/utils/settings/settings.json";
            InputStream is = new FileInputStream(jsonFile);
            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
            return new JSONObject(jsonTxt);
        } catch (IOException e) {
            logger.error("Cannot read setting JSON file");
        }
        return null;
    }

    public String getCurrentWorkDirectory() {
        String currentPath = Paths.get("").toAbsolutePath().toString();
        String[] tokens = null;
        if (currentPath.contains("/")) {
            tokens = currentPath.split("/");
        } else {
            tokens = currentPath.split("\\\\");
        }
        StringBuilder currentDir = new StringBuilder();
        for (String token : tokens) {
            currentDir.append(token).append("/");
            if (token.equals("JavaSeleniumComponentStyleHerokuApp")) {
                break;
            }
        }
        return currentDir.toString();
    }

    public String getEnvType() {
        return this.envType;
    }

    public String getEnvURL() {
        return this.envURL;
    }

    private String getFilePropertyPath() {
        String localPropertyFile = "src/main/resources/env_local.properties";
        File localFile = new File(localPropertyFile);

        String propertyFile = "src/main/resources/env.properties";
        return localFile.exists() ? localPropertyFile : propertyFile;
    }

    public String getBrowser() {
        return this.browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public boolean isChrome() {
        return this.browser.equals("chrome");
    }
}
