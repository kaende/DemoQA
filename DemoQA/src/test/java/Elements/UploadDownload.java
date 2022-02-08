package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadDownload {

    public WebDriver driver;
    WebElement upload, uploadMsg;

    public UploadDownload(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUpload() {
        return driver.findElement(By.id("uploadFile"));
    }

    public WebElement getUploadMsg() {
        return driver.findElement(By.id("uploadedFilePath"));
    }

    //---------------------------------------------------------------------------

    public void upload(String uploadFile){
        getUpload().sendKeys(uploadFile);
    }

    public String uploadMsg(){
        return getUploadMsg().getText();
    }

    public void goToUpDownload(String load){
        driver.navigate().to(load);
    }

}
