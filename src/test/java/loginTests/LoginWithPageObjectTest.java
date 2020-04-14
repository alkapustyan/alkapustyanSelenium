package loginTests;

import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTests.AbstractParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");

        loginPage.loginToPage(dataForValidLogin.get("login"), dataForValidLogin.get("pass"));
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }
    /*
    public void validLogin(){
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    */
}
