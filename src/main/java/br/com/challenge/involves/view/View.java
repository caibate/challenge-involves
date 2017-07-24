package br.com.challenge.involves.view;

import br.com.challenge.involves.exception.OptionInvalidException;

import java.util.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by diegon on 23/07/2017.
 */
public class View {


    private static String SPACE ="\n\n\n";

    public View() {
        System.out.println("Escolha um dos comandos [1-4] e tecla ENTER:");
    }

    public static int option() throws OptionInvalidException {
        int cmd;
        System.out.println("\t 1 - Count * (Conta todos os registros)");
        System.out.println("\t 2 - Count distinct [propriedade] (Total de valores distintos da propriedade)");
        System.out.println("\t 3 - Filter [propriedade] [valor] (Filtra linhas)");
        System.out.println("\t 4 - Exit (Sair)");

        try {
           Scanner scanner = new Scanner(System.in);
           cmd = scanner.nextInt();
           validOption(cmd);
        }catch (Exception e){
            throw new OptionInvalidException();
        }
        return  cmd;
    }

    private static void validOption(int cmd) throws OptionInvalidException {
        if (!(cmd == 1 || cmd == 2 || cmd == 3 || cmd == 4)) {
            throw new OptionInvalidException();
        }
    }

    public static String getProperty() throws Exception {
        System.out.println("Digite o nome da propriedade e tecle ENTER:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getValue() throws Exception{
        System.out.println("Digite o valor e tecle ENTER:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void displayCountLines(int countLines) {
        System.out.println(SPACE + "O número total de linhas é: " + countLines + "." + SPACE);
    }

    public static void displayDistinctProperties(Map<Object, List<Object[]>> mapProperties, String property) {
        final int count = mapProperties.keySet().size();
        System.out.println(SPACE + "O número total de linhas distintas da propriedade [" + property + "] é: " + count);

        mapProperties.forEach((key, value) -> {
            System.out.println("Propriedade chave : " + key );
            //value.stream().forEach(p -> System.out.println(Arrays.asList(p)));
        });
        System.out.println(SPACE);
    }

    public static void displayFilter(List<Object[]> listRow, String property, String val) {
        System.out.println("As linhas com a propriedade [" + property + "]  e o valor [" + val + "] são [" + listRow.size() + "]: ");
        listRow.stream().forEach(p -> System.out.println(Arrays.asList(p)));
        System.out.println(SPACE);
    }


    public static void optionInvalid() {
        System.out.println(SPACE + "Opção digita invalida! Tente novamente!" + SPACE);
    }

    public static void baseNotFound() {
        System.out.println(SPACE + "Base não pode ser carregada!" + SPACE);
    }

    public static void propertyNotFound() {
        System.out.println(SPACE + "Propriedade pesquisada não encontrada!" + SPACE);
    }

    public static void errorFoundProperties() {
        System.out.println(SPACE + "Erro ao buscar propriedade!" + SPACE);
    }

    public static void errorGeneric() {
        System.out.println(SPACE + "Erro genérico tente novamente" + SPACE);
    }
}