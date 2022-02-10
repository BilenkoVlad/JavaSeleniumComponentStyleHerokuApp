package pages.basic_auth_page;

import pages.BasePage;

public class BasicAuthPage extends BasePage {
    public String getVerificationURL() {
        return "basic_auth";
    }

    public void loginToPage(String username, String password) {
        driver.get(String.format("https://%s:%s@%s", username, password, baseUrl.split("//")[1] + "basic_auth"));
    }
}
