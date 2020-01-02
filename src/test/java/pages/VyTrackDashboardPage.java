package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilis;
import utilities.Driver;

import java.util.List;

public class VyTrackDashboardPage extends VyTrackBasePage{

    //this gives us subtitle of the page which may depend on the page
    @FindBy(css = ".oro-subtitle")
    public WebElement subTitle;


    @FindBy(linkText = "Dashboards")
    public WebElement dashboards;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboard;

    @FindBy(linkText = "Manage Dashboards")
    public WebElement manageDashboards;

    @FindBy(linkText = "Fleet")
    public WebElement fleet;

    @FindBy(linkText = "Vehicles")
    public WebElement vehicles;

    @FindBy(linkText = "Vehicle Odometer")
    public WebElement vehicleOdometer;

    @FindBy(linkText = "Vehicle Costs")
    public WebElement vehicleCosts;

    @FindBy(linkText = "Vehicle Contracts")
    public WebElement vehicleContracts;

    @FindBy(linkText = "Vehicles Fuel Logs")
    public WebElement vehiclesFuelLogs;

    @FindBy(linkText = "Vehicle Services Logs")
    public WebElement vehicleServicesLogs;

    @FindBy(linkText = "Vehicles Model")
    public WebElement vehiclesModel;


//    @FindBy(linkText ="Customers")
//    public WebElement customers;

    @FindBy(xpath = "//a[@href='#'][@class='unclickable']")
    public List<WebElement> alldashboard;

    public WebElement getCustomers(){

        for (WebElement e: alldashboard){
            System.out.println(e.getText());
           if(e.getText().trim().toLowerCase().contains("customer")) return e;

        }

        return null;
    }




    @FindBy(xpath = "//a[@href='/account']")
    public WebElement accountsUnderCostumer;

    @FindBy(linkText = "Contacts")
    public WebElement contacts;

    @FindBy(linkText = "Sales")
    public WebElement sales;

    @FindBy(xpath = "//span[@class='title title-level-2' and contains(text(),'Opportunities')]/..")
    public WebElement opportunitiesUnderSales;

    @FindBy(linkText = "Activities")
    public WebElement activities;

    @FindBy(linkText = "Calss")
    public WebElement calls;

    @FindBy(linkText = "Calendar Events")
    public WebElement calendarEvents;

    @FindBy(linkText = "Marketing")
    public WebElement marketing;

    @FindBy(xpath = "//a[@href='/campaign/']//span[@class='title title-level-2' and contains(text(),'Campaigns')]/..")
    public WebElement campaignsUnderMarketing;

    @FindBy(linkText = "Email Campaigns")
    public WebElement emailCampaigns;

    @FindBy(linkText = "Reports & Segments")
    public WebElement reportsSegments;

    @FindBy(linkText = "Reports")
    public WebElement reports;

    @FindBy(xpath = "//span[@class='title title-level-3' and contains(text(),'Accounts')]/..")
    public WebElement accountsUnderReports;

    @FindBy(linkText = "Life Time")
    public WebElement lifeTime;

    @FindBy(linkText = "By Opportunities")
    public WebElement byOpportunities;

    @FindBy(linkText = "Leads")
    public WebElement leads;

    @FindBy(linkText = "Leads By Date")
    public WebElement leadsByDate;

    @FindBy(xpath = "//span[@class='title title-level-3' and contains(text(),'Opportunities')]/..")
    public WebElement opportunitiesUnderReport;

    @FindBy(linkText = "Opportunities By Status")
    public WebElement opportunitiesByStatus;

    @FindBy(linkText = "Won Opportunities By Period")
    public WebElement wonOpportunities;

    @FindBy(linkText = "Total Forecast")
    public WebElement totalForecast;

    @FindBy(linkText = "Manage Custom Reports")
    public WebElement manageCustomReports;

    @FindBy(xpath = "//a[@class='unclickable']//span[@class='title title-level-2' and contains(text(),'Campaigns')]/..")
    public WebElement campaignUnderReports;

    @FindBy(linkText = "Campaign Performance")
    public WebElement compaignPerformance;

    @FindBy(linkText = "System")
    public WebElement system;

    @FindBy(linkText = "User Management")
    public WebElement userManagement;

    @FindBy(linkText = "Users")
    public WebElement users;

    @FindBy(linkText = "Business Units")
    public WebElement businessUnits;

    @FindBy(linkText = "Contact Groups")
    public WebElement contactGroups;

    @FindBy(linkText = "Jobs")
    public WebElement jobs;

    @FindBy(linkText = "Menus")
    public WebElement menus;

    @FindBy(linkText = "System Calendars")
    public WebElement systemCalendars;


    public void hoverOnceAndClick(String navigate, String toclick) {
        WebElement target;
        switch (navigate.toLowerCase()) {
            case "dashboards":
                target = dashboards;
                break;
            case "fleet":
                target = fleet;
                break;
            case "customers":
                target =getCustomers();
                break;
            case "sales":
                target =sales;
                break;
            case "activities":
                target =activities;
                break;
            case "marketing":
                target =marketing;
                break;
            case "report & segments":
                target =reportsSegments;
                break;
            case "system":
                target =system;
                break;
            default: throw new RuntimeException("there is no tab named: "+ navigate + " please check spellings");
        }


        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(target);
        action.perform();


        switch (toclick.toLowerCase())
        {
            case "dashboard":dashboard.click(); break;
            case "manage dashboards": manageDashboards.click(); break;
            case "vehicles": vehicles.click(); break;
            case "vehicle odometer": vehicleOdometer.click();break;
            case "vehicle costs": vehicleCosts.click(); break;
            case "vehicle contracts": vehicleContracts.click(); break;
            case "vehicles fuel logs": vehiclesFuelLogs.click();break;
            case "vehicle services logs": vehicleServicesLogs.click(); break;
            case "vehicles model": vehiclesModel.click(); break;
            case "accounts": BrowserUtilis.clickWithWait(accountsUnderCostumer); break;
            case "contacts": contacts.click(); break;
            case "opportunities": opportunitiesUnderSales.click(); break;
            case "calls": calls.click(); break;
            case "calendar events": calendarEvents.click(); break;
            case "campaigns": campaignsUnderMarketing.click(); break;
            case "email campaigns": emailCampaigns.click(); break;
            case "manage custom reports": manageCustomReports.click(); break;
            case "contact groups":  contactGroups.click(); break;
            case "jobs": jobs.click(); break;
            case "menus": menus.click(); break;
            case "system calendars": systemCalendars.click(); break;
            default: throw new RuntimeException("there is no option named: "+ toclick+ "please check spelling");
        }
    }
    }
