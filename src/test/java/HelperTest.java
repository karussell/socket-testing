import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelperTest {

    @Test
    public void count() {
        Helper objectToTest = new Helper("sss");
        int result = objectToTest.count("s");
        assertEquals(3, result);

        result = objectToTest.count("a");
        assertEquals(0, result);
    }

    @Test
    public void complexCount() {
        Helper objectToTest = new Helper("blaskas");
        int result = objectToTest.count("as");
        assertEquals(2, result);
    }

    @Test
    public void emptyNull() {
        try {
            new Helper(null).count("");
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(ex instanceof IllegalArgumentException, ex.getMessage());
        }
//        assertThrows(IllegalArgumentException.class,
//                () -> new Helper(null).count(""));
//
//        assertThrows(IllegalArgumentException.class,
//                () -> new Helper("").count(null));
    }
}