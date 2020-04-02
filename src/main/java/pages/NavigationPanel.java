package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithWebElements actionWithWebElements;
    By slidebarToggleXpath = By.xpath("//a[@class='sidebar-toggle']");
    By slidebarOpenXpath = By.xpath("//body[@class='skin-blue']");
    By slidebarCloseXpath = By.xpath("//body[@class='skin-blue sidebar-collapse']");
    By dictionaryListId = By.id("dictionary");
    String apparat = "Аппарат";

    public NavigationPanel(WebDriver webDriver){
        this.webDriver = webDriver;
        actionWithWebElements = new ActionWithWebElements(webDriver);
    }

    public void hideNavigationPanel(){
        if (actionWithWebElements.isElementDisplay(slidebarOpenXpath)) {
            if (actionWithWebElements.isElementEnable(slidebarToggleXpath)) {
                actionWithWebElements.clckButton(slidebarToggleXpath);
            }
        }
    }

    public void showNavigationPanel(){
        if (actionWithWebElements.isElementDisplay(slidebarCloseXpath)) {
            if (actionWithWebElements.isElementEnable(slidebarToggleXpath)) {
                actionWithWebElements.clckButton(slidebarToggleXpath);
            }
        }
    }

    public void selectApparatFromDDSlovari (){
        actionWithWebElements.selectElementFromDD(dictionaryListId, apparat);
    }

}
