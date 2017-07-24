package br.com.challenge.involves.model;

import br.com.challenge.involves.config.PropertiesConfig;
import br.com.challenge.involves.exception.BaseNotFoundException;
import br.com.challenge.involves.exception.ErrorFoundPropertiesException;
import br.com.challenge.involves.exception.ErrorParseCSVException;
import br.com.challenge.involves.exception.PropertyNotFoundException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by diegon on 23/07/2017.
 */
public class BaseCSV extends BaseGeneric {
    private Object[] headerProperty;
    private List<Object[]> body;
    private static String SEPARATOR = ",";
    PropertiesConfig propertiesConfig = new PropertiesConfig();

    public BaseCSV() throws BaseNotFoundException {
        try {
            loadCSV();
        } catch (Exception e) {
            throw new BaseNotFoundException();
        }
    }

    private void loadCSV() throws Exception {
        try {
            body = Files.lines(propertiesConfig.getPath(), StandardCharsets.UTF_8)
                    .map(l -> l.split(SEPARATOR))
                    .collect(Collectors.toList());
            headerProperty = body.remove(0);
        } catch (Exception e) {
            throw new ErrorParseCSVException();
        }
    }

    public int countLines() {
        return body.size();
    }

    public int findIdProperty(String property) throws PropertyNotFoundException {
        for (int i = 0; i < headerProperty.length; i++) {
            if (String.valueOf(headerProperty[i]).equals(property)) {
                return i;
            }
        }
        throw new PropertyNotFoundException();
    }

    public Map<Object, List<Object[]>> distinctProperty(int idProperty) throws ErrorFoundPropertiesException {
        try {
            Map<Object, List<Object[]>> mapProperties = body.stream().collect(Collectors.groupingBy(p -> p[idProperty]));
            return mapProperties;
        } catch (Exception e) {
            throw new ErrorFoundPropertiesException();
        }
    }

    @Override
    public List<Object[]> filterProperty(int idProperties, String value) throws ErrorFoundPropertiesException{
        try {
            List<Object[]> listRow =
                    body.stream().filter(p -> p[idProperties].equals(value) ).collect(Collectors.toList());
            return listRow;
        } catch (Exception e) {
            throw new ErrorFoundPropertiesException();
        }
     }
}