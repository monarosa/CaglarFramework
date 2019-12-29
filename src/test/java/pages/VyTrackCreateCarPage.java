package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackCreateCarPage {
    private WebDriver driver;

    public VyTrackCreateCarPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-ftid='custom_entity_type_LicensePlate']")
    public WebElement licencePlate;

    @FindBy(xpath = "//input[@value='junior']")
    public WebElement junior;


    @FindBy(xpath = "//input[@value='senior']")
    public WebElement senior;

    @FindBy(xpath = "//input[@value='employee_car']")
    public WebElement employeeCar;

    @FindBy(xpath = "//input[@value='purchased']")
    public WebElement purchased;

    @FindBy(xpath = "//input[@value='compact']")
    public WebElement compact;

    @FindBy(xpath = "//input[@value='sedan']")
    public WebElement sedan;

    @FindBy(xpath = "//input[@value='convertible']")
    public WebElement convertible;

    public WebElement getTags(String tag) {
        switch (tag.toLowerCase()) {
            case "junior":
                return junior;
            case "senior":
                return senior;
            case "employee car":
                return employeeCar;
            case "purchased":
                return purchased;
            case "compact":
                return compact;
            case "sedan":
                return sedan;
            case "convertable":
                return convertible;
        }
        return null;
    }

    @FindBy(xpath = "//input[@data-name='field__driver']")
    public WebElement CarCreatePageDriver;

    @FindBy(xpath = "//input[contains(@id,'custom_entity_type_Location')]")
    public WebElement location;


    @FindBy(xpath = "//input[contains(@id,'custom_entity_type_ModelYear')]")
    public WebElement modelYear;

    @FindBy(xpath = "//input[contains(@id,'custom_entity_type_LastOdometer')]")
    public WebElement lastOdometer;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_FirstContractDate')]")
    public WebElement firstContractDate;

    @FindBy(xpath = "//select[contains(@id,'custom_entity_type_Transmission')]")
    public WebElement transmissionSelector;

    @FindBy(xpath = "//select[contains(@id,'custom_entity_type_FuelType')]")
    public WebElement fuelTypeSelector;

    @FindBy(xpath = "//input[contains(@id,'custom_entity_type_Logo_file')]")
    public WebElement logo;

    @FindBy(xpath = "//li/button[contains(text(),'Save and Close')]")
    public WebElement save;


}
