package StepBuilderDesign;

public class StepBuilderMain {
    public static void main(String[] args) {
        HttpRequest stepRequest = HttpRequest.HttpRequestStepBuilder.getBuilder()
                .withUrl("https://api.example.com/products")
                .withMethod("POST")
                .withHeader("Content-Type", "application/json")
                .withBody("{\"product\": \"Laptop\", \"price\": 49999}")
                .withTimeout(45)
                .build(); // Now every method will get called in specified order.

        stepRequest.execute();
    }
}
