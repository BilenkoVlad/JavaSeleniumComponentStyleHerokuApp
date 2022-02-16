package pages.inputs_page;

import components.base_components.BaseComponent;
import components.base_components.InputComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class InputsPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='large-6 small-12 columns large-centered']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String INPUT_FIELD = ".//input";

    @Override
    public String getVerificationURL() {
        return "inputs";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public InputComponent inputField() {
        return (InputComponent) new InputComponent().init(By.xpath(INPUT_FIELD), this.webElement);
    }
}
