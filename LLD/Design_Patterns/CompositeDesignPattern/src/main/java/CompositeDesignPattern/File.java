package CompositeDesignPattern;

public class File implements FileSystemItem{
    private String name;
    private int size;

    public File(String n, int s) {
        name = n;
        size = s;
    }
    public String getName(){
        return name;
    }
    public int getSize(){
        return size;
    }
    public void ls(int indent){
        String indentNeeded = " ".repeat(indent);
        System.out.println(indentNeeded + this.getName());
    }
    public void openAll(int indent){
        String indentNeeded = " ".repeat(indent);
        System.out.println(indentNeeded + this.getName());
    }
    public boolean isFolder(){
        return false;
    }
    public FileSystemItem cd(String name){
        return null;
    }
}
