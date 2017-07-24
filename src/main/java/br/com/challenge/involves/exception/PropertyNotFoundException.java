package br.com.challenge.involves.exception;

/**
 * Created by diegon on 23/07/2017.
 */
public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException() {
       super("Property not found");
    }
}
