package com.bridgelabz.hotelmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.time.*;
import java.util.TreeMap;

public class HotelManagement {
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    public ArrayList<Hotel> addHotel(Hotel hotel){
        hotels.add(hotel);
        return hotels;
    }
    public static Hotel getCheapHotel(){
        return Collections.min(hotels, ((hotel1, hotel2) -> ((Integer) hotel1.weekDayRate).compareTo((Integer) hotel2.weekDayRate)));
    }
    public static TreeMap<Long, ArrayList<Hotel>> weekEndWeekDaysRates(LocalDate d1, LocalDate d2 ){
        TreeMap<Long, ArrayList<Hotel>> hotelRates = new TreeMap<>();
        d2 = d2.plusDays(1);
        for (Hotel hotel: hotels){
            long rate = 0;
            for(LocalDate date = d1; date.isBefore(d2); date = date.plusDays(1)){
                String today = DayOfWeek.from(date).name();
                if(today.equals(DayOfWeek.SATURDAY.toString()) || today.equals(DayOfWeek.SUNDAY.toString()) ) {
                    rate += hotel.weekEndRate;
                }else {
                    rate+= hotel.weekDayRate;
                }
            }
            ArrayList<Hotel> thisRateHotel = hotelRates.get(rate);
            if(thisRateHotel == null){
                thisRateHotel = new ArrayList<>();
            }
            thisRateHotel.add(hotel);
            hotelRates.put(rate, thisRateHotel);
        }
        return hotelRates;

    }
    public static void showCheapHotel(){
        LocalDate d1 = LocalDate.parse("2020-09-11");
        LocalDate d2 = LocalDate.parse("2020-09-12");
        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(d1, d2);
        System.out.print("\ncheapest hotels are " );
        long minRate = hotelRates.keySet().stream().min(Long::compare).get();
        for (Hotel hotel: hotelRates.get(minRate)){
            System.out.print(hotel.hotelName + " ");
        }
        System.out.println("with rate: "+ minRate);
    }
}



