package base;

import org.testng.annotations.Test;

/**
 * Created by ekuznetsova on 4/13/2017.
 */
public class MarketPlaceShopForUnRegUsers extends BaseTest {

@Test
    public void testMarketPlaceShop() throws Exception {
        appManager.openMainPage();
        appManager.goToMarketPlaceVintageBoutique();
    }

}