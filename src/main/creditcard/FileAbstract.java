package creditcard;

import java.util.List;

public abstract class FileAbstract {
    abstract public List<CardInfo> readFile(String fileName);
    abstract public void writeFile(List<CreditCard> cards, String fileName);
}

