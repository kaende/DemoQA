package Test;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class TestElements extends Base {
    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to(Home);
        driver.manage().window().maximize();
    }

    @Test (priority = 10)
    public void goToHome() throws InterruptedException {
        String currentURL = Home;

        Assert.assertEquals(currentURL, Home);
    }

    @Test (priority = 20)
    public void goToEelements() throws InterruptedException {
        scroll(homePage.getCards().get(0));
        homePage.clickCard(0);

        String expectedURL = excelReader.getStringData("Pages", 1, 1);
        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test (priority = 30)
    public void formCannotSubmit() throws InterruptedException {
        goToEelements();
        textBox.clickTxtBoxTab();
        textBox.inputName(excelReader.getStringData("InputData", 1, 0));
        textBox.inputMail(excelReader.getStringData("InputData", 1, 1));
        //nevalidan email
        textBox.inputAddressC(excelReader.getStringData("InputData", 1, 2));
        textBox.inputAddressP(excelReader.getStringData("InputData", 1, 2));
        scroll(textBox.getSubmit());
        textBox.clickSubmit();

        Assert.assertFalse(textBox.getMsg().isDisplayed());
        //preoverava da li dugme nije prikazano
    }

    @Test (priority = 40)
    public void formSubmitSuccess() throws InterruptedException {
        goToEelements();
        textBox.clickTxtBoxTab();
        textBox.inputName(excelReader.getStringData("InputData", 2, 0));
        textBox.inputMail(excelReader.getStringData("InputData", 2, 1));
        textBox.inputAddressC(excelReader.getStringData("InputData", 2, 2));
        textBox.inputAddressP(excelReader.getStringData("InputData", 2, 3));
        scroll(textBox.getSubmit());
        textBox.clickSubmit();

        Assert.assertTrue(textBox.getMsg().isDisplayed());
        //preoverava da li dugme nije prikazano
    }

    @Test (priority = 50)
    public void allElementsSelectedWhenHomeIsClicked() throws InterruptedException {
      checkBox.goToCheckBox(excelReader.getStringData("Pages",4, 1));
      checkBox.clickHome();

       int expectedSize = 17;
       Assert.assertEquals(expectedSize, checkBox.getMsgListed().size());
    }

    @Test (priority = 60)
    public void parentsMarked() throws InterruptedException {
        checkBox.goToCheckBox(excelReader.getStringData("Pages",4, 1));
        checkBox.expandFolders();
        checkBox.clickDocument();
        checkBox.clickOffice();
        scroll(checkBox.getGeneralCbx());
        checkBox.checkGeneral();

        int expectedSize = 1;
        String expectedMsg = "general";

        Assert.assertEquals(expectedSize, checkBox.getMsgListed().size());
        Assert.assertEquals(expectedMsg, checkBox.getMsgListed().get(0).getText());
    }

    @Test (priority = 70)
    public void clickRadioButtons(){
        radioBtn.goToRadioBtn(excelReader.getStringData("Pages", 5, 1));

        radioBtn.clickYes();
        String getYesMsg = radioBtn.getMsg().getText();
        Assert.assertEquals(getYesMsg, radioBtn.getMsg().getText());

        radioBtn.clickImpressive();
        String getImpressiveMsg = radioBtn.getMsg().getText();
        Assert.assertEquals(getImpressiveMsg, radioBtn.getMsg().getText());

        radioBtn.clickNo();
        String getNoMsg = radioBtn.getMsg().getText();
        Assert.assertNotEquals(getNoMsg, radioBtn.getMsg().getText());
        //ovaj asert pada jer ne postoji jedninstvena poruka za klik na "no" - klik je disabled
    }

    @Test (priority = 80)
    public void doubleClickDCM(){
        buttons.goToBtns(excelReader.getStringData("Pages", 7, 1));
        buttons.doubleClick();

        String expectedMsg = "You have done a double click";
        waitFor(buttons.getDcMsg());

        Assert.assertEquals(expectedMsg, buttons.getDcMsg().getText());
    }

    @Test (priority = 90)
    public void singleClick(){
        buttons.goToBtns(excelReader.getStringData("Pages", 7, 1));
        buttons.singleClick();

        List<WebElement> msgList = driver.findElements(By.id("doubleClickMessage"));
        int expectedSize = 0;

        Assert.assertEquals(msgList.size(), expectedSize);
    }

    @Test(priority = 100)
    public void clickApiReqLinks() throws InterruptedException {
        links.goToLinks(excelReader.getStringData("Pages", 8, 1));
        String respMsg;
        for (int i = 2; i < links.getLinks().size(); i++) {
            scroll(links.getLinks().get(i));
            links.getLinks().get(i).click();
            Thread.sleep(500);
            respMsg = links.getLinkMsg().getText();

            Assert.assertEquals(respMsg, excelReader.getStringData("InputData", i, 5));

        }
    }

    @Test (priority = 110)
    public void verifyThatFileIsUploaded(){
        uploadDownload.goToUpDownload(excelReader.getStringData("Pages", 10, 1));
        uploadDownload.upload("C:\\Users\\DELL\\Desktop\\cap2.PNG");
        waitFor(uploadDownload.getUploadMsg());


        Assert.assertTrue(uploadDownload.getUploadMsg().isDisplayed());
    }

    @Test (priority = 120)
    public void goToForms() throws InterruptedException {
        scroll(homePage.getCards().get(1));
        homePage.clickCard(1);

        String expectedURL = excelReader.getStringData("Pages", 1, 2);
        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, currentURL);
    }







}
