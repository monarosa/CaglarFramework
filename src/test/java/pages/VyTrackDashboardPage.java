package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackDashboardPage {
    private WebDriver driver;

    public VyTrackDashboardPage() {
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Fleet")
    public WebElement fleet;

    @FindBy(linkText = "Vehicles")
    public WebElement vehicles;



}
