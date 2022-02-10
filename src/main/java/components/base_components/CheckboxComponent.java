package components.base_components;

public class CheckboxComponent extends BaseComponent {
    public boolean isSelected() {
        boolean status = webElement.isSelected();
        logger.info("Component's " + this.getClass() + " selected status is '" + status + "'");
        return status;
    }

    public boolean isUnselected() {
        boolean status = !webElement.isSelected();
        logger.info("Component's " + this.getClass() + " selected status is '" + status + "'");
        return status;
    }
}
