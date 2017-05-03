package testHelpers;
import dataAndTests.UserData;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class UserProfileEditHelper extends BaseHelper {

    public UserProfileEditHelper(AppManager manager) {
        super(manager);
    }

    public void userSignIn() {
        manager.getNavigationHelper().openMainPage();
        manager.getNavigationHelper().goToLogInForm();
        UserData creds = new UserData("helenkuz1202@gmail.com", "ELeNa0912M");
        manager.getUserProfileEditHelper().fillSignInForm(creds);
        manager.getUserProfileEditHelper().submitLogIn();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void fillSignInForm(UserData credsForSignIn) {
        driver.findElement(By.id("EmailAddress")).isEnabled();
        driver.findElement(By.id("EmailAddress")).sendKeys(credsForSignIn.getUserEmail());
        driver.findElement(By.id("Password")).isEnabled();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(credsForSignIn.getUserPassword());
    }

    public void fillAddAddressForm(UserData credsForSignIn) {
        driver.findElement(By.id("TelephoneDaytime")).isEnabled();
        driver.findElement(By.id("TelephoneDaytime")).sendKeys(credsForSignIn.getUserPhoneNumber());
        driver.findElement(By.id("Address1")).isEnabled();
        driver.findElement(By.id("Address1")).sendKeys(credsForSignIn.getUserAddress1());
        driver.findElement(By.id("Locality")).isEnabled();
        driver.findElement(By.id("Locality")).sendKeys(credsForSignIn.getUserCity());
        driver.findElement(By.id("PostalCode")).isEnabled();
        driver.findElement(By.id("PostalCode")).sendKeys(credsForSignIn.getUserCityZipCode());

    }

    public void submitLogIn() {
        driver.findElement(By.id("signin")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void goToEditAddNewAddress() {
        driver.findElement(By.id("_ctl0_ContentBody_btnEditAddress")).click();
       // app.getDriver().findElement(By.partialLinkText("edit")).click();
    }

    public void submitNewAddress() {
        driver.findElement(By.id("submit-address")).click();
    }
}
