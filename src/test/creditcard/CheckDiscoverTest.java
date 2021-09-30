package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckDiscoverTest {

    @Test
    void checkTypeTest1() {
        String number = "6011000000222222";
        assertTrue(CheckDiscover.checkType(number));
    }

    @Test
    void checkTypeTest2() {
        String number = "601100000022222";
        assertFalse(CheckDiscover.checkType(number));
    }

    @Test
    void checkTypeTest3() {
        String number = "6001000000222222";
        assertFalse(CheckDiscover.checkType(number));
    }
}