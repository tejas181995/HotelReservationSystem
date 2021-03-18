package com.bridgelabz.hotelmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.time.*;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HotelManagement {
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    public static LocalDate d1 = LocalDate.parse("2020-09-11");
    public static LocalDate d2 = LocalDate.parse("2020-09-12");
    public ArrayList<Hotel> addHotel(Hotel hotel){
        hotels.add(hotel);
        return hotels;
    }
    public static Hotel getCheapHotelByRate(int customerType){
        return Collections.min(hotels, ((hotel1, hotel2) -> ((Integer) hotel1.weekDayRate[customerType]).compareTo((Integer) hotel2.weekDayRate[customerType])));
    }
    public static long getTotalRates( Hotel hotel, int customerType){
        long rate = 0;
        LocalDate dx = d2;
        dx = dx.plusDays(1);
        for(LocalDate date = d1; date.isBefore(dx); date = date.plusDays(1)){
            String today = DayOfWeek.from(date).name();
            if(today.equals(DayOfWeek.SATURDAY.toString()) || today.equals(DayOfWeek.SUNDAY.toString()) ) {
                rate += hotel.weekEndRate[customerType];
            }else {
                rate+= hotel.weekDayRate[customerType];
            }
        }
        return rate;
    }
    public static TreeMap<Long, ArrayList<Hotel>> weekEndWeekDaysRates(int customerType){
        TreeMap<Long, ArrayList<Hotel>> hotelRates = new TreeMap<>();
        for (Hotel hotel: hotels){
            long rate = getTotalRates(hotel, customerType);

            ArrayList<Hotel> thisRateHotel = hotelRates.get(rate);
            if(thisRateHotel == null){
                thisRateHotel = new ArrayList<>();
            }
            thisRateHotel.add(hotel);
            hotelRates.put(rate, thisRateHotel);
        }
        return hotelRates;

    }
    public static void showCheapHotel(int customerType ){

        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(customerType);
        System.out.print("\ncheapest hotels are " );
        long minRate = hotelRates.keySet().stream().min(Long::compare).get();
        for (Hotel hotel: hotelRates.get(minRate)){
            System.out.print(hotel.hotelName + " ");
        }
        System.out.println("with rate: "+ minRate);
    }
    public static Hotel getCheapestHotelByRating(int customerType){

        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(customerType);
        long minRate = hotelRates.keySet().stream().min(Long::compare).get();
        return hotelRates.get(minRate).stream().max((h1, h2 ) -> ((Integer)h1.ratings).compareTo(((Integer)h2.ratings))).get();

    }
    public static Hotel getBestRatedHotel(){
        return hotels.stream().max((h1, h2 ) -> ((Integer)h1.ratings).compareTo(((Integer)h2.ratings))).get();
    }


}


