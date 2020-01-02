package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackAllCarEntitiesPage extends VyTrackBasePage{


    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCar;



}
