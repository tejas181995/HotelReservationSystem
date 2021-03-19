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
    public static Hotel getCheapHotelByRate(int customerType) throws InvalidDataException {
        if(customerType < 0 || customerType >= 2)
            throw new InvalidDataException();
        return Collections.min(hotels, ((hotel1, hotel2) -> ((Integer) hotel1.weekDayRate[customerType]).compareTo((Integer) hotel2.weekDayRate[customerType])));
    }
    public static long getTotalRates( Hotel hotel, int customerType) throws InvalidDataException {
        if(d1.compareTo(d2) > 0 || customerType < 0 || customerType >= 2)
            throw new InvalidDataException();
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
    public static TreeMap<Long, ArrayList<Hotel>> weekEndWeekDaysRates(int customerType) throws InvalidDataException {
        if(customerType < 0 || customerType >= 2)
            throw new InvalidDataException();
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
    public static void showCheapHotel(int customerType ) throws InvalidDataException {
        if( customerType < 0 || customerType >= 2)
            throw new InvalidDataException();
        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(customerType);
        System.out.print("\ncheapest hotels are " );
        long minRate = hotelRates.keySet().stream().min(Long::compare).get();
        for (Hotel hotel: hotelRates.get(minRate)){
            System.out.print(hotel.hotelName + " ");
        }
        System.out.println("with rate: "+ minRate);
    }
    public static Hotel getCheapestHotelByRating(int customerType) throws InvalidDataException {

        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(customerType);
        long minRate = hotelRates.keySet().stream().min(Long::compare).get();
        return hotelRates.get(minRate).stream().max((h1, h2 ) -> ((Integer)h1.ratings).compareTo(((Integer)h2.ratings))).get();

    }
    public static Hotel getBestRatedHotel(){
        return hotels.stream().max((h1, h2 ) -> ((Integer)h1.ratings).compareTo(((Integer)h2.ratings))).get();
    }
    public static void setDate(String s1, String s2) throws InvalidDataException {
        String dateFormat = "^([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
        if(!s1.matches(dateFormat) || !s2.matches(dateFormat))
            throw new InvalidDataException();
        d1 = LocalDate.parse(s1);
        d2 = LocalDate.parse(s2);
    }


}


