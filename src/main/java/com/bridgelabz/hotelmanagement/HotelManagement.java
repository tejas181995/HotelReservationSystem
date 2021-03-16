package com.bridgelabz.hotelmanagement;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
        Hotel cheapest = Collections.min(hotels, ((hotel1, hotel2) -> ((Integer) hotel1.rate).compareTo((Integer) hotel2.rate)));
        System.out.println(cheapest.rate);
        cheaprate = cheapest.rate * (noOfDaysBetween+1);
        System.out.println("cheapest rate for" + " " + (noOfDaysBetween+1) + " days in hotel " + cheapest.hotelName + " " + cheaprate);
        return cheaprate;
    }


}
