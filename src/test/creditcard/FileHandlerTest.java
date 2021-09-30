package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void createHandlerTest1() {
        String file = "test.xml";
        assertNotNull(FileHandler.createHandler(file));
    }

    @Test
    void createHandlerTest2() {
        String file = "testjson";
        assertNull(FileHandler.createHandler(file));
    }
}