package dataAndTests;
import org.testng.annotations.Test;

public class MarketPlaceShop extends BaseTest {

@Test
    public void testMarketPlaceShop() throws Exception {
        app.getMarketPlaceShopHelper().goToMarketPlaceVintageBoutique();
    }

}
