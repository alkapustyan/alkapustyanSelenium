package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ActionWithWebElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void enterTextToTextField(By element, String text){
        try {
            webDriver.findElement(element).clear();
            webDriver.findElement(element).sendKeys(text);
            logger.info("");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void clckButton(By element){
        try {
            webDriver.findElement(element).click();
            logger.info("");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementDisplay(By element){
        try {
            return webDriver.findElement(element).isDisplayed();

        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(By element, boolean state){
        try {
            if (webDriver.findElement(element).isDisplayed()) {
                if (webDriver.findElement(element).isEnabled()) {
                    if (webDriver.findElement(element).isSelected() == state) {

                    } else {
                        webDriver.findElement(element).click();
                    }
                }
                else {
                    logger.warn("The check box is not enabled");
                }
            }
            else {
                logger.warn("The check box is not displayed");
            }
            logger.info("The check box expected status: "+ state);
            logger.info("The check box actual status: "+ webDriver.findElement(element).isSelected());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void selectElementFromDD(By element, String itemName){
        Select dropDownValue = new Select(webDriver.findElement(element));
        try {
            dropDownValue.selectByVisibleText(itemName);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementEnable(By element){
        try {
            return webDriver.findElement(element).isEnabled();
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }
//метод применим только для rb, у которых не установлено значение по умолчанию
    public void setRadioButton(By element, boolean state){
        try {
            if (webDriver.findElement(element).isDisplayed()) {
                if (webDriver.findElement(element).isEnabled()) {
                    if (webDriver.findElement(element).isSelected() == state) {

                    } else {
                        webDriver.findElement(element).click();
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
            logger.info("The radio button actual status: "+ webDriver.findElement(element).isSelected());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }



}
