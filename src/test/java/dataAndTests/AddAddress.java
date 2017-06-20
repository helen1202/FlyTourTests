package dataAndTests;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class AddAddress extends BaseTest {

    @Test
    public void testAddAddress() throws Exception {
        // CHECKING: save old state
    List<UserData> oldList =  app.getUserProfileEditHelper().getUserAddress();
        System.out.println(oldList);

         //CHECKING: actions
         app.getNavigationHelper().goToAccLink();
         app.getUserProfileEditHelper().goToAddressBook();
         app.getNavigationHelper().gotoAddEditAddressForm();
         UserData creds = new UserData("San Francisco", "John Avenue, 9", "7808658796", "10044");
         app.getUserProfileEditHelper().fillAddAddressForm(creds);
         app.getUserProfileEditHelper().submitNewAddress();

        //CHECKING: save new state
       List<UserData> newList =  app.getUserProfileEditHelper().getUserAddress();



          // CHECKING: compare states
      assertEquals(newList.size(),oldList.size()+1);
    }
}



