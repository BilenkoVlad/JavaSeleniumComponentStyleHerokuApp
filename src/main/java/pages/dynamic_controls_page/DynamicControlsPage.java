package pages.dynamic_controls_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import components.base_components.CheckboxComponent;
import components.base_components.InputComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class DynamicControlsPage extends BasePage {
    protected final String HEADER_PAGE = ".//div[@class='example']/h4";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String REMOVE_BUTTON = ".//button[text()='Remove']";
    protected final String ADD_BUTTON = ".//button[text()='Add']";
    protected final String MESSAGE = ".//p[@id='message']";
    protected final String INPUT_LOADING = ".//form[@id='input-example']//div[@id='loading']";
    protected final String CHECKBOX_LOADING = ".//form[@id='checkbox-example']//div[@id='loading']";
    protected final String ENABLE_BUTTON = ".//button[text()='Enable']";
    protected final String DISABLE_BUTTON = ".//button[text()='Disable']";
    protected final String CHECKBOX = ".//input[@type='checkbox']";
    protected final String TEXT_FIELD = ".//input[@type='text']";

    public String getVerificationURL() {
        return "dynamic_controls";
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public ButtonComponent removeButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(REMOVE_BUTTON), this.webElement);
    }

    public ButtonComponent enableButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(ENABLE_BUTTON), this.webElement);
    }

    public ButtonComponent disableButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(DISABLE_BUTTON), this.webElement);
    }

    public ButtonComponent addButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(ADD_BUTTON), this.webElement);
    }

    public BaseComponent message() {
        return new BaseComponent().init(By.xpath(MESSAGE), this.webElement);
    }

    public CheckboxComponent checkbox() {
        return (CheckboxComponent) new CheckboxComponent().init(By.xpath(CHECKBOX), this.webElement);
    }

    public InputComponent textField() {
        return (InputComponent) new InputComponent().init(By.xpath(TEXT_FIELD), this.webElement);
    }

    public BaseComponent inputLoading() {
        return new BaseComponent().init(By.xpath(INPUT_LOADING), this.webElement);
    }

    public LinkedList<BaseComponent> headerPageList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(HEADER_PAGE), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }

    public LinkedList<BaseComponent> checkboxLoadingList() {
        LinkedList<BaseComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(CHECKBOX_LOADING), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add(new BaseComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
