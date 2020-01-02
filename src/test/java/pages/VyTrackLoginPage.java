package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackLoginPage extends VyTrackBasePage {


    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(css =".alert.alert-error")
    public WebElement warningMassage;

    public void login(String userName,String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        logInButton.click();

    }

}
