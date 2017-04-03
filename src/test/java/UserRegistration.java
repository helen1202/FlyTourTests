/**
 * Created by Helen on 03.04.2017.
 */

import  org.testng.annotations.Test;

public class UserRegistration extends BaseTestClass{

    @Test
    public void testUserRegistrationNotEmpty() throws Exception {
        openMainPage();
        goToRegistrationForm();
        CredentialsForRegistration credentials =  new CredentialsForRegistration("Helen", "Kuz", "0967840099", "London", "223344", "test@mail.com", "tutorial", "tutorial", "tutorial");
        fillRegistrationForm(credentials);
        submitRegistration();
    }

    @Test
    public void testUserRegistrationIsEmpty() throws Exception {
        openMainPage();
        goToRegistrationForm();
        fillRegistrationForm(new CredentialsForRegistration("", "", "", "", "", "", "", "", ""));
        submitRegistration();
    }


}
