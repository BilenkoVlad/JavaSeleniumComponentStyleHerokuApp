package pages.form_authentication_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import components.base_components.InputComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class FormAuthenticationPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h2";
    protected final String BODY_TEXT = ".//div[@class='example']/h4";
    protected final String CREDENTIALS = ".//div[@class='example']/h4/em";
    protected final String USERNAME_LABEL = ".//label[@for='username']";
    protected final String USERNAME_FIELD = ".//input[@name='username']";
    protected final String PASSWORD_LABEL = ".//label[@for='password']";
    protected final String PASSWORD_FIELD = ".//input[@name='password']";
    protected final String LOGIN_BUTTON = ".//button";
    protected final String LOGIN_BUTTON_LABEL = ".//button/i";
    protected final String ALERT = ".//div[@id='flash-messages']";

    public String getVerificationURL() {
        return "login";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public BaseComponent usernameLabel() {
        return new BaseComponent().init(By.xpath(USERNAME_LABEL), this.webElement);
    }

    public InputComponent usernameField() {
        return (InputComponent) new InputComponent().init(By.xpath(USERNAME_FIELD), this.webElement);
    }

    public BaseComponent passwordLabel() {
        return new BaseComponent().init(By.xpath(PASSWORD_LABEL), this.webElement);
    }

    public InputComponent passwordField() {
        return (InputComponent) new InputComponent().init(By.xpath(PASSWORD_FIELD), this.webElement);
    }

    public ButtonComponent loginButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(LOGIN_BUTTON), this.webElement);
    }

    public BaseComponent loginButtonLabel() {
        return new BaseComponent().init(By.xpath(LOGIN_BUTTON_LABEL), this.webElement);
    }

    public AlertComponent alert() {
        return (AlertComponent) new AlertComponent().init(By.xpath(ALERT), this.webElement);
    }

    public LinkedList<BaseComponent> credentialsList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(CREDENTIALS), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
