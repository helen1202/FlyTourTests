package base;
import application.AppManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    protected AppManager app;

    @BeforeTest
    public void setUp() throws Exception {
        app = new AppManager();
        app.userSignIn();
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }
}
