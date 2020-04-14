package apparatPageTests;

import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Test;
import parentTests.AbstractParentTest;

import java.io.IOException;
import java.util.Map;

public class AddNewApparatWithPageObjectTest extends AbstractParentTest {

    @Test
    public void addNewApparatToPage() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");
        Map<String, String> dataForAddNewApparat = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "newApparat");

        loginPage.loginToPage(dataForValidLogin.get("login"), dataForValidLogin.get("pass"));
        //navigationPanel.selectApparatFromDDSlovari();
        navigationPanel.selectApparatFromMenuManual();
        apparatPage.addNewApparat(dataForAddNewApparat.get("number"), dataForAddNewApparat.get("comment"));
        checkExpectedResult("New apparat wasn't add to page", apparatPage.isNewApparatOnPage(dataForAddNewApparat.get("number"), dataForAddNewApparat.get("comment")));

    }
}
