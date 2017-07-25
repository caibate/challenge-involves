import br.com.challenge.involves.exception.BaseNotFoundException;
import br.com.challenge.involves.exception.ErrorFoundPropertiesException;
import br.com.challenge.involves.exception.PropertyNotFoundException;
import br.com.challenge.involves.model.BaseCSV;
import br.com.challenge.involves.model.BaseGeneric;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by diegon on 24/07/2017.
 */
@RunWith(JUnit4.class)
public class BaseCSVTest {
    private static BaseGeneric base;
    @BeforeClass
    public static void loadBaseCSV() throws BaseNotFoundException{
        base = new BaseCSV();
    }
    @Test
    public void countLinesBaseCSV() {
        assertEquals(5565, base.countLines());
    }

    @Test
    public  void findIdPropertyBaseCSV() throws PropertyNotFoundException{
        assertEquals(0,base.findIdProperty("ibge_id"));
        assertEquals(1,base.findIdProperty("uf"));
        assertEquals(2,base.findIdProperty("name"));
        assertEquals(3,base.findIdProperty("capital"));
        assertEquals(4,base.findIdProperty("lon"));
        assertEquals(5,base.findIdProperty("lat"));
        assertEquals(6,base.findIdProperty("no_accents"));
        assertEquals(7,base.findIdProperty("alternative_names"));
        assertEquals(8,base.findIdProperty("microregion"));
        assertEquals(9,base.findIdProperty("mesoregion"));
    }

    @Test(expected = PropertyNotFoundException.class)
    public void findIdPropertyBaseCSVException() throws PropertyNotFoundException{
        assertEquals(0,base.findIdProperty("xpto"));
    }

    @Test(expected = ErrorFoundPropertiesException.class)
    public void distinctPropertyBaseCSVException()  throws ErrorFoundPropertiesException{
        base.distinctProperty(101);
    }

    @Test(expected = ErrorFoundPropertiesException.class)
    public void filterPropertyBaseCSVException()  throws ErrorFoundPropertiesException{
            base.filterProperty(101,"xpt");
    }
}
