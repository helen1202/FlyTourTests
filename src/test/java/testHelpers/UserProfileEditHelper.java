package testHelpers;
import dataAndTests.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
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

    public void goToAddressBook() {
        click(By.id("_ctl0_ContentBody_btnEditAddress"));
    }

    public void submitNewAddress() {
        click(By.id("submit-address"));
    }

    public void deleteAddress () {
        click(By.xpath("//*[@id=\"content\"]/div[5]/div[3]/div[5]/form/div/input[2]"));
    }

    public List<UserData> getUserAddress() {
        List <UserData> userData = new ArrayList<UserData>();
        List <WebElement> userAddresses = driver.findElements(By.cssSelector("span[id*='FullCustomerName']"));
        for (WebElement userAddress:userAddresses) {
            UserData userDataSearch =  new UserData();
            userDataSearch.getUserAddress1(); // на 24:45 видео
            userData.add(userDataSearch);
        }
        return userData;
    }
}
