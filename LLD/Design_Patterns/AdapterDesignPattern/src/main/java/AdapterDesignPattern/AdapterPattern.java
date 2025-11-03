package AdapterDesignPattern;

public class AdapterPattern {
    public static void main(String[] args) {
        XmlDataProvider xmlProv = new XmlDataProvider();

        IReports adapter = new XmlDataProviderAdapter(xmlProv);

        String rawData = "Alice:42";

        Client client = new Client();

        client.getReport(adapter, rawData);
    }
}
