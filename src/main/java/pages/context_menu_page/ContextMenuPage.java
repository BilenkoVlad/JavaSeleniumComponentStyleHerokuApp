package pages.context_menu_page;

import components.base_components.BaseComponent;
import components.base_components.CheckboxComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class ContextMenuPage extends BasePage {
    protected final String HEADER_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String CONTEXT_BOX = ".//div[@id='hot-spot']";

    public String getVerificationURL() {
        return "context_menu";
    }

    public BaseComponent headerPage() {
        return new BaseComponent().init(By.xpath(HEADER_PAGE), this.webElement);
    }

    public BaseComponent contextBox() {
        return new BaseComponent().init(By.xpath(CONTEXT_BOX), this.webElement);
    }

    public LinkedList<CheckboxComponent> bodyTextList() {
        LinkedList<CheckboxComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(BODY_TEXT), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add((CheckboxComponent) new CheckboxComponent().init(webElement, this.webElement));
        }
        return list;
    }

}
