package be.vdab.util;

public class RijksregisternummerNietGeldigException extends RuntimeException{
    public RijksregisternummerNietGeldigException() {
    }

    public RijksregisternummerNietGeldigException(String message) {
        super(message);
    }
}
