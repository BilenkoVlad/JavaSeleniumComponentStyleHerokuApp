package pages.dropdown_page;

import components.base_components.BaseComponent;
import components.base_components.SelectComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class DropdownPage extends BasePage {
    protected final String HEADER_PAGE = ".//div[@class='example']/h3";
    protected final String DROPDOWN = ".//select[@id='dropdown']";

    public String getVerificationURL() {
        return "dropdown";
    }

    public BaseComponent headerPage() {
        return new BaseComponent().init(By.xpath(HEADER_PAGE), this.webElement);
    }

    public SelectComponent dropdown() {
        return (SelectComponent) new SelectComponent().init(By.xpath(DROPDOWN), this.webElement);
    }
}
