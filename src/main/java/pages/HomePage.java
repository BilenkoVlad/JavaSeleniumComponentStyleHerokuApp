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
import pages.dynamic_loading_page.DynamicLoadingPage;
import pages.dynamic_loading_page.example1_hidden_elements_page.Example1HiddenElementsPage;
import pages.dynamic_loading_page.example2_element_rendered.Example2ElementRendered;
import pages.entry_ad_page.EntryAdPage;
import pages.file_download_page.FileDownloadPage;
import pages.forgot_password_page.ForgotPasswordPage;
import pages.form_authentication_page.FormAuthenticationPage;
import pages.form_authentication_page.secure_page.SecurePage;
import pages.frames_page.FramesPage;
import pages.frames_page.nested_frames_page.NestedFramesPage;
import pages.horizontal_slider_page.HorizontalSliderPage;
import pages.hovers_page.HoversPage;
import pages.inputs_page.InputsPage;
import pages.java_script_alerts_page.JavaScriptAlertsPage;
import pages.key_presses_page.KeyPressesPage;
import utils.browsers.BrowserManager;
import utils.logger.TAFLogger;

public class HomePage {
    private static final Logger logger = TAFLogger.logger;
    private static HomePage homePage;
    protected final String LINK_TO_PAGE = ".//*[contains(text(), '%s')]";
    protected final String PAGE_CONTENT = ".//div[@id='content']";
    protected final String LOGIN_CONTENT = ".//body";
    protected final String FRAME_CONTENT = ".//html";
    private final WebDriver driver;

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

    public DynamicLoadingPage dynamicLoadingPage() {
        return (DynamicLoadingPage) new DynamicLoadingPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public Example1HiddenElementsPage example1HiddenElementsPage() {
        return (Example1HiddenElementsPage) new Example1HiddenElementsPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public Example2ElementRendered example2ElementRendered() {
        return (Example2ElementRendered) new Example2ElementRendered().init(By.xpath(PAGE_CONTENT), driver);
    }

    public EntryAdPage entryAdPage() {
        return (EntryAdPage) new EntryAdPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public FileDownloadPage fileDownloadPage() {
        return (FileDownloadPage) new FileDownloadPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public ForgotPasswordPage forgotPasswordPage() {
        return (ForgotPasswordPage) new ForgotPasswordPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public FormAuthenticationPage formAuthenticationPage() {
        return (FormAuthenticationPage) new FormAuthenticationPage().init(By.xpath(LOGIN_CONTENT), driver);
    }

    public SecurePage securePage() {
        return (SecurePage) new SecurePage().init(By.xpath(LOGIN_CONTENT), driver);
    }

    public FramesPage framesPage() {
        return (FramesPage) new FramesPage().init(By.xpath(LOGIN_CONTENT), driver);
    }

    public NestedFramesPage nestedFramesPage() {
        return (NestedFramesPage) new NestedFramesPage().init(By.xpath(FRAME_CONTENT), driver);
    }

    public HorizontalSliderPage horizontalSliderPage() {
        return (HorizontalSliderPage) new HorizontalSliderPage().init(By.xpath(FRAME_CONTENT), driver);
    }

    public HoversPage hoversPage() {
        return (HoversPage) new HoversPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public InputsPage inputsPage() {
        return (InputsPage) new InputsPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public JavaScriptAlertsPage javaScriptAlertsPage() {
        return (JavaScriptAlertsPage) new JavaScriptAlertsPage().init(By.xpath(PAGE_CONTENT), driver);
    }

    public KeyPressesPage keyPressesPage() {
        return (KeyPressesPage) new KeyPressesPage().init(By.xpath(PAGE_CONTENT), driver);
    }
}
