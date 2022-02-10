package components.base_components;

import org.openqa.selenium.ElementNotInteractableException;

public class NonClickableComponent extends ButtonComponent {

    public boolean isClickable() {
        try {
            this.click();
            this.webElement.sendKeys("");
            return this.isEnabled();
        } catch (ElementNotInteractableException e) {
            return false;
        }
    }
}
