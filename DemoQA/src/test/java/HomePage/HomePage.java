package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    List<WebElement> cards;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCards() throws InterruptedException {
        return driver.findElements(By.className("card-up"));
    }

    public void clickCard(int i) throws InterruptedException {
        getCards().get(i).click();
    }
}
