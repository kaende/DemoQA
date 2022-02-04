package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioBtn {

    public WebDriver driver;
    WebElement yesBtn, impressiveBtn, noBtn, msg;

    public RadioBtn(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getYesBtn() {
        return driver.findElement(By.cssSelector("div.custom-control:nth-child(2) > label:nth-child(2)"));
    }

    public WebElement getImpressiveBtn() {
        return driver.findElement(By.cssSelector("div.custom-control:nth-child(3) > label:nth-child(2)"));
    }

    public WebElement getNoBtn() {
       return driver.findElement(By.cssSelector("label.disabled"));
    }


    public WebElement getMsg() {
        return driver.findElement(By.className("text-success"));
    }

//-----------------------------------------------------------------

    public void clickYes(){
        getYesBtn().click();
    }

    public void clickImpressive(){
        getImpressiveBtn().click();
    }

    public void clickNo(){
        getNoBtn().click();
    }

    public void goToRadioBtn(String radio){
        driver.navigate().to(radio);
    }
}
