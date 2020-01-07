package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.VyTrackAllCalendarEventsPage;
import pages.VyTrackDashboardPage;

import java.util.List;

public class CalendarEventsStepDef {

    VyTrackDashboardPage dashboardPage =new VyTrackDashboardPage();
    VyTrackAllCalendarEventsPage allCalendarEventsPage=new VyTrackAllCalendarEventsPage();

    @Then("user navigates to {string} then to {string}")
    public void user_navigates_to_then_to(String hover, String click) {

        dashboardPage.hoverOnceAndClick(hover,click);


    }

    @Then("user verifies that column names are displayed")
    public void user_verifies_that_column_names_are_displayed(DataTable dataTable) {
        List<String>list=dataTable.column(0);
        System.out.println(list);
        List<WebElement> table=allCalendarEventsPage.tableHeaders;
        for(WebElement element: table){
            if(list.contains(element.getText())){
                Assert.assertTrue("element.getText()+element was not diesplayed",element.isDisplayed());
            }


        }


    }





}
