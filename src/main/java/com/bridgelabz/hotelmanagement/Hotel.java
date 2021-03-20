package com.bridgelabz.hotelmanagement;

import java.time.DayOfWeek;
import java.time.LocalDate;

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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Hotel))
            return false;
        return this.hotelName == ((Hotel) obj).hotelName;
    }

    public long getTotalRates(int customerType, LocalDate d1, LocalDate d2) throws InvalidDataException {
        if(d1.compareTo(d2) > 0 || customerType < 0 || customerType >= 2)
            throw new InvalidDataException();
        long rate = 0;
        LocalDate dx = d2;
        dx = dx.plusDays(1);
        for(LocalDate date = d1; date.isBefore(dx); date = date.plusDays(1)){
            String today = DayOfWeek.from(date).name();
            if(today.equals(DayOfWeek.SATURDAY.toString()) || today.equals(DayOfWeek.SUNDAY.toString()) ) {
                rate += this.weekEndRate[customerType];
            }else {
                rate+= this.weekDayRate[customerType];
            }
        }
        return rate;
    }

}