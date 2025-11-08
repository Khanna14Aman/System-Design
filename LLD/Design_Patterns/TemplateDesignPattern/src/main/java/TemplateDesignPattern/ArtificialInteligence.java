package TemplateDesignPattern;

public abstract class ArtificialInteligence {
    public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preprocessData();
        trainModel();      // subclass-specific
        evaluateModel();   // subclass-specific
        saveModel();       // subclass-specific or default
    }
    protected void loadData(String dataPath){
        System.out.println("Data gets loaded from "+dataPath);
    }
    protected abstract void preprocessData();
    protected abstract void trainModel();
    protected abstract void evaluateModel();
    protected void saveModel(){
        System.out.println("Saving Model");
    }
}
