package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class NavigationPanel extends ParentPage{
    //protected WebDriver webDriver;
    //protected Logger logger = Logger.getLogger(getClass());
    //protected ActionWithWebElements actionWithWebElements;
    //By slidebarToggleXpath = By.xpath("//a[@class='sidebar-toggle']");
    @FindBy(xpath = "//a[@class='sidebar-toggle']")
            private WebElement slidebarToggleXpath;

    //By slidebarOpenXpath = By.xpath("//body[@class='skin-blue']");
    @FindBy(xpath = "//body[@class='skin-blue']")
            private WebElement slidebarOpenXpath;

    //By slidebarCloseXpath = By.xpath("//body[@class='skin-blue sidebar-collapse']");
    @FindBy(xpath = "//body[@class='skin-blue sidebar-collapse']")
            private WebElement slidebarCloseXpath;

    //By dictionaryListId = By.id("dictionary");
    @FindBy(id = "dictionary")
            private WebElement dictionaryListId;


    //@FindBy(xpath = "//li[@id='dictionary' and @class='treeview']")
    //        private WebElement dictionaryListCloseXpath;


    @FindBy(xpath = "//li[@id='dictionary' and @class='treeview active']")
            private WebElement dictionaryListOpenXpath;


    @FindBy(id = "apparat")
            private WebElement itemApparatId;

    String apparat = "Аппарат";


    public NavigationPanel(WebDriver webDriver){
        //this.webDriver = webDriver;
        //actionWithWebElements = new ActionWithWebElements(webDriver);
        super(webDriver);
    }

    public void hideNavigationPanel(){
        if (actionWithWebElements.isElementDisplay(slidebarOpenXpath)) {
            if (actionWithWebElements.isElementEnable(slidebarToggleXpath)) {
                actionWithWebElements.clickButton(slidebarToggleXpath);
            }
        }
    }

    public void showNavigationPanel(){
        if (actionWithWebElements.isElementDisplay(slidebarCloseXpath)) {
            if (actionWithWebElements.isElementEnable(slidebarToggleXpath)) {
                actionWithWebElements.clickButton(slidebarToggleXpath);
            }
        }
    }

    public boolean stateOfNavigationPanel(){
        if (actionWithWebElements.isElementDisplay(slidebarOpenXpath)){
            return true;
        }
        else {
            return false;
        }
    }

    public void selectApparatFromDDSlovari (){
        actionWithWebElements.selectElementFromDD(dictionaryListId, apparat);
    }

    public void selectApparatFromMenuManual(){
        actionWithWebElements.clickButton(dictionaryListId);
        actionWithWebElements.clickButton(itemApparatId);
    }

}
