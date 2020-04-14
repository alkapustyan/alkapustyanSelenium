package navigationPanelTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import parentTests.AbstractParentTest;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HideShowPanelWithPageObjectTest extends AbstractParentTest {

    @Test
    public void hideShowNavigationPanelSuccess() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");

        loginPage.loginToPage(dataForValidLogin.get("login"), dataForValidLogin.get("pass"));
        checkExpectedResult("Navigation panel is not displayed after login",navigationPanel.stateOfNavigationPanel());

        navigationPanel.hideNavigationPanel();
        Assert.assertFalse("Navigation panel is not hide",navigationPanel.stateOfNavigationPanel());

        navigationPanel.showNavigationPanel();
        Assert.assertTrue("Navigation panel is not open", navigationPanel.stateOfNavigationPanel());

    }

}
