package dataAndTests;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class AddAddress extends BaseTest {

    @Test
    public void testAddAddress() throws Exception {
        // save old state
  List<UserData> oldList =  app.getUserProfileEditHelper().getUserAddress();

         // actions
         app.getNavigationHelper().goToAccLink();
         app.getUserProfileEditHelper().goToAddressBook();
         app.getNavigationHelper().gotoAddEditAddressForm();
         UserData creds = new UserData("San Francisco", "John Avenue, 9", "7808658796", "10044");
         app.getUserProfileEditHelper().fillAddAddressForm(creds);
         app.getUserProfileEditHelper().submitNewAddress();

        //save new state
       List<UserData> newList =  app.getUserProfileEditHelper().getUserAddress();



          // compare states
      assertEquals(newList.size(),oldList.size()+1);
    }
}



