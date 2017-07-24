package br.com.challenge.involves.model;

import br.com.challenge.involves.exception.ErrorFoundPropertiesException;
import br.com.challenge.involves.exception.PropertyNotFoundException;

import java.util.List;
import java.util.Map;


/**
 * Created by diegon on 23/07/2017.
 */
public abstract class BaseGeneric<T> {
    public abstract int countLines();
    public abstract Map<Object, List<Object[]>> distinctProperty(int id) throws ErrorFoundPropertiesException;
    public abstract List<Object[]> filterProperty(int properties, String value)throws  ErrorFoundPropertiesException;
    public abstract int findIdProperty(String property) throws PropertyNotFoundException;
}
