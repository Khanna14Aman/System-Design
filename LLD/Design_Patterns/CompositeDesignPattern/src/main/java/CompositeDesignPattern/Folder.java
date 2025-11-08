package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> children;

    public Folder(String n) {
        name = n;
        children = new ArrayList<>();
    }
    public void addFileItem(FileSystemItem item){
        children.add(item);
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }

    public int getSize(){
        int totalSize = 0;
        for(FileSystemItem item: children){
            totalSize += item.getSize();
        }
        return totalSize;
    }
    public void ls(int indent){
        String indentNeeded = " ".repeat(indent);
        for(FileSystemItem item: children){
            if(item.isFolder()){
                System.out.println(indentNeeded+ "+ "+item.getName());
            }else{
                System.out.println(indentNeeded+item.getName());
            }
        }
    }
    public void openAll(int indent){
        String indentNeeded = " ".repeat(indent);
        System.out.println(indentNeeded+"+ "+this.getName());
        for(FileSystemItem item:children){
            item.openAll(indent+4);
        }
    }
    public FileSystemItem cd(String name){
        for(FileSystemItem item: children){
            if(item.isFolder() && item.getName().equalsIgnoreCase(name))return item;
        }
        return null;
    }

}
