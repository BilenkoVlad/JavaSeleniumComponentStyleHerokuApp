package components.base_components;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Waiters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectComponent extends BaseComponent {
    protected Select selectWebElement;

    @Override
    public BaseComponent init(By by, SearchContext context, int timeout, int period) {
        super.init(by, context, timeout, period);
        selectWebElement = new Select(this.webElement);

        return this;
    }

    public void selectByVisibleText(String text) {
        logger.info(String.format("Selecting option '%s'", text));
        selectWebElement.selectByVisibleText(text);
    }

    public void selectByValue(String text) {
        logger.info(String.format("Selecting option '%s'", text));
        selectWebElement.selectByValue(text);
    }

    public ArrayList<String> getOptions() {
        List<WebElement> webElementsOptions = selectWebElement.getOptions();

        ArrayList<String> strOptions = new ArrayList<>();
        for (WebElement webElement : webElementsOptions) {
            BaseComponent webElementComponent = new BaseComponent().init(webElement, this.webElement);
            strOptions.add(webElementComponent.getText());
        }
        logger.info(String.format("Available options are '%s'", Arrays.toString(strOptions.toArray())));

        return strOptions;
    }

    public boolean containsOption(String option) {
        return this.getOptions().contains(option);
    }

    public String getFirstSelectedOption() {
        WebElement selectedWebElement = selectWebElement.getFirstSelectedOption();
        String selectedOption = new BaseComponent().init(selectedWebElement, this.webElement).getText();
        logger.info(String.format("First selected option is '%s'", selectedOption));

        return selectedOption;
    }

    public boolean isOptionSelected(String option) {
        return this.getFirstSelectedOption().equals(option);
    }

    public boolean waitOptionToBeSelected(String option) {
        return Waiters.waitUntilCondition(() -> this.isOptionSelected(option),
                "Option '" + option + "' to be selected");
    }
}
