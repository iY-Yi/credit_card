package creditcard;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class FileHandlerJson extends FileAbstract {
    public List<CardInfo> readFile(String fileName) {
        List<CardInfo> records = new ArrayList();
        try {
            String data = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONArray jsonArray = new JSONArray(data);

            for (int i=0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String number = Long.toString(item.getLong("CardNumber"));
                String exp = item.getString("ExpirationDate");
                String name = item.getString("NameOfCardholder");
                CardInfo record = new CardInfo(number, exp, name);
                records.add(record);
            }
        } catch (Exception err) {
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
            JSONArray fileObj = new JSONArray();

            while (it.hasNext()) {
                CreditCard card = it.next();
                JSONObject cardObj = new JSONObject();
                cardObj.put("CardNumber", card.getNumber());
                cardObj.put("CardType", card.getType());
                if (card.getType() == "Invalid") {
                    cardObj.put("Error", "Invalid");
                }
                fileObj.put(cardObj);
            }

            String jsonString = fileObj.toString(2);
            fileWriter.write(jsonString);
            System.out.println("File write is completed.");
            fileWriter.close();
        } catch (IOException err) {
            System.out.println(err);
            System.out.println("File write IO error.");
        } catch (Exception err) {
            System.out.println(err);
            System.out.println("File write error.");
        }
    }
}
