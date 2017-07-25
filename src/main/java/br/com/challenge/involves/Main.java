package br.com.challenge.involves;

import br.com.challenge.involves.controller.Controller;

/**
 * Created by diegon on 23/07/2017.
 *
 * Classe usada somente para iniciar a aplicação.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.displayMenu();
    }
}
