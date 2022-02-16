package pages.hovers_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class HoversPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String AVATARS = ".//div[@class='figure']";
    protected final String AVATARS_NAMES = ".//div[@class='figcaption']/h5";
    protected final String AVATARS_LINKS = ".//div[@class='figcaption']/a";

    public String getVerificationURL() {
        return "hovers";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public LinkedList<BaseComponent> avatarsList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(AVATARS), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }

    public LinkedList<BaseComponent> avatarsNamesList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(AVATARS_NAMES), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }

    public LinkedList<BaseComponent> avatarsLinksList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(AVATARS_LINKS), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }

}
