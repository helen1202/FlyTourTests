package application;

public class UserData {
    private  String userEmail;
    private  String userPassword;
    private String userCity;
    private String userAddress1;
    private String userPhoneNumber;
    private String userCityZipCode;

    public UserData(){
    }

    public UserData(String userCity, String userAddress1, String userPhoneNumber, String userCityZipCode) {
      this.userCity = userCity;
      this.userAddress1 = userAddress1;
      this.userPhoneNumber = userPhoneNumber;
      this.userCityZipCode = userCityZipCode;
    }

    public UserData(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword () {
        return userPassword;
    }

    public String getUserCity() {return userCity;}

    public String getUserAddress1() {return userAddress1;}

    public String getUserPhoneNumber() {return userPhoneNumber;}

    public String getUserCityZipCode() {return userCityZipCode;}
}
