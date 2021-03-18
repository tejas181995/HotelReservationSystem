package com.bridgelabz.hotelmanagement;

public class InvalidDataException extends Exception{
    public InvalidDataException() {
        super("Invalid Data Provided");
    }
}
