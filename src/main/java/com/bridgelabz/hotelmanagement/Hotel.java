package com.bridgelabz.hotelmanagement;

public class Hotel {
    String hotelName;
    int rate;

    public Hotel(String hotelName, int rate) {
        this.hotelName = hotelName;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return hotelName + " " + rate ;
    }

}
