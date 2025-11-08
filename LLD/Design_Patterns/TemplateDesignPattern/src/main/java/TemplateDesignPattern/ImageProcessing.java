package TemplateDesignPattern;

public class ImageProcessing extends ArtificialInteligence{
    protected void preprocessData(){
        System.out.println("Preporcessing Data for Image Processing");
    }

    @Override
    protected void trainModel() {
        System.out.println("Training Model for Image Processing");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("Evaluating Model for Image Processing");
    }

    protected void saveModel(){
        System.out.println("Saving Image model in local Desktop");
    }
}
