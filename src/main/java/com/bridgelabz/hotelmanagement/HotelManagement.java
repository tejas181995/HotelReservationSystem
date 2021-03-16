package com.bridgelabz.hotelmanagement;

import java.util.ArrayList;

public class HotelManagement {
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    public ArrayList<Hotel> addHotel(Hotel hotel){
        hotels.add(hotel);
        return hotels;
    }
}
