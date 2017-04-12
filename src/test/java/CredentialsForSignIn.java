public class CredentialsForSignIn {
    private  String userEmail;
    private  String userPassword;

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
