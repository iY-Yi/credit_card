package creditcard;

public class CheckAmEx implements CheckCard{
    static public boolean checkType(String number) {
        if (number.length()==15 && number.charAt(0)== '3' && (number.charAt(1)== '4' || number.charAt(1)== '7')) {
            return true;
        }
        return false;
    }
}
