package pages;

import components.base_components.BaseComponent;
import utils.Waiters;
import utils.settings.Settings;

public abstract class BasePage extends BaseComponent {
    protected final int pageLoadTimeout = 10;
    private final Settings tafSetting = Settings.getTAFSettings();
    protected final String baseUrl = tafSetting.getEnvURL();

    public BasePage() {
        this.waitPageIsOpened();
    }

    public String getVerificationURL() {
        return "";
    }

    protected void waitPageIsOpened() {
        String url = getVerificationURL();
        boolean result = Waiters.waitUntilCondition(() -> driver.getCurrentUrl().equals(baseUrl + url),
                pageLoadTimeout,
                String.format("Page '%s%s' to be loaded", baseUrl, url));
        if (!result) {
            throw new RuntimeException(String.format("%s page is not loaded. \nExpected page URL: \n'%s'" +
                    "\nActual URL is: \n'%s'", this.getClass(), baseUrl + url, driver.getCurrentUrl()));
        }
    }

    @Override
    public void scrollTo() {
    }
}
