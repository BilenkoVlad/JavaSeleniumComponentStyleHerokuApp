package components.base_components;

import utils.Waiters;

public class CollapsibleComponent extends BaseComponent {
    protected final String COLLAPSED_CLASS_VALUE = "collapse";
    protected final String EXPANDED_CLASS_VALUE = "collapse show";
    protected String collapseValue;
    protected String expendedValue;

    public CollapsibleComponent(String collapseValue, String expendedValue) {
        this.collapseValue = collapseValue;
        this.expendedValue = expendedValue;
    }

    public CollapsibleComponent() {
        this.collapseValue = COLLAPSED_CLASS_VALUE;
        this.expendedValue = EXPANDED_CLASS_VALUE;
    }

    public boolean waitToExpand(int timeout) {
        return Waiters.waitUntilCondition(this::isExpanded, timeout, "Component to be expanded");
    }

    public boolean waitToExpand() {
        return this.waitToExpand(this.timeout);
    }

    public boolean waitToCollapse(int timeout) {
        return Waiters.waitUntilCondition(this::isCollapsed, "Component to be collapsed");
    }

    public boolean waitToCollapse() {
        return Waiters.waitUntilCondition(this::isCollapsed, "Component to be collapsed");
    }

    public boolean isExpanded() {
        return this.reInit().getAttribute("class").equals(this.expendedValue);
    }

    public boolean isCollapsed() {
        return this.reInit().getAttribute("class").equals(this.collapseValue);
    }
}
