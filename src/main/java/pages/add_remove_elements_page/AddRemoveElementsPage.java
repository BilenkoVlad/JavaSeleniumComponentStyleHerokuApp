package pages.add_remove_elements_page;

import components.base_components.ButtonComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Waiters;

import java.util.LinkedList;
import java.util.List;

public class AddRemoveElementsPage extends BasePage {
    protected final String ADD_BUTTON = ".//button[@onclick='addElement()']";
    protected final String DELETE_BUTTON = ".//button[@onclick='deleteElement()']";

    public String getVerificationURL() {
        return "add_remove_elements/";
    }

    protected void waitPageIsOpened() {
        String url = getVerificationURL();
        boolean result = Waiters.waitUntilCondition(() -> driver.getCurrentUrl().matches(baseUrl + this.getVerificationURL()),
                pageLoadTimeout,
                String.format("Page '%s%s' to be loaded", baseUrl, url));
        if (!result) {
            throw new RuntimeException(String.format("%s page is not loaded. \nExpected page URL: \n'%s'" +
                    "\nActual URL is: \n'%s'", this.getClass(), baseUrl + url, driver.getCurrentUrl()));
        }
    }

    public ButtonComponent addButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(ADD_BUTTON), this.webElement);
    }

    public ButtonComponent deleteButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(DELETE_BUTTON), this.webElement);
    }

    public LinkedList<ButtonComponent> deleteButtonsList() {
        LinkedList<ButtonComponent> list = new LinkedList<>();
        List<WebElement> webElements = Waiters.findElements(By.xpath(DELETE_BUTTON), this.webElement, this.timeout);
        for (WebElement webElement : webElements) {
            list.add((ButtonComponent) new ButtonComponent().init(webElement, this.webElement));
        }
        return list;
    }
}
