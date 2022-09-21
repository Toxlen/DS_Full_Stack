package fr.polytech.ds.exception;

public class NoRestaurantFoundException extends RuntimeException{
    
    public NoRestaurantFoundException(String message){
        super(message);
    }
}