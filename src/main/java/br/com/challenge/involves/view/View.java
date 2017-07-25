package br.com.challenge.involves.view;

import br.com.challenge.involves.exception.OptionInvalidException;

import java.util.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by diegon on 23/07/2017.
 */
public class View {
    //Padrão de espacamento.
    private static String SPACE ="\n\n\n";

    /**
     *  Mensagem inicial
     */
    public View() {
        System.out.println("Escolha um dos comandos [1-4] e tecla ENTER:");
    }

    /**
     * Opções do menu.
     *
     * @return opcao selecionada pelo usuario
     * @throws OptionInvalidException excecao se o usuario digitar uma
     * opcao invalida.
     */
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

    /**
     *
     * @param cmd comando
     * @throws OptionInvalidException  excecao se o usuario digitar uma
     * opcao invalida.
     */
    private static void validOption(int cmd) throws OptionInvalidException {
        if (!(cmd == 1 || cmd == 2 || cmd == 3 || cmd == 4)) {
            throw new OptionInvalidException();
        }
    }

    /**
     * Captura a propridade.
     *
     * @return
     * @throws Exception
     */
    public static String getProperty() throws Exception {
        System.out.println("Digite o nome da propriedade e tecle ENTER:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Captura o valor.
     *
     * @return
     * @throws Exception
     */
    public static String getValue() throws Exception{
        System.out.println("Digite o valor e tecle ENTER:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Exibe o total de linhas.
     *
     * @param countLines numero de linhas.
     */
    public static void displayCountLines(int countLines) {
        System.out.println(SPACE + "O número total de linhas é: " + countLines + "." + SPACE);
    }

    /**
     * Exibe total de linhas distintas.
     *
     * @param mapProperties <KEY, LISTA DE VALORES>
     * @param property propriedade.
     */
    public static void displayDistinctProperties(Map<Object, List<Object[]>> mapProperties, String property) {
        final int count = mapProperties.keySet().size();
        System.out.println(SPACE + "O número total de linhas distintas da propriedade [" + property + "] é: " + count);

        mapProperties.forEach((key, value) -> {
            System.out.println("Propriedade chave : " + key );
            //value.stream().forEach(p -> System.out.println(Arrays.asList(p)));
        });
        System.out.println(SPACE);
    }

    /**
     *  Exibe as linhas filtradas.
     *
     * @param listRow linhas filtradas.
     * @param property propriedade.
     * @param val valor.
     */
    public static void displayFilter(List<Object[]> listRow, String property, String val) {
        System.out.println("As linhas com a propriedade [" + property + "]  e o valor [" + val + "] são [" + listRow.size() + "]: ");
        listRow.stream().forEach(p -> System.out.println(Arrays.asList(p)));
        System.out.println(SPACE);
    }

    /**
     * Exibe que a msg dizendo que a opcao foi invalida.
     */
    public static void optionInvalid() {
        System.out.println(SPACE + "Opção digita invalida! Tente novamente!" + SPACE);
    }

    /**
     *  Exibe msg que a base nao foi encontrada.
     */
    public static void baseNotFound() {
        System.out.println(SPACE + "Base não pode ser carregada!" + SPACE);
    }

    /**
     * Exibe msg que a propriedade nao encontrada.
     */
    public static void propertyNotFound() {
        System.out.println(SPACE + "Propriedade pesquisada não encontrada!" + SPACE);
    }

    /**
     * Exibe msg que erro ao buscar propriedade.
     */
    public static void errorFoundProperties() {
        System.out.println(SPACE + "Erro ao buscar propriedade!" + SPACE);
    }

    /**
     * Exibe msg que houve um erro generico.
     */
    public static void errorGeneric() {
        System.out.println(SPACE + "Erro genérico tente novamente." + SPACE);
    }
}