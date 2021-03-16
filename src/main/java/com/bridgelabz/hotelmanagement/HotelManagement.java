package com.bridgelabz.hotelmanagement;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.time.*;

public class HotelManagement {
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    public ArrayList<Hotel> addHotel(Hotel hotel){
        hotels.add(hotel);
        return hotels;
    }
    public long getCheapHotel(LocalDate d1, LocalDate d2){
        long cheaprate;
        long noOfDaysBetween = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(noOfDaysBetween + 1);
        Hotel cheapest = Collections.min(hotels, ((hotel1, hotel2) -> ((Integer) hotel1.weekDayRate).compareTo((Integer) hotel2.weekDayRate)));
        System.out.println(cheapest.weekDayRate);
        cheaprate = cheapest.weekDayRate * (noOfDaysBetween+1);
        System.out.println("cheapest rate for" + " " + (noOfDaysBetween+1) + " days in hotel " + cheapest.hotelName + " " + cheaprate);
        return cheaprate;
    }


}
