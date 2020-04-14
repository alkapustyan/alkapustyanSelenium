package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionWithWebElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver,10);
        webDriverWait_15 = new WebDriverWait(webDriver,15);

    }

    public void enterTextToTextField(WebElement element, String text){
        try {
            //webDriver.findElement(element).clear();
            //webDriver.findElement(element).sendKeys(text);
            element.clear();
            element.sendKeys(text);
            logger.info("");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void clickButton(WebElement element){
        try {
            //webDriver.findElement(element).click();
            webDriverWait_10.until(ExpectedConditions.visibilityOf(element));
            element.click();
            logger.info("");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementDisplay(WebElement element){
        try {
            return element.isDisplayed();
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state){
        try {
                if (element.isSelected() == state) {

                    } else {
                        element.click();
                    }
            logger.info("The check box expected status: "+ state);
            logger.info("The check box actual status: "+ element.isSelected());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void selectElementFromDD(WebElement element, String itemName){
        Select dropDownValue = new Select(element);
        try {
            dropDownValue.selectByVisibleText(itemName);

        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementEnable(WebElement element){

        try {
            //!!!!!!!!!!!!!!!явное ожидание!!!!!!!!!!
            webDriverWait_15.until(ExpectedConditions.visibilityOf(element));

            return element.isEnabled();
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }
//метод применим только для rb, у которых не установлено значение по умолчанию
    public void setRadioButton(WebElement element, boolean state){
        try {
            if (element.isDisplayed()) {
                if (element.isEnabled()) {
                    if (element.isSelected() == state) {

                    } else {
                        element.click();
                    }
                }
                else {
                    logger.warn("The radio button is not enabled");
                }
            }
            else {
                logger.warn("The radio button is not displayed");
            }
            logger.info("The radio button expected status: "+ state);
            logger.info("The radio button actual status: "+ element.isSelected());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public WebElement searchElement(By by){

        return webDriver.findElement(by);

    }



}
