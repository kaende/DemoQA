package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {

    public WebDriver driver;
    WebElement home, arrow1, arrow2, arrow3, generalCbx;
    List<WebElement> msgListed;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHome() {
        return driver.findElement(By.cssSelector(".rct-title"));
    }

    public WebElement getArrow1() {
        return driver.findElement(By.cssSelector(".rct-collapse"));
    }

    public WebElement getArrow2() {
        return driver.findElement(By.cssSelector("li.rct-node:nth-child(2) > span:nth-child(1) > button:nth-child(1)"));
    }

    public WebElement getArrow3() {
        return driver.findElement(By.cssSelector("li.rct-node-collapsed:nth-child(2) > span:nth-child(1) > button:nth-child(1)"));
    }

    public WebElement getGeneralCbx() {
        return driver.findElement(By.cssSelector("li.rct-node:nth-child(4) > span:nth-child(1) > label:nth-child(2)"));
    }

    public List<WebElement> getMsgListed() {
        return driver.findElements(By.className("text-success"));
    }

//------------------------------------------------------

    public void goToCheckBox(String cbURL){
        driver.navigate().to(cbURL);
    }

    public void clickHome(){
        getHome().click();
    }

    public void expandFolders(){
        getArrow1().click();
    }

    public void clickDocument(){
        getArrow2().click();
    }

    public void clickOffice(){
        getArrow3().click();
    }

    public void checkGeneral(){
        getGeneralCbx().click();
    }

}
