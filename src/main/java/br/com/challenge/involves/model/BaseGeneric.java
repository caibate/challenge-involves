package br.com.challenge.involves.model;

import br.com.challenge.involves.exception.ErrorFoundPropertiesException;
import br.com.challenge.involves.exception.PropertyNotFoundException;

import java.util.List;
import java.util.Map;


/**
 * Created by diegon on 23/07/2017.
 *
 * Interface genérica com ela podemos abstrair de qual fonte de dados
 * os dados seram extraidos. Caso exista outra fonte podemos
 * extender está classe e implementar o comportamento.
 * Ex: WS SOAP, WS REST, arquivo de texto e Banco dados.
 *
 */
public abstract class BaseGeneric<T> {
    public abstract int countLines();
    public abstract Map<Object, List<Object[]>> distinctProperty(int id) throws ErrorFoundPropertiesException;
    public abstract List<Object[]> filterProperty(int properties, String value)throws  ErrorFoundPropertiesException;
    public abstract int findIdProperty(String property) throws PropertyNotFoundException;
}
