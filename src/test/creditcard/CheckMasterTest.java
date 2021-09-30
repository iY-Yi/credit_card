package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckMasterTest {

    @Test
    void checkTypeTest1() {
        String number = "5510000000000000";
        assertTrue(CheckMaster.checkType(number));
    }

    @Test
    void checkTypeTest2() {
        String number = "5610000000000000";
        assertFalse(CheckMaster.checkType(number));
    }
    @Test
    void checkTypeTest3() {
        String number = "511000000000000";
        assertFalse(CheckMaster.checkType(number));
    }
}