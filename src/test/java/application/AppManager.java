package application;
import base.UserData;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class AppManager {

    private WebDriver driver;
    private static String baseUrl = "http://us.asos.com";
    private static boolean acceptNextAlert = true;
    private static FirefoxProfile profile;
    private static StringBuffer verificationErrors = new StringBuffer();

    public AppManager() {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(profile);
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

    public void goToLogInForm() {
        driver.findElement(By.partialLinkText("Sign In")).click();
    }

    public void openMainPage() {
        driver.get(baseUrl);
    }

    public void goToMarketPlaceVintageBoutique() {
        driver.findElement(By.className("close")).click();
        driver.findElement(By.linkText("Marketplace")).click();
        driver.findElement(By.cssSelector("li.boutiques > a.tab > span")).click();
        driver.findElement(By.cssSelector("li.boutiques > a.tab > span")).click();
        driver.findElement(By.linkText("Vintage Boutiques")).click();

    }

    public void goToAccLink() {
        driver.findElement(By.linkText("My Account")).click();
    }

    public void goToEditAddNewAddress() {
        driver.findElement(By.id("_ctl0_ContentBody_btnEditAddress")).click();
       // appManager.getDriver().findElement(By.partialLinkText("edit")).click();
    }

    public void gotoAddAddressForm() {
        driver.get("https://my.asos.com/address/add?checkout=false");
        // appManager.getDriver().findElement(By.xpath("//div[4]/div/a")).click();
    }

    public void submitNewAddress() {
        driver.findElement(By.id("submit-address")).click();
    }

    public void userLogOut() {
        driver.findElement(By.linkText("sign out")).click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void stop() {
       driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
