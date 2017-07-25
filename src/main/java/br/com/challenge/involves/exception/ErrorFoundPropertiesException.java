package br.com.challenge.involves.exception;

/**
 * Created by diegon on 23/07/2017.
 *
 * Exceção gerada quando acontece um erro ao buscar a propriedade
 */
public class ErrorFoundPropertiesException extends Exception {
    public ErrorFoundPropertiesException() {
       super("Error found properties");
    }
}
