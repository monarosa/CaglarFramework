package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class VyTrackBasePage {
    private WebDriver driver;

    public VyTrackBasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    public boolean waitUntilLoaderMaskDisappear(){
        WebDriverWait wait=new WebDriverWait(driver,5);

        try{wait.until(ExpectedConditions.
                invisibilityOfElementLocated(By.cssSelector("div[class='loader-mask-shown']")));
        return true;}
        catch (NoSuchElementException e) {
            System.out.println("Loader mask not found!");
            e.printStackTrace();
            return true; // no loader mask, all good, return true
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return false;


    }
}
