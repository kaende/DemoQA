package BasePage;

import Elements.*;
import HomePage.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class Base {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public HomePage homePage;
    public TextBox textBox;
    public CheckBox checkBox;
    public RadioBtn radioBtn;
    public Buttons buttons;
    public Links links;
    public UploadDownload uploadDownload;
    public String Home;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        textBox = new TextBox(driver);
        checkBox = new CheckBox(driver);
        radioBtn = new RadioBtn(driver);
        buttons = new Buttons(driver);
        links = new Links(driver);
        uploadDownload = new UploadDownload(driver);

        excelReader = new ExcelReader("C:\\Users\\DELL\\Desktop\\Excel Selenium\\DemoQA.xlsx");
        Home = excelReader.getStringData("Pages", 1, 0);
    }

    public void scroll(WebElement we){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", we);
    }

    public void waitFor(WebElement we){
        wdwait.until(ExpectedConditions.visibilityOf(we));
    }

    @AfterClass
    public void tearDown(){
//        driver.manage().deleteAllCookies();
//        driver.close();
//        driver.quit();
    }
}
