package testHelpers;
import dataAndTests.UserData;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class UserProfileEditHelper extends BaseHelper {

    public UserProfileEditHelper(AppManager manager) {
        super(manager);
    }

    public void userSignIn() {
        driver.manage().window().maximize();
        manager.getNavigationHelper().openMainPage();
        manager.getNavigationHelper().goToLogInForm();
        UserData creds = new UserData("helenkuz1202@gmail.com", "ELeNa0912M");
        manager.getUserProfileEditHelper().fillSignInForm(creds);
        manager.getUserProfileEditHelper().submitLogIn();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void fillSignInForm(UserData credsForSignIn) {
        type(By.id("EmailAddress"), credsForSignIn.getUserEmail());
        type(By.id("Password"), credsForSignIn.getUserPassword());
    }

    public void fillAddAddressForm(UserData credsForSignIn) {
        type(By.id("TelephoneDaytime"),credsForSignIn.getUserPhoneNumber());
        type(By.id("Address1"),credsForSignIn.getUserAddress1());
        type(By.id("Locality"),credsForSignIn.getUserCity());
        type(By.id("PostalCode"),credsForSignIn.getUserCityZipCode());
    }

    public void submitLogIn() {
        click(By.id("signin"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void goToEditAddNewAddress() {
        click(By.id("_ctl0_ContentBody_btnEditAddress"));
    }

    public void submitNewAddress() {
        click(By.id("submit-address"));
    }
}
