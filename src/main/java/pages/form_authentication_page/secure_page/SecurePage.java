package pages.form_authentication_page.secure_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.form_authentication_page.AlertComponent;

public class SecurePage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h2";
    protected final String BODY_TEXT = ".//div[@class='example']/h4";
    protected final String ALERT = ".//div[@id='flash-messages']";
    protected final String LOGOUT_BUTTON = ".//a[@class='button secondary radius']";
    protected final String LOGOUT_BUTTON_LABEL = ".//a[@class='button secondary radius']/i";

    public String getVerificationURL() {
        return "secure";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public AlertComponent alert() {
        return (AlertComponent) new AlertComponent().init(By.xpath(ALERT), this.webElement);
    }

    public ButtonComponent logoutButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(LOGOUT_BUTTON), this.webElement);
    }

    public BaseComponent logoutButtonLabel() {
        return new BaseComponent().init(By.xpath(LOGOUT_BUTTON_LABEL), this.webElement);
    }
}
