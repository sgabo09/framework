package hu.selenium.TestUserGenerator.Models;

public class UserModel {

    private int userId;
    private String firstName, lastName;
    private boolean gender;
    private String email;
    private int addressId;

    public UserModel(int id, String firstName, String lastName, boolean gender, String email, int addressId) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getAddressId() {
        return addressId;
    }
}
