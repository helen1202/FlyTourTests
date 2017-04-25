package application;
import org.testng.annotations.Test;

public class MarketPlaceShop extends BaseTest {

@Test
    public void testMarketPlaceShop() throws Exception {
        app.marketPlaceShopHelper.goToMarketPlaceVintageBoutique();
    }

}
