package apparatPageTests;

import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTests.AbstractParentTest;

import java.io.IOException;
import java.util.Map;

public class DeleteApparatWithPageObjectTest extends AbstractParentTest {

    @Test
    public void deleteApparatFromPage()  throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");
        Map<String, String> dataForDeleteApparat = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "deleteApparat");

        loginPage.loginToPage(dataForValidLogin.get("login"), dataForValidLogin.get("pass"));
        //navigationPanel.selectApparatFromDDSlovari();
        navigationPanel.selectApparatFromMenuManual();
        checkExpectedResult("Page Apparat is not displayed", apparatPage.isApparatDisplayed());

        if (apparatPage.isRowPresentOnPage(dataForDeleteApparat.get("comment"))){
            apparatPage.clickRow(apparatPage.searchRowByCommentXpath(dataForDeleteApparat.get("comment")));
            apparatPage.clickDeleteButton();
            Assert.assertFalse("Row is still present on page", apparatPage.isRowPresentOnPage(dataForDeleteApparat.get("comment")));
        }
        else {
            System.out.println("Can't find row");
            Assert.assertTrue("Can't find row", apparatPage.isRowPresentOnPage(dataForDeleteApparat.get("comment")));
        }

    }
}
