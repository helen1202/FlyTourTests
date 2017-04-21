package base;

import org.testng.annotations.Test;

/**
 * Created by ekuznetsova on 4/10/2017.
 */
public class UserSignIn extends BaseTest {

    @Test
    public void testUserSignIn() throws Exception {
        appManager.openMainPage();
        appManager.goToLogInForm();
        UserData creds = new UserData("helenkuz1202@gmail.com", "ELeNa0912M");
        appManager.fillSignInForm(creds);
        appManager.submitLogIn();
    }

    @Test
    public void testAddAddress() throws Exception {

         appManager.goToAccLink();
         appManager.goToEditAddNewAddress();
         appManager.gotoAddAddressForm();
         UserData creds = new UserData("Chicago", "St. Main, 25, app. 9", "380959294710", "80999");
         appManager.fillAddAddressForm(creds);
         appManager.submitNewAddress();
    }
}



