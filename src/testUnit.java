import org.junit.Test;
import static org.junit.Assert.*;

public class testUnit {

//  Test cases for checkDatatypes
    @Test
    public void testDatatype(){
//        checkDatatype myTest = new checkDatatype();
        assertFalse("Test failed for 10.10.10", checkDatatype.isNumeric("10.10.10"));
        assertTrue("Test failed for 10.10", checkDatatype.isNumeric("10.10"));
        assertFalse("Test failed for name", checkDatatype.isNumeric("name"));
        assertFalse("Test failed for $#$@$#", checkDatatype.isNumeric("$#$@$#"));
        assertTrue("Test failed for 10.321432423432421", checkDatatype.isNumeric("10.321432423432421"));
    }


}

