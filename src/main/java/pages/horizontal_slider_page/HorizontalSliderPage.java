package pages.horizontal_slider_page;

import components.base_components.BaseComponent;
import components.base_components.InputComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class HorizontalSliderPage extends BasePage {
    protected final String HEADER_TEXT = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/h4";
    protected final String SLIDER = ".//input";
    protected final String RANGE_NUMBER = ".//span[@id='range']";

    public String getVerificationURL() {
        return "horizontal_slider";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADER_TEXT), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public InputComponent slider() {
        return (InputComponent) new InputComponent().init(By.xpath(SLIDER), this.webElement);
    }

    public BaseComponent rangeNumber() {
        return new BaseComponent().init(By.xpath(RANGE_NUMBER), this.webElement);
    }
}
