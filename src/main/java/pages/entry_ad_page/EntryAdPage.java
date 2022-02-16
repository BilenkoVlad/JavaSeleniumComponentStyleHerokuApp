package pages.entry_ad_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.entry_ad_page.modal_window.ModalWindow;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class EntryAdPage extends BasePage {
    protected final String MODAL_WINDOW = ".//div[@class='modal']";
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String CLICK_HERE = ".//a[@id='restart-ad']";

    public String getVerificationURL() {
        return "entry_ad";
    }

    public ModalWindow modalWindow() {
        return (ModalWindow) new ModalWindow().init(By.xpath(MODAL_WINDOW), this.webElement);
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent clickHereLink() {
        return new BaseComponent().init(By.xpath(CLICK_HERE), this.webElement);
    }

    public LinkedList<BaseComponent> bodyTextList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(BODY_TEXT), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
