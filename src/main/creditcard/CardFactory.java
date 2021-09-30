package creditcard;

public class CardFactory {
    public static CreditCard createCard(CardInfo cardInfo) {
        String number = cardInfo.number;
        if (number.length()>19){
            return new InvalidCC(cardInfo, "Invalid");
        }
        else if (CheckVisa.checkType(number)) {
            return new VisaCC(cardInfo, "Visa");
        }
        else if (CheckMaster.checkType(number)) {
            return new MasterCC(cardInfo,"Master");
        }
        else if (CheckAmEx.checkType(number)) {
            return new AmExCC(cardInfo,"American Express");
        }
        else if (CheckDiscover.checkType(number)) {
            return new DiscoverCC(cardInfo,"Discover");
        }
        return new InvalidCC(cardInfo, "Invalid");
    }
}
