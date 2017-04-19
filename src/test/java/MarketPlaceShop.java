import org.testng.annotations.Test;

/**
 * Created by ekuznetsova on 4/13/2017.
 */
public class MarketPlaceShop extends BaseTestClass{

    @Test
    public void testMarketPlaceShop() throws Exception {
        openMainPage();
        goToMarketPlace ();
        goToShopWomenDresses ();
    }
}
