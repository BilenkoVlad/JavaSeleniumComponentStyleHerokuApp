package components.base_components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import utils.Waiters;
import utils.browsers.BrowserManager;
import utils.java_script_executor.JSExecutor;
import utils.logger.TAFLogger;

import static utils.Waiters.findElement;
import static utils.Waiters.waitUntilCondition;

public class BaseComponent {
    protected static final Logger logger = TAFLogger.logger;
    protected final int period = Waiters.period;
    protected final int timeout = Waiters.timeout;
    protected WebDriver driver = BrowserManager.getBrowser().getDriver();
    protected WebElement webElement;
    protected By by;
    protected SearchContext context;
    protected Actions actions;

    public BaseComponent init(By by, SearchContext context, int timeout, int period) {
        this.by = by;
        this.context = context;
        this.webElement = findElement(by, context, timeout, period);
        if (this.webElement == null) {
            return this;
        }
        waitIsLoaded(timeout);
        scrollTo();

        return this;
    }

    public BaseComponent init(By by) {
        return init(by, driver, timeout, period);
    }

    public BaseComponent init(By by, int timeout) {
        return init(by, driver, timeout, period);
    }

    public BaseComponent init(By by, int timeout, int period) {
        return init(by, driver, timeout, period);
    }

    public BaseComponent init(By by, SearchContext context, int timeout) {
        return init(by, context, timeout, period);
    }

    public BaseComponent init(By by, SearchContext context) {
        return init(by, context, timeout, period);
    }

    public BaseComponent init(WebElement webElement, SearchContext context) {
        this.webElement = webElement;
        this.context = context;
        scrollTo();
        waitIsLoaded();

        return this;
    }

    public BaseComponent reInit() {
        this.webElement = findElement(by, context, timeout, period);

        return this;
    }

    public void waitIsLoaded() {
    }

    public void waitIsLoaded(int timeout) {
    }

    public void scrollTo() {
        logger.debug(String.format("Scrolling to component '%s'", this.getClass()));
        JSExecutor.scrollTo(this.webElement);
    }

    public String getText() {
        String text = webElement.getText();
        logger.debug(String.format("Web element text is '%s'", text));
        return text;
    }

    public String getNonEmptyText(int timeout, int period) {
        waitUntilCondition(
                () -> !webElement.getText().isEmpty(),
                timeout,
                period,
                String.format("Component '%s' text to be not empty", this.getClass()));
        return webElement.getText();
    }

    public String getNonEmptyText(int timeout) {
        return getNonEmptyText(timeout, period);
    }

    public String getNonEmptyText() {
        return getNonEmptyText(timeout, period);
    }

    public void click() {
        logger.info(String.format("Click on component '%s'", this.getClass()));
        webElement.click();
    }

    public void rightClick() {
        logger.info(String.format("Right click on component '%s'", this.getClass()));
        actions = new Actions(driver);
        actions.contextClick(webElement).perform();
    }

    public void moveToElement(int xOffset, int yOffset) {
        actions = new Actions(driver);
        actions.moveToElement(this.webElement, xOffset, yOffset);
    }

    public void moveToElement() {
        actions = new Actions(driver);
        actions.moveToElement(this.webElement).build().perform();
    }

    public void moveByOffset(int xOffset, int yOffset) {
        actions = new Actions(driver);
        actions.moveByOffset(xOffset, yOffset).click().build().perform();
    }

    public void moveSliderUpByMouse() {
        actions = new Actions(driver);
        for (int i = -25; i <= 30; i = i + 5) {
            actions.moveToElement(this.webElement, i, 0);
            actions.moveByOffset(i, 0).click().build().perform();
        }
    }

    public void moveSliderDownByMouse() {
        actions = new Actions(driver);
        for (int i = 25; i >= -30; i = i - 5) {
            actions.moveToElement(this.webElement, i, 0);
            actions.moveByOffset(i, 0).click().build().perform();
        }
    }

    public boolean isDisplayed(int timeout) {
        boolean status = this.webElement != null && Waiters.waitUntilCondition(() -> webElement.isDisplayed(),
                timeout,
                String.format("Component's '%s' display status to be true", this.getClass()));
        logger.info(String.format("Component's '%s' display status is '%s'", this.getClass(), status));
        return status;
    }

    public boolean isDisplayed() {
        return this.isDisplayed(this.timeout);
    }

    public boolean isNotDisplayed(int timeout) {
        Waiters.waitUntilCondition(() -> !this.reInit().isDisplayed(0),
                timeout,
                String.format("Component's '%s' display status to be false", this.getClass()));
        boolean status = this.reInit().isDisplayed(0);
        return !status;
    }

    public boolean isNotDisplayed() {
        return this.isNotDisplayed(this.timeout);
    }

    public String getAttribute(String attribute) {
        String value = this.webElement.getAttribute(attribute);
        logger.debug(String.format("Web element '%s' attribute '%s' has value '%s'",
                this.getClass(), attribute, value));
        return value;
    }

    public String getTagName() {
        String value = this.webElement.getTagName();
        logger.debug(String.format("Web element tag '%s' has value '%s'", this.getClass(), value));
        return value;
    }

    public String getCssValue(String attribute) {
        String value = this.webElement.getCssValue(attribute);
        logger.debug(String.format("Web element '%s' CSS attribute '%s' has value '%s'",
                this.getClass(), attribute, value));
        return value;
    }

    public Dimension getSize() {
        Dimension size = this.webElement.getSize();
        logger.debug(String.format("Web element '%s' size is '%s'", this.getClass(), size.toString()));
        return this.webElement.getSize();
    }

    public Point getLocation() {
        Point location = this.webElement.getLocation();
        logger.debug(String.format("Element '%s' x/y location is '%s'", this.getClass(), location.toString()));
        return this.webElement.getLocation();
    }

    public boolean isElementClickable(int timeout) {
        boolean webElementStatus = this.webElement != null && Waiters.waitUntilCondition(
                () -> webElement.isDisplayed() && webElement.isEnabled(),
                timeout,
                String.format("Component '%s' is displayed and enabled", this.getClass())
        );
        logger.debug(String.format("Component's '%s' display and enable status is '%s'", this.getClass(), webElementStatus));
        return webElementStatus;
    }

    public boolean isElementClickable() {
        return this.isElementClickable(this.timeout);
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public boolean isBoldText() {
        return this.webElement.getCssValue("font-weight").equals("700");
    }
}
