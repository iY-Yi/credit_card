package creditcard;

public class CheckMaster implements CheckCard{
    static public boolean checkType(String number) {
        if (number.length()==16 && number.charAt(0)== '5') {
            int digit = Character.getNumericValue(number.charAt(1));
            if (digit >= 1 && digit <= 5 ) {
                return true;
            }
        }
        return false;
    }
}
