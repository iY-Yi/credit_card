package creditcard;

public class CheckVisa implements CheckCard{
    public static boolean checkType(String number) {
        if ((number.length()==16 || number.length()==13)  && number.charAt(0)== '4' ) {
            return true;
        }
        return false;
    }
}
