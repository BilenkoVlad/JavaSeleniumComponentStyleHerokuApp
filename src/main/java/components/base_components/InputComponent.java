package components.base_components;

import org.openqa.selenium.Keys;
import utils.Waiters;
import utils.java_script_executor.JSExecutor;

import java.util.Arrays;

public class InputComponent extends BaseComponent {

    public void sendKeys(CharSequence... keysToSend) {
        logger.debug("Entering value in input " + Arrays.toString(keysToSend));
        this.clear();
        this.webElement.sendKeys(keysToSend);
        this.applyEnteredValue();
    }

    public void sendKeysWithoutClick(CharSequence... keysToSend) {
        logger.debug("Entering value in input " + Arrays.toString(keysToSend));
        this.webElement.sendKeys(keysToSend);
    }

    public void applyEnteredValue() {
        String shiftTab = Keys.chord(Keys.LEFT_SHIFT, Keys.TAB);
        this.webElement.sendKeys(shiftTab);
    }

    public void clear() {
        this.click();
        JSExecutor.clearInput(this.webElement);
        JSExecutor.setAttribute(this.webElement, "value", "");
    }

    public String getValue() {
        String value = this.webElement.getAttribute("value");
        logger.debug("Retrieved input entered value is '" + value + "'");
        return value;
    }

    public boolean isEnabled() {
        boolean status = this.webElement.isEnabled();
        logger.debug("Input field status is '" + status + "'");
        return status;
    }

    public boolean isDisabled() {
        boolean status = !this.webElement.isEnabled();
        logger.debug("Input field status is '" + status + "'");
        return status;
    }

    public boolean waitValueIs(String expectedValue) {
        return Waiters.waitUntilCondition(() -> this.getValue().equals(expectedValue),
                "Waiting until value became '" + expectedValue + "'");
    }

    public void clearViaBackspace() {
        this.click();
        String value = this.getValue();
        if (!value.isEmpty()) {
            for (int i = 0; i < value.length(); i++) {
                this.webElement.sendKeys(Keys.BACK_SPACE);
                this.webElement.sendKeys(Keys.DELETE);
            }
        }
    }
}
