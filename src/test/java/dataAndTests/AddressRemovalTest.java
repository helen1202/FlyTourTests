package dataAndTests;
import dataAndTests.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddressRemovalTest extends BaseTest {
    @Test
    public void deleteUserAddress() {
        // COMPARING sizes of old and new lists (when + 1 address was added)
        // CHECKING: save old state
        List<UserData> oldList =  app.getUserProfileEditHelper().getUserAddress();
        System.out.println(oldList);

        //CHECKING: actions
        app.getNavigationHelper().goToAccLink();
        app.getUserProfileEditHelper().goToAddressBook();
        app.getUserProfileEditHelper().deleteAddress();
        app.getNavigationHelper().acceptAlert();
        app.getNavigationHelper().openMainPage();
        //CHECKING: save new state
        List<UserData> newList =  app.getUserProfileEditHelper().getUserAddress();
        // CHECKING: compare states
        assertEquals(newList.size(),oldList.size()+1);

        // COMPARING contents of old and new lists (when + 1 address was added)
        // CHECKING: save old state
        oldList.add(newUserContacts);
        assertEquals(newList, oldList);
    }


}
