package base;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper (AppManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl);
    }

    public void gotoAddAddressForm() {
        driver.get("https://my.asos.com/address/add?checkout=false");
    }

    public void goToAccLink() {
        driver.findElement(By.linkText("My Account")).click();
    }

    public void goToLogInForm() {
        driver.findElement(By.partialLinkText("Sign In")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void userLogOut() {
        driver.findElement(By.linkText("sign out")).click();
    }
}
