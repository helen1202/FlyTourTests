public class CredentialsForRegistration {
    private  String firstName;
    private  String lastName;
    private  String phoneNumber;
    private  String address;
    private  String postalCode;
    private  String contactEmail;
    private  String userEmail;
    private  String userPassword;
    private  String passwordConfirmation;

    public CredentialsForRegistration () {
    }

    public CredentialsForRegistration(String firstName, String lastName, String phoneNumber, String address, String postalCode, String contactEmail, String userEmail, String userPassword, String passwordConfirmation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.contactEmail = contactEmail;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.passwordConfirmation = passwordConfirmation;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
}
