package creditcard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerXmlTest {

    @Test
    void readFile() {
        String file = "input.xml";
        FileAbstract handler = new FileHandlerXml();
        List<CardInfo> data = handler.readFile(file);
        assertEquals(data.get(0).name, "Alice");
    }

    @Test
    void writeFile() {
        String file = "output.xml";
        FileAbstract handler = new FileHandlerXml();
        List<CreditCard> cards = new ArrayList<>();
        handler.writeFile(cards, file);
        assertNotNull(handler.readFile(file));
    }
}