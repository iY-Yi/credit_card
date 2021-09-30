package creditcard;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Incorrect input argument. java -jar creditcard.jar inputFile outputFile");
            return;
        }
        String input = args[0];
        String output = args[1];

        FileAbstract file = FileHandler.createHandler(input);
        List<CardInfo> records = file.readFile(input);
        ListIterator<CardInfo> it = records.listIterator();
        List<CreditCard> cards = new ArrayList<>();
        while(it.hasNext()) {
            cards.add(CardFactory.createCard(it.next()));
        }
        file.writeFile(cards, output);
    }
}
