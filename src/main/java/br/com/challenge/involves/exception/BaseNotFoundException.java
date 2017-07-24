package br.com.challenge.involves.exception;

/**
 * Created by diegon on 23/07/2017.
 */
public class BaseNotFoundException extends Exception {
    public BaseNotFoundException() {
       super("Base not found");
    }
}
