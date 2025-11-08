package CompositeDesignPattern;

public class CompositePattern {
    public static void main(String[] args) {
        // Build file system
        Folder root = new Folder("root");
        root.addFileItem(new File("file1.txt", 1));
        root.addFileItem(new File("file2.txt", 1));

        Folder docs = new Folder("docs");
        docs.addFileItem(new File("resume.pdf", 1));
        docs.addFileItem(new File("notes.txt", 1));
        root.addFileItem(docs);

        Folder images = new Folder("images");
        images.addFileItem(new File("photo.jpg", 1));
        root.addFileItem(images);

        root.ls(0);

        docs.ls(0);

        root.openAll(0);

        FileSystemItem cwd = root.cd("docs");
        if (cwd != null) {
            cwd.ls(0);
        } else {
            System.out.println("\nCould not cd into docs\n");
        }

        System.out.println(root.getSize());
    }
}
