package stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.testng.Assert.fail;

public class CrateCarsStepDef {
    @Given("^As a user I log in to the application with username and password$")
    public void as_a_user_I_log_in_to_the_application_with_username_and_password() {

    }

    @Given("^I hover over fleet and click on Vehicles$")
    public void i_hover_over_fleet_and_click_on_Vehicles() {

    }

    @Given("^I create a car a with following information:$")
    public void i_create_a_car_a_with_following_information(DataTable arg1) {

    }

    @Given("^I save and close$")
    public void i_save_and_close() {
        fail();
    }

    @Then("^I verify car is added for driver \"([^\"]*)\" with license plate \"([^\"]*)\"$")
    public void i_verify_car_is_added_for_driver_with_license_plate(String arg1, String arg2) {

    }
}
