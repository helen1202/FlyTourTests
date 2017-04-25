package application;
import org.testng.annotations.Test;
public class AddAddress extends BaseTest {

    @Test
    public void testAddAddress() throws Exception {

         app.navigationHelper.goToAccLink();
         app.userProfileEditHelper.goToEditAddNewAddress();
         app.navigationHelper.gotoAddAddressForm();
         UserData creds = new UserData("San Diego", "St. Main, 25, app. 9", "380967859961", "77999");
         app.userProfileEditHelper.fillAddAddressForm(creds);
         app.userProfileEditHelper.submitNewAddress();
    }
}



