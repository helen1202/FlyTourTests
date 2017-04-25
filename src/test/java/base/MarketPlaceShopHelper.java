package base;
import org.openqa.selenium.By;

public class MarketPlaceShopHelper extends BaseHelper {

    public MarketPlaceShopHelper(AppManager manager) {
        super(manager);
    }

    public void goToMarketPlaceVintageBoutique() {
        //driver.findElement(By.className("close")).click();
        driver.findElement(By.linkText("Marketplace")).click();
        driver.findElement(By.cssSelector("li.boutiques > a.tab > span")).click();
        driver.findElement(By.cssSelector("li.boutiques > a.tab > span")).click();
        driver.findElement(By.linkText("Vintage Boutiques")).click();

    }
}
