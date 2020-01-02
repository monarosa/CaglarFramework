package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GasMilageCalculatorPage {

    private WebDriver driver;

    public GasMilageCalculatorPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="uscodreading")
    public WebElement curruntOdemeterReading;

    @FindBy(id="uspodreading")
    public WebElement previousOdometerReading;

    @FindBy(id="usgasputin")
    public WebElement gasAdded;

    @FindBy(id="usgasprice")
    public WebElement gasPrice;

    @FindBy(xpath="//*[@id='standard']//input[@type='image']")
    public WebElement calculate;

    @FindBy(xpath = "//*[@id='standard']//img[@class='clearbtn']")
    public WebElement clear;

    @FindBy(xpath = "//b[contains(text(),'mpg')]")
    public WebElement result;
}
