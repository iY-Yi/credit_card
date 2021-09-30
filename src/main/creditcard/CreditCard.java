package creditcard;

public class CreditCard {
    private String number;
    private String expiration;
    private String name;
    private String type;

    public CreditCard(CardInfo cardInfo, String cardType) {
        number = cardInfo.number;
        expiration = cardInfo.expiration;
        name = cardInfo.name;
        type = cardType;
    }
    public void printCard() {
        System.out.println(type);
    }
    public String getType() {
        return type;
    }
    public String getNumber() {
        return number;
    }
}
