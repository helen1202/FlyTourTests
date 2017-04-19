import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Helen on 04.04.2017.
 */
public class BaseTest {
    private static WebDriver driver;
    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static FirefoxProfile profile;

    @BeforeTest
    public void setUp() throws Exception {

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(profile);
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        baseUrl = "http://us.asos.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterTest
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

    public void userSignIn(CredentialsForSignIn credsForSignIn) {
        driver.findElement(By.id("EmailAddress")).isEnabled();;
        driver.findElement(By.id("EmailAddress")).sendKeys(credsForSignIn.getUserEmail());
        driver.findElement(By.id("Password")).isEnabled();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(credsForSignIn.getUserPassword());
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
        driver.findElement(By.linkText("Vintage")).click();
    }

    public void userLogOut() {
        driver.findElement(By.linkText("sign out")).click();
    }

}
