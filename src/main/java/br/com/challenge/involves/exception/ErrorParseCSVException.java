package br.com.challenge.involves.exception;

/**
 * Created by diegon on 23/07/2017.
 *
 * Exceção a ser gerada quando convert CSV para Objeto.
 */
public class ErrorParseCSVException extends Exception {
    public ErrorParseCSVException() {
        super("Error parse CSV");
    }
}
