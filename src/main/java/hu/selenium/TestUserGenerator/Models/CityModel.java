package hu.selenium.TestUserGenerator.Models;

public class CityModel {

    private int cityId;
    private String city;
    private int countryId;

    public CityModel(int cityId, String city, int countryId) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    public int getCountryId() {
        return countryId;
    }
}
