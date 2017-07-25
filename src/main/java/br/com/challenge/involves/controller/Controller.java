package br.com.challenge.involves.controller;

import br.com.challenge.involves.exception.BaseNotFoundException;
import br.com.challenge.involves.exception.ErrorFoundPropertiesException;
import br.com.challenge.involves.exception.OptionInvalidException;
import br.com.challenge.involves.exception.PropertyNotFoundException;
import br.com.challenge.involves.model.BaseGeneric;
import br.com.challenge.involves.model.BaseCSV;
import br.com.challenge.involves.view.View;

import java.util.List;
import java.util.Map;

/**
 * Created by diegon on 23/07/2017.
 *
 * Classe controller
 */
public class Controller {

    private boolean exit = false;
    private BaseGeneric baseGeneric;

    /**
     * Exibe as opções do menu e
     * e trata as possiveis exceções.
     */
    public void displayMenu() {
        do {
            try {
               choice();
            }
            catch (OptionInvalidException e){
                View.optionInvalid();
            }
            catch (BaseNotFoundException e){
                View.baseNotFound();
                exit=true;
            }
            catch (PropertyNotFoundException e){
                View.propertyNotFound();
            }
            catch (ErrorFoundPropertiesException e){
                View.errorFoundProperties();
            }
            catch (Exception e){
                View.errorGeneric();
            }

        }while (!exit);
    }

    /**
     * Exibe as opções do sub menu
     *
     * @throws Exception
     */
    private void choice() throws Exception {
        baseGeneric = new BaseCSV();
        switch (View.option()){
            case 1:
                countLines();
                break;
            case 2:
                displayDistinctProperties();
                break;
            case 3:
                filterProperty();
                break;
            default:
               exit = true;
        }
    }

    /**
     * Filtra por propriedade e valor.
     *
     * Busca propriedade pega id.
     * Filtra por id propriedade e valor.
     //Retorna todos os registro.
     *
     * @throws Exception
     */
    private void filterProperty() throws Exception {

        String property = View.getProperty();
        int idProperty = baseGeneric.findIdProperty(property);
        //Busca value.
        String value = View.getValue();
        List<Object[]> listRow= baseGeneric.filterProperty(idProperty, value);
        View.displayFilter(listRow, property, value);
    }

    /**
     * Busca o id da propriedade pesquisando por nome.
     * Exibe o total de registro com propriedade pesquisada distinta.
     *
     * @throws Exception
     */
    private void displayDistinctProperties() throws Exception {
        String property = View.getProperty();
        int idProperty = baseGeneric.findIdProperty(property);
        Map<Object, List<Object[]>> mapProperties = baseGeneric.distinctProperty(idProperty);
        View.displayDistinctProperties(mapProperties, property);
    }

    /**
     * Conta o número de linhas e apresenta na tela.
     *
     * @throws Exception
     */
    private void countLines() throws Exception{
        int countLines = baseGeneric.countLines();
        View.displayCountLines(countLines);
    }
}