package base;
import application.AppManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    protected AppManager appManager;

    @BeforeTest
    public void setUp() throws Exception {
        appManager = new AppManager();
    }

    @AfterTest
    public void tearDown() throws Exception {
        appManager.stop();
    }
}
