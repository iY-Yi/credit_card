package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckAmExTest {

    @Test
    void checkTypeTest1() {
        String number = "371000000009999";
        assertTrue(CheckAmEx.checkType(number));
    }

    @Test
    void checkTypeTest2() {
        String number = "301000000000000";
        assertFalse(CheckAmEx.checkType(number));
    }

    @Test
    void checkTypeTest3() {
        String number = "34100000000000";
        assertFalse(CheckAmEx.checkType(number));
    }
}