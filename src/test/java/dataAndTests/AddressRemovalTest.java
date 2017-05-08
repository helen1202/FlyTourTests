package dataAndTests;
import dataAndTests.BaseTest;
import org.testng.annotations.Test;

public class AddressRemovalTest extends BaseTest {
    @Test
    public void deleteUserAddress() {
        app.getNavigationHelper().goToAccLink();
        app.getUserProfileEditHelper().goToAddressBook();
        app.getUserProfileEditHelper().deleteAddress();
        app.getNavigationHelper().acceptAlert();
        app.getNavigationHelper().openMainPage();
    }

}
