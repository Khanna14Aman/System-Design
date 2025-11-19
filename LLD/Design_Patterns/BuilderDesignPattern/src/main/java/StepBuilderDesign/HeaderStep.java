package StepBuilderDesign;

interface HeaderStep {
    OptionalStep withHeader(String key, String value);
}