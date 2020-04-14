package suits;

import loginTests.LoginWithPageObjecUpperLogin;
import loginTests.LoginWithPageObjecWrongLogin;
import loginTests.LoginWithPageObjectTest;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjecUpperLogin.class,
                LoginWithPageObjecWrongLogin.class,
                LoginWithPageObjectTest.class
        }
)

public class LoginSuit {
}
