package IteratorDesignPattern;

public class IteratorDesignPatternMain {
    public static void main(String [] args){
        LinkedList head = null;
        LinkedList tail = null;
        for(int i=1;i<=5;i++){
            if(tail == null) {
                head = new LinkedList(i);
                tail = head;
            }else{
                tail.next = new LinkedList(i);
                tail = tail.next;
            }
        }
        try{
            Iterator<Integer> linkedListIterator = head.getIterator();
            while(linkedListIterator.hasNext()){
                System.out.println(linkedListIterator.current());
                linkedListIterator.next();
            }
            System.out.println(linkedListIterator.current());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        BinaryTree root = new BinaryTree(2);
        root.left = new BinaryTree(1);
        root.right = new BinaryTree(3);
        try{
            Iterator<Integer> binaryTreeIterator = root.getIterator();
            while(binaryTreeIterator.hasNext()){
                System.out.println(binaryTreeIterator.current());
                binaryTreeIterator.next();
            }
            System.out.println(binaryTreeIterator.current());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

        PlayList playList = new PlayList();
        playList.addSong(new Song("Admirin You", "Karan Aujla"));
        playList.addSong(new Song("Husn", "Anuv Jain"));
        try {
            Iterator<Song> playListIterator = playList.getIterator();
            System.out.println("Playlist songs:");
            while (playListIterator.hasNext()) {
                System.out.println(playListIterator.current().getTitle() + " BY " + playListIterator.current().getArtist());
                playListIterator.next();
            }
            System.out.println(playListIterator.current().getTitle() + " BY " + playListIterator.current().getArtist());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
}
