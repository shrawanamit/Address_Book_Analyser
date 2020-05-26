package com.addressbook;

public class PersonDetails {
    public String FirstName;
    private String LastName;
    private String Address;
    private String City;
    private String State;
    public String Zip;
    private String PhoneNumber ;
    public String fullName;

    public String getZip() {
        return Zip;
    }

    public String getState() {
        return State;
    }

    public String getCity() {
        return City;
    }

    public String getAddress() {
        return Address;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return  FirstName;
    }

    public PersonDetails(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber) {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        City = city;
        State = state;
        Zip = zip;
        PhoneNumber = phoneNumber;
        fullName=FirstName+" "+LastName;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Zip='" + Zip + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
    public void AssignFirstName(String firstName) {
        FirstName = firstName;
    }

    public void AssignLastName(String lastName) {
        LastName = lastName;
    }

    public void AssignAddress(String address) {
        Address = address;
    }

    public void AssignCity(String city) {
        City = city;
    }

    public void AssignState(String state) {
        State = state;
    }

    public void AssignZip(String zip) {
        Zip = zip;
    }

    public void AssignPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}
