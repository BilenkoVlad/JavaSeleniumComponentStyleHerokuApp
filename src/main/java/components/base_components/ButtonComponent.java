package components.base_components;

public class ButtonComponent extends BaseComponent {

    public boolean isEnabled() {
        boolean status = webElement.isEnabled();
        logger.info("Component's " + this.getClass() + " display status is '" + status + "'");
        return status;
    }

    public boolean isDisabled() {
        boolean status = webElement.getAttribute("disabled") != null;
        logger.info("Component's " + this.getClass() + " display status is '" + status + "'");
        return status;
    }
}
