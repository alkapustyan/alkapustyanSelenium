package pages;

import libs.ActionWithWebElements;
import libs.ConfigClass;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;


public class LoginPage extends ParentPage {
    //protected WebDriver webDriver;
    //protected Logger logger = Logger.getLogger(getClass());
    //protected ActionWithWebElements actionWithWebElements;

    //By inputLoginName = By.name("_username");
    @FindBy(name = "_username")
    private WebElement  inputLoginName;

    //By inputPasswordName = By.name("_password");
    @FindBy(name = "_password")
    private WebElement  inputPasswordName;

    //By inputButtonXpath = By.xpath(".//button[@type = 'submit']");
    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement  inputButtonXpath;

    @FindBy(xpath = ".//div[@class='login-box-body']")
            private WebElement loginBox;

    //String url = "http://v3.test.itpmgroup.com";

    public LoginPage(WebDriver webDriver){
        // в подобном конструкторе super всегда должен идти первым
        super(webDriver);
        //this.webDriver = webDriver;
        //actionWithWebElements = new ActionWithWebElements(webDriver);
    }

    public void openPageLogin(){
        try{
            webDriver.get(ConfigClass.getCfgValue("base_url") + "/login");
        }
        catch (Exception e){
            logger.error("Can not open URL");
            Assert.fail("Can not open URL");
        }
    }

    /*
    public void openPage(){
        try {
            webDriver.get(url);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

     */
    public void inputLogin(String text){
        actionWithWebElements.enterTextToTextField(inputLoginName,text);
    }

    public void inputPassword(String text){
        actionWithWebElements.enterTextToTextField(inputPasswordName, text);
    }

    public void clickSubmitButton(){
        actionWithWebElements.clickButton(inputButtonXpath);
    }

    public boolean isLoginBoxRefreshed(){
    return actionWithWebElements.isElementDisplay(loginBox);
    }

    public void loginToPage(String login, String password){
        openPageLogin();
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();
    }

}
