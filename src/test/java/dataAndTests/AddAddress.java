package dataAndTests;
import org.testng.annotations.Test;
public class AddAddress extends BaseTest {

    @Test
    public void testAddAddress() throws Exception {

         app.getNavigationHelper().goToAccLink();
         app.getUserProfileEditHelper().goToEditAddNewAddress();
         app.getNavigationHelper().gotoAddAddressForm();
         UserData creds = new UserData("San Diego", "St. Main, 25, app. 9", "380967859961", "77999");
         app.getUserProfileEditHelper().fillAddAddressForm(creds);
         app.getUserProfileEditHelper().submitNewAddress();
    }
}



