package hu.selenium.TestUserGenerator;

import hu.selenium.TestUserGenerator.Models.AddressModel;
import hu.selenium.TestUserGenerator.Models.CityModel;
import hu.selenium.TestUserGenerator.Models.CountryModel;
import hu.selenium.TestUserGenerator.Models.UserModel;

import java.sql.SQLException;
import java.util.*;

public class TestUserGenerator {

    private TestUserRepository userRepo;

    public TestUserGenerator(TestUserRepository userRepo){
        this.userRepo = userRepo;
    }

    private <T> T randomListItem(List<T> list){
        Random rand = new Random();
        T randomElement = list.get(rand.nextInt(list.size()));
        return randomElement;
    }

    public TestUser generateTestUser() throws SQLException {
        List<UserModel> users = userRepo.getUsers();
        List<AddressModel> addresses = userRepo.getAddresses();
        List<CityModel> cities = userRepo.getCities();
        List<CountryModel> countries = userRepo.getCountries();

        String firstName = randomListItem(users).getFirstName();
        String lastName = randomListItem(users).getLastName();
        boolean gender = randomListItem(users).getGender();
        String email = randomListItem(users).getEmail();
        String country = randomListItem(countries).getCountry();
        String city = randomListItem(cities).getCity();
        String address = randomListItem(addresses).getAddress();
        String district = randomListItem(addresses).getDistrict();

        return new TestUser(firstName, lastName, gender, email, country, city, address, district);
    }

    public TestUser generateTestUserWithValidAddress() throws SQLException {
        List<UserModel> users = userRepo.getUsers();
        List<AddressModel> addresses = userRepo.getAddresses();
        List<CityModel> cities = userRepo.getCities();
        List<CountryModel> countries = userRepo.getCountries();

        Map<AddressModel, CityModel> addressToCity = new HashMap<AddressModel, CityModel>();
        Map<CityModel, CountryModel> cityToCountry = new HashMap<CityModel, CountryModel>();

        for (AddressModel address : addresses){
            for(CityModel city : cities){
                if(address.getCityId() == city.getCityId()){
                    addressToCity.put(address, city);
                }
            }
        }

        for (CityModel city : cities){
            for(CountryModel country : countries){
                if(city.getCountryId() == country.getCountryId()){
                    cityToCountry.put(city, country);
                }
            }
        }

        AddressModel addressModel = randomListItem(addresses);
        CityModel cityModel = addressToCity.get(addressModel);

        String firstName = randomListItem(users).getFirstName();
        String lastName = randomListItem(users).getLastName();
        boolean gender = randomListItem(users).getGender();
        String email = randomListItem(users).getEmail();
        String address = addressModel.getAddress();
        String city = cityModel.getCity();
        String country = cityToCountry.get(cityModel).getCountry();
        String district = addressModel.getDistrict();

        return new TestUser(firstName, lastName, gender, email, country, city, address, district);
    }
}
