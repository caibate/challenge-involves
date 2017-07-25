package br.com.challenge.involves.model;

import br.com.challenge.involves.config.PathDinamic;
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
   /* Estrutura de dados dinamica mesmo acrescentando campos na
    tabela aplicacao nao quebra. Maneira mais eficiente deste tipo
    de busca seria trabalhar com vetores.
    Porém para facilitar a leitura do código o header foi armazenado
    separado, funcionando como um indice para efetuar as pesquisas.*/
    private Object[] headerProperty;
    private List<Object[]> body;
    private static String SEPARATOR = ",";

    //carrega o csv já no construtor.
    public BaseCSV() throws BaseNotFoundException {
        try {
            loadCSV();
        } catch (Exception e) {
            throw new BaseNotFoundException();
        }
    }

    private void loadCSV() throws Exception {
        try {
            body = Files.lines(PathDinamic.loadPath(), StandardCharsets.UTF_8)
                    .map(l -> l.split(SEPARATOR))
                    .collect(Collectors.toList());
            headerProperty = body.remove(0);
        } catch (Exception e) {
            throw new ErrorParseCSVException();
        }
    }

    /**
     * Busca o total de linhas do arquivo.
     *
     * @return total de linhas no arquivo.
     */
    public int countLines() {
        return body.size();
    }

    /**
     * Busca o id da propriedade pelo nome.
     *
     * @param property nome da propriedade.
     * @return id da propriedade (posicao da propriedade no header)
     * @throws PropertyNotFoundException caso a propriedade não exista
     *  no header gera está exception
     */
    public int findIdProperty(String property) throws PropertyNotFoundException {
        for (int i = 0; i < headerProperty.length; i++) {
            if (String.valueOf(headerProperty[i]).equals(property)) {
                return i;
            }
        }
        throw new PropertyNotFoundException();
    }

    /**
     * Agrupa todas as linhas por uma determinada propriedade.
     *
     * @param idProperty id da propriedade (posicao da propriedade no header)
     * @return MAP<KEY, Lista de VALORES>
     * @throws ErrorFoundPropertiesException erro ao buscar dados da propriedade.
     */
    public Map<Object, List<Object[]>> distinctProperty(int idProperty) throws ErrorFoundPropertiesException {
        try {
            Map<Object, List<Object[]>> mapProperties = body.stream().collect(Collectors.groupingBy(p -> p[idProperty]));
            return mapProperties;
        } catch (Exception e) {
            throw new ErrorFoundPropertiesException();
        }
    }

    /**
     * Filtra registros por propriedade e valor.
     *
     * @param idProperties id da propriedade (posicao da propriedade no header).
     * @param value valor a ser filtrado.
     * @return linhas com resultado da consulta.
     * @throws ErrorFoundPropertiesException
     */
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