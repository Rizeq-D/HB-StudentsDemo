package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "city")
    private String City;
    @Column(name = "street")
    private String Street;
    @Column(name = "zipcode")
    private String Zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        City = city;
        Street = street;
        Zipcode = zipcode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }
}
