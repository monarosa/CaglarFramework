package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.VyTrackDashboardPage;
import pages.VyTrackLoginPage;
import utilities.ConfigurationReader;

import java.util.Map;

public class LoginStepDef {
    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();


    @Then("user logs in as (store manager)/driver/(sales manager)")
    public void user_logs_in_as_store_manager() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @And("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String str) {
        dashboardPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals("i needed to fail this step", 2, 7);
 //       Assert.assertTrue("Subtitle is not visible", dashboardPage.subTitle.isDisplayed());

    }


    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String username, String password) {
        dashboardPage.waitUntilLoaderMaskDisappear();
        loginPage.login(username, password);


    }


    @And("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String massage) {
        Assert.assertTrue(loginPage.warningMassage.getText().equalsIgnoreCase(massage));
    }


    @Then("user logs in as driver with following credentials")
    public void user_logs_in_as_driver_with_following_credentials(Map<String, String> map) {
        loginPage.login(map.get("username"), map.get("password"));

    }


}
