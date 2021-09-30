package creditcard;

public class FileHandler {
    public static FileAbstract createHandler(String fileName) {
        if (fileName.endsWith(".csv")) {
            return new FileHandlerCsv();
        } else if (fileName.endsWith(".json")) {
            return new FileHandlerJson();
        } else if (fileName.endsWith(".xml")) {
            return new FileHandlerXml();
        }
        return null;
    }
}
