package hu.selenium.TestUserGenerator;

import hu.selenium.TestUserGenerator.Models.AddressModel;
import hu.selenium.TestUserGenerator.Models.CityModel;
import hu.selenium.TestUserGenerator.Models.CountryModel;
import hu.selenium.TestUserGenerator.Models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestUserRepository {

    public Statement getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testuserdb?serverTimezone=GMT", "root", "gabo96");
        Statement statement = con.createStatement();
        return statement;
    }

    public List<UserModel> getUsers() throws SQLException {
        Statement statement = getConnection();
        ResultSet rs = statement.executeQuery("SELECT * FROM user");
        List<UserModel> testUsers = new ArrayList<UserModel>();
        while (rs.next()) {
            int userId = rs.getInt("user_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            int addressId = rs.getInt("address_id");
            boolean gender = rs.getBoolean("gender");
            testUsers.add(new UserModel(userId, firstName, lastName, gender, email, addressId));
        }
        rs.close();

        return testUsers;
    }

    public List<AddressModel> getAddresses() throws SQLException {
        Statement statement = getConnection();
        ResultSet rs = statement.executeQuery("SELECT * FROM address");
        List<AddressModel> addresses = new ArrayList<AddressModel>();
        while (rs.next()) {
            int addressId = rs.getInt("address_id");
            String address = rs.getString("address");
            String district = rs.getString("district");
            String postalCode = rs.getString("postal_code");
            String phoneNumber = rs.getString("phone");
            int cityId = rs.getInt("city_id");
            addresses.add(new AddressModel(addressId, address, district, postalCode, phoneNumber, cityId));
        }
        rs.close();

        return addresses;
    }

    public List<CityModel> getCities() throws SQLException {
        Statement statement = getConnection();
        ResultSet rs = statement.executeQuery("SELECT * FROM city");
        List<CityModel> cities = new ArrayList<CityModel>();
        while (rs.next()) {
            int cityId = rs.getInt("city_id");
            String city = rs.getString("city");
            int countryId = rs.getInt("country_id");
            cities.add(new CityModel(cityId, city, countryId));
        }
        rs.close();

        return cities;
    }

    public List<CountryModel> getCountries() throws SQLException {
        Statement statement = getConnection();
        ResultSet rs = statement.executeQuery("SELECT * FROM country");
        List<CountryModel> countries = new ArrayList<CountryModel>();
        while (rs.next()) {
            int countryId = rs.getInt("country_id");
            String country = rs.getString("country");
            countries.add(new CountryModel(countryId, country));
        }
        rs.close();

        return countries;
    }
}
