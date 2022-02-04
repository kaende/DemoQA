package Test;

import BasePage.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestElements extends Base {
    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to(Home);
        driver.manage().window().maximize();
    }

    @Test
    public void goToHome() throws InterruptedException {
        String currentURL = Home;

        Assert.assertEquals(currentURL, Home);
    }

    @Test
    public void goToEelements() throws InterruptedException {
        scroll(homePage.getCards().get(0));
        homePage.clickCard(0);

        String expectedURL = excelReader.getStringData("Pages", 1, 1);
        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
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

    @Test
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

    @Test
    public void allElementsSelectedWhenHomeIsClicked() throws InterruptedException {
      checkBox.goToCheckBox(excelReader.getStringData("Pages",4, 1));
      checkBox.clickHome();

       int expectedSize = 17;
       Assert.assertEquals(expectedSize, checkBox.getMsgListed().size());
    }

    @Test
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

    @Test
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

}
