package pages.file_download_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class FileDownloadPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String FILES = ".//div[@class='example']/a";

    public String getVerificationURL() {
        return "download";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public LinkedList<BaseComponent> filesList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(FILES), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
