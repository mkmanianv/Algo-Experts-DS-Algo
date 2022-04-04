package trees;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if(tree == null){
            return array;
        }
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if(tree == null){
            return array;
        }
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if(tree == null){
            return array;
        }
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var root = new BSTTraversal.BST(10);
        root.left = new BSTTraversal.BST(5);
        root.left.left = new BSTTraversal.BST(2);
        root.left.left.left = new BSTTraversal.BST(1);
        root.left.right = new BSTTraversal.BST(5);
        root.right = new BSTTraversal.BST(15);
        root.right.right = new BSTTraversal.BST(22);

        BSTTraversal.inOrderTraverse(root, new ArrayList<Integer>());
        BSTTraversal.preOrderTraverse(root, new ArrayList<Integer>());
        BSTTraversal.postOrderTraverse(root, new ArrayList<Integer>());
    }
}
