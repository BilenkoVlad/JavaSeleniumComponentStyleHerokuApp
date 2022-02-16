package pages.key_presses_page;

import components.base_components.BaseComponent;
import components.base_components.InputComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class KeyPressesPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String INPUT_FIELD = ".//input[@id='target']";
    protected final String RESULT_TEXT = ".//p[@id='result']";

    @Override
    public String getVerificationURL() {
        return "key_presses";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public BaseComponent resultText() {
        return new BaseComponent().init(By.xpath(RESULT_TEXT), this.webElement);
    }

    public InputComponent inputField() {
        return (InputComponent) new InputComponent().init(By.xpath(INPUT_FIELD), this.webElement);
    }
}
