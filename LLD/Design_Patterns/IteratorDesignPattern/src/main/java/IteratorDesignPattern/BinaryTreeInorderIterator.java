package IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderIterator implements Iterator<Integer>{
    private List<BinaryTree> listTree = new ArrayList<>();

    private void pushLefts(BinaryTree node) {
        if(node==null)return;
        pushLefts(node.left);
        listTree.add(node);
        pushLefts(node.right);
    }

    public BinaryTreeInorderIterator(BinaryTree root) {
        pushLefts(root);
    }

    public boolean hasNext() {
        return listTree.size()>1;
    }

    public Integer current(){
        return listTree.getFirst().data;
    }

    public void next() {
        listTree.removeFirst();
    }
}
