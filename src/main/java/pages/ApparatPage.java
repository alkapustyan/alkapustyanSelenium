package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparatPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithWebElements actionWithWebElements;
    By addNewApparatButtonXpath = By.xpath("//div[@class='box-tools']");
    By apparatNumberFieldId = By.id("apparat_apparatNumber");
    By apparatCommentFieldId = By.id("apparat_apparatComment");

    //Вставить Искомый текст
    By deleteRowXpath = By.xpath("//table[@id='device_list']//tbody//td[contains(text(),'Искомый текст')]");
    //Вставить Искомый текст
    By editRowXpath = By.xpath("//table[@id='device_list']//tbody//td[contains(text(),'Искомый текст')]");

    By submitButtonXpath = By.xpath("//button[@type ='submit']");
    By deleteButtonName = By.name("delete");
    By saveButtonName = By.name("save");

    String url = "http://v3.test.itpmgroup.com/dictionary/apparat";

    public ApparatPage(WebDriver webDriver){
        this.webDriver = webDriver;
        actionWithWebElements = new ActionWithWebElements(webDriver);
    }

    public void openPage(){
        try {
            webDriver.get(url);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void inputNumberOfApparat(String text){
        actionWithWebElements.enterTextToTextField(apparatNumberFieldId,text);
    }

    public void inputCommentOfApparat(String text){
        actionWithWebElements.enterTextToTextField(apparatCommentFieldId, text);
    }

    public void clickSubmitButton(){
        actionWithWebElements.clckButton(submitButtonXpath);
    }

    public void clickAddButton(){
        actionWithWebElements.clckButton(addNewApparatButtonXpath);
    }

    public void clickDeleteButton(){
        actionWithWebElements.clckButton(deleteButtonName);
    }
    public void clickRow(By row){
        actionWithWebElements.clckButton(row);
    }
    public void clickSaveButton(){
        actionWithWebElements.clckButton(saveButtonName);
    }

    public void addNewApparat(String number, String comment){
        openPage();
        clickAddButton();
        inputNumberOfApparat(number);
        inputCommentOfApparat(comment);
        clickSubmitButton();
    }

    public void editApparat (By row, String number, String comment){
        openPage();
        clickRow(row);
        inputNumberOfApparat(number);
        inputCommentOfApparat(comment);
        clickSaveButton();
    }

    public void deleteApparat (By row){
        openPage();
        clickRow(row);
        clickDeleteButton();
    }

}
