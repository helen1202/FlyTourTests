package application;

import base.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AppManager {

    private WebDriver driver;

    public AppManager(WebDriver driver) {
        this.driver = driver;
    }

    public void fillSignInForm(UserData credsForSignIn) {
        driver.findElement(By.id("EmailAddress")).isEnabled();
        driver.findElement(By.id("EmailAddress")).sendKeys(credsForSignIn.getUserEmail());
        driver.findElement(By.id("Password")).isEnabled();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(credsForSignIn.getUserPassword());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
