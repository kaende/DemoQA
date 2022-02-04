package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {
    public WebDriver driver;

    WebElement fullName, email, currAdd, permAdd, submit;
    WebElement textBox, outputMsg;

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrAdd() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermAdd() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getTextBoxTab() {
        return driver.findElement(By.id("item-0"));
    }

    public WebElement getMsg() {
        return driver.findElement(By.id("output"));
    }

//    --------------------------------------------------------------

    public void inputName(String name){
        getFullName().clear();
        getFullName().sendKeys(name);
    }

    public void inputMail(String mail){
        getEmail().clear();
        getEmail().sendKeys(mail);
    }

    public void inputAddressC(String add){
        getCurrAdd().clear();
        getCurrAdd().sendKeys(add);
    }

    public void inputAddressP(String add){
        getPermAdd().clear();
        getPermAdd().sendKeys(add);
    }

    public void clickSubmit(){
        getSubmit().click();
    }

    public void clickTxtBoxTab(){
        getTextBoxTab().click();
    }
}
