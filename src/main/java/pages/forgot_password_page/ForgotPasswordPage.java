package pages.forgot_password_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import components.base_components.InputComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class ForgotPasswordPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h2";
    protected final String FIELD_LABEL = ".//label[@for='email']";
    protected final String EMAIL_FIELD = ".//input[@id='email']";
    protected final String RETRIEVE_PASSWORD_BUTTON = ".//button[@id='form_submit']";
    protected final String BUTTON_NAME = ".//button[@id='form_submit']/i";

    public String getVerificationURL() {
        return "forgot_password";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent fieldLabel() {
        return new BaseComponent().init(By.xpath(FIELD_LABEL), this.webElement);
    }

    public InputComponent emailField() {
        return (InputComponent) new InputComponent().init(By.xpath(EMAIL_FIELD), this.webElement);
    }

    public ButtonComponent retrievePasswordButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(RETRIEVE_PASSWORD_BUTTON), this.webElement);
    }

    public BaseComponent buttonName() {
        return new BaseComponent().init(By.xpath(BUTTON_NAME), this.webElement);
    }
}
