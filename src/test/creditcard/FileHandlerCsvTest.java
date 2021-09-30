package creditcard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerCsvTest {

    @Test
    void readFile() {
        String file = "input.csv";
        FileAbstract handler = new FileHandlerCsv();
        List<CardInfo> data = handler.readFile(file);
        assertEquals(data.get(0).name, "Alice");
    }

    @Test
    void writeFile() {
        String file = "output.csv";
        FileAbstract handler = new FileHandlerCsv();
        List<CreditCard> cards = new ArrayList<>();
        handler.writeFile(cards, file);
        assertNotNull(handler.readFile(file));
    }
}