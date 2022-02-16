package pages.frames_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedHashMap;
import java.util.List;

public class FramesPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String LINKS = ".//div[@class='example']/ul/li/a";

    public String getVerificationURL() {
        return "frames";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public LinkedHashMap<String, BaseComponent> items() {
        LinkedHashMap<String, BaseComponent> items = new LinkedHashMap<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(LINKS), this.webElement, timeout);
        for (WebElement we : webElements) {
            BaseComponent item = new BaseComponent().init(we, this.webElement);
            items.put(item.getText(), item);
        }
        return items;
    }
}
