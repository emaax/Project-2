package com.example.emiliaaxen.stockholmguide1.model;

/**
 * Created by emiliaaxen on 16-03-18.
 */
public class Restaurant {

    String name;
    String address;
    String location;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String [] restaurantsName = new String[]{
            "Saturnus",
            "Bla Porten",
            "Snickarbacken",
            "Flippin Burgers",
            "The Voltaire sisters",
            "Urban Deli",
            "Riche",
            "Sturhof"
    };



}
