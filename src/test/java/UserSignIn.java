import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by ekuznetsova on 4/10/2017.
 */
public class UserSignIn extends BaseTest {

    @Test
    public void testUserSignIn() throws Exception {
        openMainPage();
        goToLogInForm();
        UserData creds = new UserData("helenkuz1202@gmail.com", "ELeNa0912M");
        fillSignInForm(creds);
        submitLogIn();
    }

    @Test
    public void testAddAddress() throws Exception {

         goToAccLink();
         goToEditAddNewAddress();
         gotoAddAddressForm();
         UserData creds = new UserData("Chicago", "St. Main, 25, app. 9", "380959294710", "80999");
         fillAddAddressForm(creds);
         submitNewAddress();
    }
}



