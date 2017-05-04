package testHelpers;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper (AppManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl);
    }

    public void gotoAddEditAddressForm() {
        driver.get("https://my.asos.com/address/add?checkout=false");
    }

    public void goToAccLink() {
        click(By.linkText("My Account"));
    }

    public void goToLogInForm() {
        click(By.partialLinkText("Sign In"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void userLogOut() {
        click(By.linkText("sign out"));
    }
}
