package apparatPageTests;

import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentTests.AbstractParentTest;

import java.io.IOException;
import java.util.Map;

public class FromHomeToApparatWithPageObjectTest extends AbstractParentTest {

    @Test
    public void fromHomeToApparatPage() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");

        loginPage.loginToPage(dataForValidLogin.get("login"), dataForValidLogin.get("pass"));
        //navigationPanel.selectApparatFromDDSlovari();
        navigationPanel.selectApparatFromMenuManual();
        checkExpectedResult("Page Apparat is not displayed", apparatPage.isApparatDisplayed());

    }
}
