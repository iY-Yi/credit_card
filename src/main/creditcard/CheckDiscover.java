package creditcard;

public class CheckDiscover implements CheckCard{
    static public boolean checkType(String number) {
        if (number.length()==16 && number.substring(0,4).equals("6011")) {
            return true;
        }
        return false;
    }
}
