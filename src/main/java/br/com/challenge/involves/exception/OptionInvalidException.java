package br.com.challenge.involves.exception;

/**
 * Created by diegon on 23/07/2017.
 *
 * Exceção gerada quando usuário digita uma opção inválida.
 */
public class OptionInvalidException extends Exception {
    public OptionInvalidException() {
       super("Option Invalid");
    }
}
