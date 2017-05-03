package dataAndTests;

import org.testng.annotations.Test;

public class UserLogout extends BaseTest {

    @Test
    public void testUserLogOut() throws Exception {
        app.getNavigationHelper().userLogOut();
    }
}

