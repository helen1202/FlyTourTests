package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class AppManager {

    public WebDriver driver;
    public  String baseUrl;
    public  FirefoxProfile profile;
    public NavigationHelper navigationHelper;
    public UserProfileEditHelper userProfileEditHelper;
    public MarketPlaceShopHelper marketPlaceShopHelper;

    public AppManager() {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        baseUrl = "http://us.asos.com";
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(this);
        marketPlaceShopHelper = new MarketPlaceShopHelper(this);
        userProfileEditHelper = new UserProfileEditHelper(this);
    }

    public void stop() {
       driver.close();
    }
}
