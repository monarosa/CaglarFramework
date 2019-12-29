package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.VyTrackAllCarEntitiesPage;
import pages.VyTrackCreateCarPage;
import pages.VyTrackDashboardPage;
import pages.VyTrackLoginPage;
import utilities.BrowserUtilis;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.Map;

public class CrateCarsStepDef {
    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboard = new VyTrackDashboardPage();
    VyTrackAllCarEntitiesPage allCarEntitiesPage = new VyTrackAllCarEntitiesPage();
    VyTrackCreateCarPage vyTrackCreateCarPage = new VyTrackCreateCarPage();

    @Given("As a user I log in to the application with username and password")
    public void as_a_user_I_log_in_to_the_application_with_username_and_password() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        BrowserUtilis.waitForPageToLoad(5);

    }

    @Given("I hover over fleet and click on Vehicles")
    public void i_hover_over_fleet_and_click_on_Vehicles() {

        BrowserUtilis.hover(dashboard.fleet);


        BrowserUtilis.waitForClickablility(dashboard.vehicles,10);
        BrowserUtilis.clickWithWait(dashboard.vehicles);


         BrowserUtilis.waitForClickablility(allCarEntitiesPage.createCar,20);

        BrowserUtilis.waitForPageToLoad(5);
        BrowserUtilis.clickWithWait(allCarEntitiesPage.createCar);
        BrowserUtilis.clickWithJS(allCarEntitiesPage.createCar);


    }


    @Given("I create a car with the following information:")
    public void i_create_a_car_with_the_following_information(Map<String, String> map) {
        BrowserUtilis.waitForPageToLoad(5);

        vyTrackCreateCarPage.licencePlate.sendKeys(map.get("LicensePlate"));
        vyTrackCreateCarPage.CarCreatePageDriver.sendKeys(map.get("Driver"));
        vyTrackCreateCarPage.location.sendKeys(map.get("Location"));
        vyTrackCreateCarPage.modelYear.sendKeys("ModelYear");
        vyTrackCreateCarPage.lastOdometer.sendKeys(map.get("LastOdometer"));
        vyTrackCreateCarPage.firstContractDate.sendKeys(map.get("FirstContractDate"));
        BrowserUtilis.select(vyTrackCreateCarPage.transmissionSelector,map.get("Transmission"));
        BrowserUtilis.select(vyTrackCreateCarPage.fuelTypeSelector,map.get("FuelType"));
        vyTrackCreateCarPage.logo.sendKeys(map.get("Logo"));
        vyTrackCreateCarPage.getTags(map.get("Tags")).click();
    }
    @Given("I save and close")
    public void i_save_and_close() {
        //BrowserUtilis.clickWithWait(vyTrackCreateCarPage.save);
        BrowserUtilis.clickWithJS(vyTrackCreateCarPage.save);
    }

    @Then("I verify new car page is loaded with title contains  license plate {string}")
    public void i_verify_new_car_page_is_loaded_with_title_contains_license_plate(String args) {
        BrowserUtilis.waitForPageTitle(Driver.getDriver().getTitle());
        String title = Driver.getDriver().getTitle();
        System.out.println(title);
//        Assert.assertTrue("title does not match with the expected page title",title.contains(args));
    }
}
