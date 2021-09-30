package creditcard;

import java.io.*;
import java.util.*;

public class FileHandlerCsv extends FileAbstract {
    public List<CardInfo> readFile(String fileName) {
        List<CardInfo> records = new ArrayList();
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            fileReader.nextLine();
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] tokens = line.split(",|\\t");
                String number = tokens[0].replaceAll("\\s", "");
                String exp = tokens[1].replaceAll("\\s", "");
                String name = tokens[2];
                CardInfo record = new CardInfo(number, exp, name);
                records.add(record);
            }
            fileReader.close();
        } catch (FileNotFoundException err) {
            System.out.println(err);
            System.out.println("File read error.");
        }
        return records;
    }

    public void writeFile(List<CreditCard> cards, String fileName) {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(fileName);
            ListIterator<CreditCard> it = cards.listIterator();
            fileWriter.write("CardNumber,CardType,Error");
            while (it.hasNext()) {
                CreditCard card = it.next();
                String error = "";
                if (card.getType() == "Invalid") {
                    error = "Invalid";
                }
                String line = '\n'+card.getNumber()+','+card.getType()+','+ error;
                fileWriter.write(line);
            }
            System.out.println("File write is completed.");
            fileWriter.close();
        } catch (IOException err) {
            System.out.println(err);
            System.out.println("File write IO error.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File write error.");
        }
    }
}
