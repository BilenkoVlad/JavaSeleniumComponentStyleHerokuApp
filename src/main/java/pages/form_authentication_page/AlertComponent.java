package pages.form_authentication_page;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;

public class AlertComponent extends BaseComponent {
    protected final String MESSAGE = ".//div[@id='flash']";

    public BaseComponent message() {
        return new BaseComponent().init(By.xpath(MESSAGE), this.webElement);
    }
}
