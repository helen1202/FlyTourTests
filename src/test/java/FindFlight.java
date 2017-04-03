/**
 * Created by Helen on 03.04.2017.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class FindFlight extends BaseTestClass{
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        baseUrl = "http://newtours.demoaut.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFindFlight() throws Exception {

        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("tutorial");
        driver.findElement(By.name("login")).click();
        // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("New York");
        new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("July");
        new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("11");
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Seattle");
        new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("August");
        new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("20");
        driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
        driver.findElement(By.name("findFlights")).click();
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

