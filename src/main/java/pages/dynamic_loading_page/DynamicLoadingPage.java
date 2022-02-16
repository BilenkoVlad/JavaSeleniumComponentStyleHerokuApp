package pages.dynamic_loading_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class DynamicLoadingPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String BODY_LINKS = ".//div[@class='example']/a";

    public String getVerificationURL() {
        return "dynamic_loading";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public LinkedList<BaseComponent> bodyTextList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(BODY_TEXT), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }

    public LinkedList<BaseComponent> bodyLinksList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(BODY_LINKS), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
