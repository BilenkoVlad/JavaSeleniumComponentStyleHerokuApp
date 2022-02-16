package pages.dynamic_loading_page.example1_hidden_elements_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class Example1HiddenElementsPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/h4";
    protected final String START_BUTTON = ".//div[@id='start']/button";
    protected final String LOADER = ".//div[@id='loading']";
    protected final String HIDDEN_TEXT = ".//div[@id='finish']/h4";

    public String getVerificationURL() {
        return "dynamic_loading/1";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public ButtonComponent startButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(START_BUTTON), this.webElement);
    }

    public BaseComponent loader() {
        return new BaseComponent().init(By.xpath(LOADER), this.webElement);
    }

    public BaseComponent hiddenText() {
        return new BaseComponent().init(By.xpath(HIDDEN_TEXT), this.webElement);
    }
}
