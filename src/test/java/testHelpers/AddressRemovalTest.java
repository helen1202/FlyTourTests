package testHelpers;
import dataAndTests.BaseTest;
import org.testng.annotations.Test;

public class AddressRemovalTest extends BaseTest {
    @Test
    public void deleteUserAddress() {
        app.getNavigationHelper().goToAccLink();
        app.getNavigationHelper().gotoAddEditAddressForm();
        app.getUserProfileEditHelper().deleteAddress();
    }

}
