package testHelpers;
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
    private NavigationHelper navigationHelper;
    private UserProfileEditHelper userProfileEditHelper;
    private MarketPlaceShopHelper marketPlaceShopHelper;

    public AppManager() {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        baseUrl = "http://us.asos.com";
        //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void stop() {
       driver.quit();
    }

    public MarketPlaceShopHelper getMarketPlaceShopHelper (){
        if ( marketPlaceShopHelper == null) {
            marketPlaceShopHelper = new MarketPlaceShopHelper(this);
        }
        return marketPlaceShopHelper;
    }

    public NavigationHelper getNavigationHelper (){
        if ( navigationHelper == null) {
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }

    public UserProfileEditHelper getUserProfileEditHelper (){
        if ( userProfileEditHelper == null) {
            userProfileEditHelper = new UserProfileEditHelper(this);
        }
        return userProfileEditHelper;
    }
}


