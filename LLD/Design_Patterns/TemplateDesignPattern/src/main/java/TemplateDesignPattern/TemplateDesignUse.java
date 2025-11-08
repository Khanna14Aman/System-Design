package TemplateDesignPattern;

public class TemplateDesignUse {
    public static void main(String [] args){
        ArtificialInteligence imageProcessing = new ImageProcessing();
        ArtificialInteligence neuralNetwork = new NeuralNetwork();
        imageProcessing.trainPipeline("Google Cloud");
        neuralNetwork.trainPipeline("Google Cloud");
    }
}
