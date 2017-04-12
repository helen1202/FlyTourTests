public class CredentialsForSignIn {
    private static String userEmail;
    private static String userPassword;

    public CredentialsForSignIn() {
    }

    public CredentialsForSignIn(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword () {
        return userPassword;
    }

}
