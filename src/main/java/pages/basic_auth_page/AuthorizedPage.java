package pages.basic_auth_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.Waiters;

public class AuthorizedPage extends BasePage {
    protected final String PAGE_NAME_TEXT = ".//div[@class='example']/h3";
    protected final String PAGE_BODY_TEXT = ".//div[@class='example']/p";

    public String getVerificationURL() {
        return "https://admin:admin@the-internet.herokuapp.com/basic_auth";
    }

    @Override
    protected void waitPageIsOpened() {
        String url = getVerificationURL();
        boolean result = Waiters.waitUntilCondition(() -> driver.getCurrentUrl().equals(url),
                pageLoadTimeout,
                String.format("Page '%s%s' to be loaded", baseUrl, url));
        if (!result) {
            throw new RuntimeException(String.format("%s page is not loaded. \nExpected page URL: \n'%s'" +
                    "\nActual URL is: \n'%s'", this.getClass(), url, driver.getCurrentUrl()));
        }
    }

    public BaseComponent pageNameText() {
        return new BaseComponent().init(By.xpath(PAGE_NAME_TEXT), this.webElement);
    }

    public BaseComponent pageBodyText() {
        return new BaseComponent().init(By.xpath(PAGE_BODY_TEXT), this.webElement);
    }
}
