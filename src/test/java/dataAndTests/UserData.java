package dataAndTests;

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

    @Override
    // переобразовует объекты типа юзер дата в строку
    public String toString() {
        return "UserData{" +
                "userAddress1='" + userAddress1 + '\'' +
                '}';
    }
    // метод сравнения объектов логический, не физический при котором сраниваеются адреса объектов в памяти
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (userEmail != null ? !userEmail.equals(userData.userEmail) : userData.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(userData.userPassword) : userData.userPassword != null)
            return false;
        if (userCity != null ? !userCity.equals(userData.userCity) : userData.userCity != null) return false;
        if (userAddress1 != null ? !userAddress1.equals(userData.userAddress1) : userData.userAddress1 != null)
            return false;
        if (userPhoneNumber != null ? !userPhoneNumber.equals(userData.userPhoneNumber) : userData.userPhoneNumber != null)
            return false;
        return userCityZipCode != null ? userCityZipCode.equals(userData.userCityZipCode) : userData.userCityZipCode == null;
    }

    // для оптимизации нужен, т.к. сначала джава сравнивает объекты по хэш коду, если они совпали, то далее  используем equals(Object o)
    @Override
    public int hashCode() {
        int result = userEmail != null ? userEmail.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userCity != null ? userCity.hashCode() : 0);
        result = 31 * result + (userAddress1 != null ? userAddress1.hashCode() : 0);
        result = 31 * result + (userPhoneNumber != null ? userPhoneNumber.hashCode() : 0);
        result = 31 * result + (userCityZipCode != null ? userCityZipCode.hashCode() : 0);
        return result;
    }
}
