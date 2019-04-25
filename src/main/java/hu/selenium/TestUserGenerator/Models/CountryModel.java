package hu.selenium.TestUserGenerator.Models;

public class CountryModel {
    private int countryId;
    private String country;

    public CountryModel(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountry() {
        return country;
    }
}
