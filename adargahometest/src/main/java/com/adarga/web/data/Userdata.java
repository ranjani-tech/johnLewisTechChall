package com.adarga.web.data;

import java.util.Objects;

public class Userdata {
    private String title;
    private String firstname;
    private String lastname;
    private String addresse;
    private String phonenumber;
    private String shortaddress;
    private String email;
    private String addressline1;
    private String addressline2;
    private String city;
    private String postcode;



    //Default constructor
//Overriding constructor
    public Userdata(String title,String firstname,String lastname,String phonenumber,String shortaddress, String email) throws Throwable{
        this.title=title;
        this.firstname=firstname;
        this.lastname=lastname;
        this.phonenumber=phonenumber;
        this.shortaddress=shortaddress;
        this.email=email;
        this.addresse = title+ " " + " " + firstname + " " + lastname;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getShortaddress() {
        return shortaddress;
    }

    public void setShortaddress(String shortaddress) {
        this.shortaddress = shortaddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Userdata{" +
                "title='" + title + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", addresse='" + addresse + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", shortaddress='" + shortaddress + '\'' +
                ", email='" + email + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    public Userdata() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userdata userdata = (Userdata) o;
        return Objects.equals(getTitle(), userdata.getTitle()) && Objects.equals(getFirstname(), userdata.getFirstname()) && Objects.equals(getLastname(), userdata.getLastname()) && Objects.equals(getAddresse(), userdata.getAddresse()) && Objects.equals(getPhonenumber(), userdata.getPhonenumber()) && Objects.equals(getShortaddress(), userdata.getShortaddress()) && Objects.equals(getEmail(), userdata.getEmail()) && Objects.equals(getAddressline1(), userdata.getAddressline1()) && Objects.equals(getAddressline2(), userdata.getAddressline2()) && Objects.equals(getCity(), userdata.getCity()) && Objects.equals(getPostcode(), userdata.getPostcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getFirstname(), getLastname(), getAddresse(), getPhonenumber(), getShortaddress(), getEmail(), getAddressline1(), getAddressline2(), getCity(), getPostcode());
    }
}
