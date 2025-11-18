package NormalBuilderDesign;

public class NormalBuilderMain {
    public static void main(String[] args) {
        // Using Builder Pattern (nested class)
        HttpRequest request = new HttpRequest.HttpRequestBuilder()
                .withUrl("https://api.example2.com")
                .withMethod("POST")
                .withHeader("Content-Type", "application/json")
                .withHeader("Accept", "application/json")
                .withQueryParams("key", "12345")
                .withBody("{\"name\": \"Aditya\"}")
                .withTimeout(60)
                .build(); // But user can call this build method anytime can lead to skip assigning mandatory values. This can be corrected with Step Builder

        request.execute(); // Guaranteed to be in a consistent state
    }
}
