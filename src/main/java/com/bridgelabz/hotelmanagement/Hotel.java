package com.bridgelabz.hotelmanagement;

public class Hotel {
    public String hotelName;
    public int ratings;

    public static final int REGULAR_CUSTOMER = 0;
    public static final int LOYAL_CUSTOMER = 1;

    public int weekDayRate[] = new int[2];
    public int weekEndRate[] = new int[2];

    public Hotel(String hotelName, int rweekDayRate , int rweekEndRate, int lweekDayRate , int lweekEndRate, int ratings) {
        this.hotelName = hotelName;
        weekDayRate[REGULAR_CUSTOMER] = rweekDayRate;
        weekEndRate[REGULAR_CUSTOMER] = rweekEndRate;
        weekDayRate[LOYAL_CUSTOMER] = lweekDayRate;
        weekEndRate[LOYAL_CUSTOMER] = lweekEndRate;

        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return (hotelName + " " + ratings);
    }

}