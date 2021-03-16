package com.bridgelabz.hotelmanagement;

public class Hotel {
    String hotelName;
    int weekDayRate;
    int weekEndRate;
    int ratings;


    public Hotel(String hotelName, int weekDayRate , int weekEndRate, int ratings) {
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return hotelName + " " + weekDayRate;
    }

}
