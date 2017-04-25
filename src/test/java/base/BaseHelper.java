package base;

import org.openqa.selenium.*;

//нельзя создать экземплярабстрактногокласса
public abstract class BaseHelper {

    protected WebDriver driver;
    protected AppManager manager;
    protected  boolean acceptNextAlert = true;

    public BaseHelper  (AppManager manager) {
        this.manager = manager;
        this.driver = manager.driver;
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
}
