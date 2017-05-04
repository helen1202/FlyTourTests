package testHelpers;
import org.openqa.selenium.By;

public class MarketPlaceShopHelper extends BaseHelper {

    public MarketPlaceShopHelper(AppManager manager) {
        super(manager);
    }

    public void goToMarketPlaceVintageBoutique() {
        click(By.linkText("Marketplace"));
        click(By.cssSelector("li.boutiques > a.tab > span"));
        click(By.cssSelector("li.boutiques > a.tab > span"));
        click(By.linkText("Vintage Boutiques"));
    }
}
