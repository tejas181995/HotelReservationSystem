package com.bridgelabz.hotelmanagement;

public class Hotel {
    String hotelName;
    int weekDayRate;
    int weekEndRate;


    public Hotel(String hotelName, int weekDayRate , int weekEndRate) {
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = this.weekEndRate;
    }

    @Override
    public String toString() {
        return hotelName + " " + weekDayRate;
    }

}
