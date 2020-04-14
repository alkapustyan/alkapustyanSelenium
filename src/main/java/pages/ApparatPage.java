package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ApparatPage extends ParentPage {
    //protected WebDriver webDriver;
    //protected Logger logger = Logger.getLogger(getClass());
    //protected ActionWithWebElements actionWithWebElements;
    //By addNewApparatButtonXpath = By.xpath("//div[@class='box-tools']");

    @FindBy(xpath = "//h1[contains(text(),'Аппарат')]")
    private WebElement apparatPageXpath;

    @FindBy(xpath = "//div[@class='box-tools']")
    private WebElement addNewApparatButtonXpath;

    //By apparatNumberFieldId = By.id("apparat_apparatNumber");
    @FindBy(id = "apparat_apparatNumber")
            private WebElement apparatNumberFieldId;

    //By apparatCommentFieldId = By.id("apparat_apparatComment");
    @FindBy(id = "apparat_apparatComment")
            private WebElement apparatCommentFieldId;

    //Вставить Искомый текст
    //By deleteRowXpath = By.xpath("//table[@id='device_list']//tbody//td[contains(text(),'Искомый текст')]");
    @FindBy(xpath = "//td[2][contains(text(),'Искомый comment')]")
            private WebElement searchRowByCommentXpath;
    String rowCommentBegin = "//td[2][contains(text(),'";
    String rowCommentEnd = "')]";

    //By submitButtonXpath = By.xpath("//button[@type ='submit']");
    @FindBy(xpath = "//button[@type ='submit']")
            private WebElement submitButtonXpath;

    //By deleteButtonName = By.name("delete");
    @FindBy(name = "delete")
            private WebElement deleteButtonName;

    //By saveButtonName = By.name("save");
    @FindBy(name = "save")
            private WebElement saveButtonName;


    @FindBy(xpath = "//table[@id='device_list']//tbody/tr[last()]/td[1]")
            private WebElement lastRowNumberXpath;


    @FindBy(xpath = "//table[@id='device_list']//tbody/tr[last()]/td[2]")
            private WebElement lastRowCommentXpath;


    String url = "http://v3.test.itpmgroup.com/dictionary/apparat";

    public ApparatPage(WebDriver webDriver){
        //this.webDriver = webDriver;
        //actionWithWebElements = new ActionWithWebElements(webDriver);
        super(webDriver);
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
        actionWithWebElements.clickButton(submitButtonXpath);
    }

    public void clickAddButton(){
        actionWithWebElements.clickButton(addNewApparatButtonXpath);
    }

    public void clickDeleteButton(){
        actionWithWebElements.clickButton(deleteButtonName);
    }
    public void clickRow(WebElement row){
        actionWithWebElements.clickButton(row);
    }
    public void clickSaveButton(){
        actionWithWebElements.clickButton(saveButtonName);
    }

    public void addNewApparat(String number, String comment){
        //openPage();
        clickAddButton();
        inputNumberOfApparat(number);
        inputCommentOfApparat(comment);
        clickSubmitButton();
    }

    public void editApparat (WebElement row, String number, String comment){
        openPage();
        clickRow(row);
        inputNumberOfApparat(number);
        inputCommentOfApparat(comment);
        clickSaveButton();
    }

    public void deleteApparat (WebElement row){
        openPage();
        clickRow(row);
        clickDeleteButton();
    }

    public boolean isApparatDisplayed(){
        return actionWithWebElements.isElementDisplay(apparatPageXpath);
    }

    public boolean isNewApparatOnPage(String number, String comment){
        if (actionWithWebElements.getTextFromElement(lastRowNumberXpath).equals(number) && actionWithWebElements.getTextFromElement(lastRowCommentXpath).equals(comment)) {
            return true;
        }
        else {
            return false;
        }
    }
// Метод реализован с предположением, что все комментарии уникальны. Если это не так, нужна доработка для поиска уникальной связки номмер-комментарий
    public WebElement searchRowByCommentXpath(String comment){
                return  actionWithWebElements.searchElement(pathConstract(comment));
    }

    public boolean isRowPresentOnPage(String comment) {
        try {
            webDriver.findElement(pathConstract(comment));
                return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public By pathConstract(String comment){
        String rowXpath = rowCommentBegin + comment + rowCommentEnd;
        By pathToRow = By.xpath(rowXpath);
        return pathToRow;
    }
}
