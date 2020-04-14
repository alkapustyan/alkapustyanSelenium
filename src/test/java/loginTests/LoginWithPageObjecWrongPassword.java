package loginTests;

import org.junit.Test;
import parentTests.AbstractParentTest;

public class LoginWithPageObjecWrongPassword extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("9090901111");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is present", loginPage.isLoginBoxRefreshed());
    }
}
