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
 */
public class Controller {

    private boolean exit = false;
    private BaseGeneric baseGeneric;
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

    private void filterProperty() throws Exception {
        //Busca propriedade pega id.
        //Retorna total de registro com propriedade distinta.
        String property = View.getProperty();
        int idProperty = baseGeneric.findIdProperty(property);
        //Busca value.
        String value = View.getValue();
        List<Object[]> listRow= baseGeneric.filterProperty(idProperty, value);
        View.displayFilter(listRow, property, value);
    }

    private void displayDistinctProperties() throws Exception {
        //Busca a propriedade pega id.
        //Retorna total de registro com propriedade distinta.
        String property = View.getProperty();
        int idProperty = baseGeneric.findIdProperty(property);
        Map<Object, List<Object[]>> mapProperties = baseGeneric.distinctProperty(idProperty);
        View.displayDistinctProperties(mapProperties, property);
    }

    private void countLines() throws Exception{
        //Calcula numero de linhas da base.
        //Exibe total de linhas.
        int countLines = baseGeneric.countLines();
        View.displayCountLines(countLines);
    }
}