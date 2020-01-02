package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class VyTrackAllCalendarEventsPage extends VyTrackBasePage {


    @FindBy(className ="grid-header-cell__label")
    public List<WebElement> tableHeaders;



}
