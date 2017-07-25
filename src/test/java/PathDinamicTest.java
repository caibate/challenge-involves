import br.com.challenge.involves.config.PathDinamic;
import br.com.challenge.involves.exception.BaseNotFoundException;
import org.junit.Test;

import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by diegon on 24/07/2017.
 */

public class PathDinamicTest {
    @Test
    public void loadPath() throws BaseNotFoundException{
        Path path = PathDinamic.loadPath();
        assertEquals("src\\main\\resources\\cidades.csv", path.toString());
    }
}