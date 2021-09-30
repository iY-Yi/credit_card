package creditcard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerJsonTest {

    @Test
    void readFile() {
        String file = "input.json";
        FileAbstract handler = new FileHandlerJson();
        List<CardInfo> data = handler.readFile(file);
        assertEquals(data.get(0).name, "Alice");
    }

    @Test
    void writeFile() {
        String file = "output.json";
        FileAbstract handler = new FileHandlerCsv();
        List<CreditCard> cards = new ArrayList<>();
        handler.writeFile(cards, file);
        assertNotNull(handler.readFile(file));
    }
}