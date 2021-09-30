package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckVisaTest {

    @Test
    void checkTypeTest1() {
        String number = "441000000000000";
        assertFalse(CheckVisa.checkType(number));
    }

    @Test
    void checkTypeTest2() {
        String number = "4410000000000000";
        assertTrue(CheckVisa.checkType(number));
    }
}