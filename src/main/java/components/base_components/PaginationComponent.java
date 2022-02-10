package components.base_components;

import org.openqa.selenium.By;

public class PaginationComponent extends BaseComponent {
    protected final String PAGINATION_LEFT_ARROW = "//div//a[@class='paginationNavigator'][1]";
    protected final String PAGINATION_RIGHT_ARROW = "//div//a[@class='paginationNavigator'][2]";


    public ButtonComponent leftArrowButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(PAGINATION_LEFT_ARROW), this.webElement);
    }

    public ButtonComponent rightArrowButton() {
        return (ButtonComponent) new ButtonComponent().init(By.xpath(PAGINATION_RIGHT_ARROW), this.webElement);
    }
}
