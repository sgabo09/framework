package hu.selenium.TestUserGenerator;

public class TestUser {

    public String firstName, lastName;
    public boolean gender;
    public String email;
    public String country, city, address, district;

    public TestUser(String firstName, String lastName, boolean gender, String email,
                    String country, String city, String address, String district)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.country = country;
        this.city = city;
        this.address = address;
        this.district = district;
    }
}