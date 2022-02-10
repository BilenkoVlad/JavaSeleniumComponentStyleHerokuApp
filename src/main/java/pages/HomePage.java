package pages;

import components.base_components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import pages.add_remove_elements_page.AddRemoveElementsPage;
import pages.basic_auth_page.AuthorizedPage;
import pages.basic_auth_page.BasicAuthPage;
import pages.checkboxes_page.CheckboxesPage;
import pages.context_menu_page.ContextMenuPage;
import pages.disappearing_elements_page.DisappearingElementsPage;
import pages.dropdown_page.DropdownPage;
import pages.dynamic_controls_page.DynamicControlsPage;
import utils.browsers.BrowserManager;
import utils.logger.TAFLogger;

public class HomePage {
    private static final Logger logger = TAFLogger.logger;
    private static HomePage homePage;
    private final WebDriver driver;

    private final String LINK_TO_PAGE = ".//*[contains(text(), '%s')]";
    private final String PAGE_CONTENT = ".//div[@id='content']";

    public HomePage() {
        driver = BrowserManager.getBrowser().getDriver();
    }

    public static HomePage initSite(String siteURL) {
        if (homePage == null) {
            homePage = new HomePage();
            homePage.loadPage(siteURL);
        }
        return homePage;
    }

    public static HomePage getSiteInstance() {
        return HomePage.homePage;
    }

    public static void resetSite() {
        homePage = null;
        BrowserManager.quitSession();
    }

    private void loadPage(String page) {
        driver.get(page);
    }

    public BaseComponent linkToPages(String link) {
        return new BaseComponent().init((By.xpath(String.format(LINK_TO_PAGE, link))));
    }

    public AddRemoveElementsPage addRemoveElementsPage() {
        return (AddRemoveElementsPage) new AddRemoveElementsPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public BasicAuthPage basicAuthPage() {
        return (BasicAuthPage) new BasicAuthPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public AuthorizedPage authorizedPage() {
        return (AuthorizedPage) new AuthorizedPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public CheckboxesPage checkboxesPage() {
        return (CheckboxesPage) new CheckboxesPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public ContextMenuPage contextMenuPage() {
        return (ContextMenuPage) new ContextMenuPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public DisappearingElementsPage disappearingElementsPage() {
        return (DisappearingElementsPage) new DisappearingElementsPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public DropdownPage dropdownPage() {
        return (DropdownPage) new DropdownPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public DynamicControlsPage dynamicControlsPage() {
        return (DynamicControlsPage) new DynamicControlsPage().init(By.xpath(PAGE_CONTENT), driver);
    }
}
