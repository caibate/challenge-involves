package br.com.challenge.involves.config;

import br.com.challenge.involves.exception.BaseNotFoundException;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Created by diegon on 23/07/2017.
 */
public class PropertiesConfig {
    private Path path;
    public PropertiesConfig() throws BaseNotFoundException {
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);

            Optional<String> dirOptinal = Optional.of(properties.getProperty("load.dir.csv"));
            dirOptinal.filter((d) -> !d.isEmpty()).orElseThrow(BaseNotFoundException::new);

            path = Paths.get(dirOptinal.get());
        }catch (Exception e){
            throw new BaseNotFoundException();
         }
    }

    public Path getPath(){
        return path;
    }
}
