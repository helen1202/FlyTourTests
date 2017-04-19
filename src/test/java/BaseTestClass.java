import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Helen on 04.04.2017.
 */
public class BaseTestClass {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private FirefoxProfile profile;

    @BeforeClass
    public void setUp() throws Exception {

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(profile);
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        baseUrl = "http://us.asos.com/women";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void userSignIn(CredentialsForSignIn credsForSignIn) {
        driver.findElement(By.id("EmailAddress")).isEnabled();;
        driver.findElement(By.id("EmailAddress")).sendKeys(credsForSignIn.getUserEmail());
        driver.findElement(By.id("Password")).isEnabled();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(credsForSignIn.getUserPassword());
    }
    public void submitLogIn() {
       WebElement elementLogIn = driver.findElement(By.id("signin"));
       elementLogIn.click();
   }

    public void goToLogInForm() {
        WebElement element = driver.findElement(By.partialLinkText("Sign In"));
        element.click();
    }

    public void openMainPage() {
        driver.get(baseUrl);
    }

    public void goToMarketPlace () {
        WebElement element1 = driver.findElement(By.className("close"));
        element1.click();
        WebElement element2 = driver.findElement(By.linkText("https://marketplace.asos.com/?CTARef=Global%20Nav"));
        element2.click();
    }

    public void goToShopWomenDresses () {
        WebElement element1 = driver.findElement(By.linkText("http://us.asos.com/women/"));
        element1.click();
        WebElement element2 = driver.findElement(By.partialLinkText("dresses"));
        element2.click();
    }

    public void logOut() {
        WebElement element = driver.findElement(By.className("sign-out"));
        element.click();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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
}
