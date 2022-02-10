package pages.disappearing_elements_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import components.base_components.CheckboxComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class DisappearingElementsPage extends BasePage {
    protected final String HEADER_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String BUTTON = ".//li/a";
    protected final String HIDDEN_BUTTON = ".//a[text()='Gallery']";

    public String getVerificationURL() {
        return "disappearing_elements";
    }

    public BaseComponent headerPage() {
        return new BaseComponent().init(By.xpath(HEADER_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public ButtonComponent hiddenButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(HIDDEN_BUTTON), this.webElement);
    }

    public LinkedList<CheckboxComponent> buttonsList() {
        LinkedList<CheckboxComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(BUTTON), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add((CheckboxComponent) new CheckboxComponent().init(webElement, this.webElement));
        }
        return list;
    }

}
