package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest {

    @Test
    void createCardTest1() {
        CardInfo info = new CardInfo("5410000000000000", "6/1/2030", "Emily");
        CreditCard card = CardFactory.createCard(info);
        assertEquals(card.getType(), "Master");
    }

    @Test
    void createCardTest2() {
        CardInfo info = new CardInfo("5410000000000", "6/1/2030", "Emily");
        CreditCard card = CardFactory.createCard(info);
        assertEquals(card.getType(), "Invalid");
    }
}