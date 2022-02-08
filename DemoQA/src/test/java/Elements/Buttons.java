package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

public class Buttons {

    public WebDriver driver;
    WebElement doubleClick;
    WebElement dcMsg;

    public Buttons(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDoubleClick() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getDcMsg() throws NoSuchElementException {
        return driver.findElement(By.id("doubleClickMessage"));
    }

//------------------------------------------------------------------

    public void doubleClick(){
        Actions act = new Actions(driver);
        act.doubleClick(getDoubleClick()).perform();
    }

    public void singleClick(){
        getDoubleClick().click();
    }

    public void goToBtns(String btns){
        driver.navigate().to(btns);
    }

}
