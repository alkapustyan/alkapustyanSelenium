package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithWebElements actionWithWebElements;
    By inputLoginName = By.name("_username");
    By inputPasswordName = By.name("_password");
    By inputButtonXpath = By.xpath(".//button[@type = 'submit']");
    String url = "http://v3.test.itpmgroup.com";

    public LoginPage(WebDriver webDriver){
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
    public void inputLogin(String text){
        actionWithWebElements.enterTextToTextField(inputLoginName,text);
    }

    public void inputPassword(String text){
        actionWithWebElements.enterTextToTextField(inputPasswordName, text);
    }

    public void clickSubmitButton(){
        actionWithWebElements.clckButton(inputButtonXpath);
    }

    public void loginToPage(String login, String password){
        openPage();
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();
    }

}
