package pages.checkboxes_page;

import components.base_components.BaseComponent;
import components.base_components.CheckboxComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class CheckboxesPage extends BasePage {
    protected final String HEADER_PAGE = ".//div[@class='example']/h3";
    protected final String CHECKBOX = ".//input[@type='checkbox']";

    public String getVerificationURL() {
        return "checkboxes";
    }

    public BaseComponent headerPage() {
        return new BaseComponent().init(By.xpath(HEADER_PAGE), this.webElement);
    }

    public LinkedList<CheckboxComponent> checkboxList() {
        LinkedList<CheckboxComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(CHECKBOX), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add((CheckboxComponent) new CheckboxComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
