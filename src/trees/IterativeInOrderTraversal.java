package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IterativeInOrderTraversal {

    public List<Integer> testArray = new ArrayList<Integer>();

    public void testCase(){
        var root = new IterativeInOrderTraversal.BinaryTree(1);
        root.left = new IterativeInOrderTraversal.BinaryTree(2, root);
        root.left.left = new IterativeInOrderTraversal.BinaryTree(4, root.left);
        root.left.left.right = new IterativeInOrderTraversal.BinaryTree(9, root.left.left);
        root.right = new IterativeInOrderTraversal.BinaryTree(3, root);
        root.right.left = new IterativeInOrderTraversal.BinaryTree(6, root.right);
        root.right.right = new IterativeInOrderTraversal.BinaryTree(7, root.right);
        IterativeInOrderTraversal.iterativeInOrderTraversal(root, this::testCallback);
    }

    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree prevNode = null;
        BinaryTree currentNode = tree;

        while (currentNode != null) {
            BinaryTree nextNode;
            if (prevNode == null || prevNode == currentNode.parent) {
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if (prevNode == currentNode.left) {
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }
            prevNode = currentNode;
            currentNode = nextNode;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }
    public Void testCallback(IterativeInOrderTraversal.BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        testArray.add(tree.value);
        return null;
    }

    public static void main(String[] args) {

        new IterativeInOrderTraversal().testCase();
    }
}
