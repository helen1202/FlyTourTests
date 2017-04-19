import org.testng.annotations.Test;

/**
 * Created by ekuznetsova on 4/10/2017.
 */
public class UserSignIn extends BaseTestClass {

    @Test
    public void testUserSignIn() throws Exception {
        openMainPage();
        goToLogInForm();
        CredentialsForSignIn creds = new CredentialsForSignIn("helenkuz1202@gmail.com", "ELeNa0912M");
        userSignIn(creds);
        submitLogIn();
    }

}

