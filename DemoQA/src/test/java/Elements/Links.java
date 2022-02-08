package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Links {

    public WebDriver driver;
    List<WebElement> links;
    WebElement linkMsg;

    public Links(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getLinks() {
        return driver.findElement(By.id("linkWrapper")).findElements(By.tagName("a"));
    }

    public WebElement getLinkMsg() {
        return driver.findElement(By.cssSelector("#linkResponse"));
    }

//----------------------------------------------------------------------------------

    public void goToLinks(String radio){
        driver.navigate().to(radio);
    }
}
