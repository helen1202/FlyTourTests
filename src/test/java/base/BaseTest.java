package base;

import application.AppManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Helen on 04.04.2017.
 */
public class BaseTest {

    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static FirefoxProfile profile;
    protected AppManager appManager;

    @BeforeTest
    public void setUp() throws Exception {

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        appManager = new AppManager(new FirefoxDriver(profile));
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        baseUrl = "http://us.asos.com";
        appManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterTest
    public void tearDown() throws Exception {
        appManager.getDriver().close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            appManager.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            appManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = appManager.getDriver().switchTo().alert();
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

    public void fillAddAddressForm(UserData credsForSignIn) {
        appManager.getDriver().findElement(By.id("TelephoneDaytime")).isEnabled();
        appManager.getDriver().findElement(By.id("TelephoneDaytime")).sendKeys(credsForSignIn.getUserPhoneNumber());
        appManager.getDriver().findElement(By.id("Address1")).isEnabled();
        appManager.getDriver().findElement(By.id("Address1")).sendKeys(credsForSignIn.getUserAddress1());
        appManager.getDriver().findElement(By.id("Locality")).isEnabled();
        appManager.getDriver().findElement(By.id("Locality")).sendKeys(credsForSignIn.getUserCity());
        appManager.getDriver().findElement(By.id("PostalCode")).isEnabled();
        appManager.getDriver().findElement(By.id("PostalCode")).sendKeys(credsForSignIn.getUserCityZipCode());

    }

    public void submitLogIn() {
        appManager.getDriver().findElement(By.id("signin")).click();
        appManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void goToLogInForm() {
        appManager.getDriver().findElement(By.partialLinkText("Sign In")).click();
    }

    public void openMainPage() {
        appManager.getDriver().get(baseUrl);
    }

    public void goToMarketPlaceVintageBoutique() {
        appManager.getDriver().findElement(By.className("close")).click();
        appManager.getDriver().findElement(By.linkText("Marketplace")).click();
        appManager.getDriver().findElement(By.cssSelector("li.boutiques > a.tab > span")).click();
        appManager.getDriver().findElement(By.cssSelector("li.boutiques > a.tab > span")).click();
        appManager.getDriver().findElement(By.linkText("Vintage")).click();
    }

    public void userLogOut() {
        appManager.getDriver().findElement(By.linkText("sign out")).click();
    }

    public void goToAccLink() {
        appManager.getDriver().findElement(By.linkText("My Account")).click();
    }

    public void goToEditAddNewAddress() {
        appManager.getDriver().findElement(By.id("_ctl0_ContentBody_btnEditAddress")).click();
       // appManager.getDriver().findElement(By.partialLinkText("edit")).click();
    }
    public void gotoAddAddressForm() {
        appManager.getDriver().get("https://my.asos.com/address/add?checkout=false");
        // appManager.getDriver().findElement(By.xpath("//div[4]/div/a")).click();
    }
    public void submitNewAddress() {
        appManager.getDriver().findElement(By.id("submit-address")).click();
    }



}
