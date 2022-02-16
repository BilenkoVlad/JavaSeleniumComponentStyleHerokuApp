package pages.entry_ad_page.modal_window;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import org.openqa.selenium.By;

public class ModalWindow extends BaseComponent {
    protected final String TITLE = ".//div[@class='modal-title']/h3";
    protected final String TEXT = ".//div[@class='modal-body']/p";
    protected final String CLOSE_BUTTON = ".//div[@class='modal-footer']/p";

    public BaseComponent title() {
        return new BaseComponent().init(By.xpath(TITLE), this.webElement);
    }

    public BaseComponent text() {
        return new BaseComponent().init(By.xpath(TEXT), this.webElement);
    }

    public ButtonComponent closeButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(CLOSE_BUTTON), this.webElement);
    }
}
