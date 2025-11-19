package StepBuilderDesign;

interface OptionalStep {
    OptionalStep withBody(String body);
    OptionalStep withTimeout(int timeout);
    HttpRequest build();
}