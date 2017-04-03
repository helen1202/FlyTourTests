import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
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

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        baseUrl = "http://newtours.demoaut.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void fillRegistrationForm(CredentialsForRegistration regCredentials) {
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys(regCredentials.getFirstName());
        driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys(regCredentials.getLastName());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(regCredentials.getPhoneNumber());
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys(regCredentials.getContactEmail());
        driver.findElement(By.name("address1")).clear();
        driver.findElement(By.name("address1")).sendKeys(regCredentials.getAddress());
        driver.findElement(By.name("postalCode")).clear();
        driver.findElement(By.name("postalCode")).sendKeys(regCredentials.getPostalCode());
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(regCredentials.getUserEmail());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(regCredentials.getUserPassword());
        driver.findElement(By.name("confirmPassword")).clear();
        driver.findElement(By.name("confirmPassword")).sendKeys(regCredentials.getPasswordConfirmation());
    }

    public void submitRegistration() {
        driver.findElement(By.name("register")).click();
    }

    public void goToRegistrationForm() {
        driver.findElement(By.linkText("REGISTER")).click();
    }

    public void openMainPage() {
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
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
