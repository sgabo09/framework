package hu.selenium.TestUserGenerator.Models;

public class AddressModel {

    private int addressId;
    private String address;
    private String district;
    private String postalCode;
    private String phoneNumber;
    private int cityId;

    public AddressModel(int addressId, String address, String district, String postalCode, String phoneNumber, int cityId) {
        this.addressId = addressId;
        this.address = address;
        this.district = district;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.cityId = cityId;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCityId() {
        return cityId;
    }
}
