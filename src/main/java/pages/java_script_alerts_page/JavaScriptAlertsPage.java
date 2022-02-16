package pages.java_script_alerts_page;

import components.base_components.BaseComponent;
import components.base_components.ButtonComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class JavaScriptAlertsPage extends BasePage {
    protected final String HEADERS_PAGE = ".//div[@class='example']/h3";
    protected final String BODY_TEXT = ".//div[@class='example']/p";
    protected final String RESULT_TEXT = ".//div[@class='example']/h4";
    protected final String RESULT_MESSAGE = ".//p[@id='result']";
    protected final String JS_BUTTONS = ".//button";
    protected final String JS_ALERT = ".//button[@onclick='jsAlert()']";
    protected final String JS_CONFIRM = ".//button[@onclick='jsConfirm()']";
    protected final String JS_PROMPT = ".//button[@onclick='jsPrompt()']";

    @Override
    public String getVerificationURL() {
        return "javascript_alerts";
    }

    public BaseComponent headersPage() {
        return new BaseComponent().init(By.xpath(HEADERS_PAGE), this.webElement);
    }

    public BaseComponent bodyText() {
        return new BaseComponent().init(By.xpath(BODY_TEXT), this.webElement);
    }

    public BaseComponent resultText() {
        return new BaseComponent().init(By.xpath(RESULT_TEXT), this.webElement);
    }

    public BaseComponent resultMessage() {
        return new BaseComponent().init(By.xpath(RESULT_MESSAGE), this.webElement);
    }

    public ButtonComponent jsAlert() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(JS_ALERT), this.webElement);
    }

    public ButtonComponent jsConfirm() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(JS_CONFIRM), this.webElement);
    }

    public ButtonComponent jsPrompt() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(JS_PROMPT), this.webElement);
    }

    public LinkedList<ButtonComponent> jsButtonsList() {
        LinkedList<ButtonComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(JS_BUTTONS), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add((ButtonComponent) new ButtonComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
