package TemplateDesignPattern;

public class NeuralNetwork extends ArtificialInteligence{
    @Override
    protected void evaluateModel() {
        System.out.println("Evaluating Model for NeuralNetwork");
    }

    @Override
    protected void preprocessData() {
        System.out.println("Preprocessing Data for Neural Network");
    }

    @Override
    protected void trainModel() {
        System.out.println("Training Model for Neural Network");
    }
}
