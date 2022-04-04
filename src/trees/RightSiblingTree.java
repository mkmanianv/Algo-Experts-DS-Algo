package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class RightSiblingTree {
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        mutate(root, null, false);
        return root;
    }

    public static void mutate(BinaryTree node, BinaryTree parent, boolean isLeftChild){
        if(node == null) return;
        var left = node.left;
        var right = node.right;
        mutate(left, node, true);
        if(parent == null){
            node.right = null;
        }else if(isLeftChild){
            node.right = parent.right;
        }else{
            if(parent.right == null){
                node.right = null;
            }else{
                node.right = parent.right.left;
            }
        }
        mutate(right, node, false);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        RightSiblingTree.BinaryTree root = new RightSiblingTree.BinaryTree(1);
        new RightSiblingTree().insert(root, new int[] {2, 3, 4, 5, 6, 7, 8, 9});
        root.left.right.right = new RightSiblingTree.BinaryTree(10);
        root.right.left.left = new RightSiblingTree.BinaryTree(11);
        root.right.right.left = new RightSiblingTree.BinaryTree(12);
        root.right.right.right = new RightSiblingTree.BinaryTree(13);
        root.right.left.left.left = new RightSiblingTree.BinaryTree(14);
        RightSiblingTree.BinaryTree mutatedRoot = RightSiblingTree.rightSiblingTree(root);
    }

    public void insert(RightSiblingTree.BinaryTree root, int[] values) {
        insert(root, values, 0);
    }

    public void insert(RightSiblingTree.BinaryTree root, int[] values, int i) {
        if (i >= values.length) {
            return;
        }
        Deque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
        queue.addLast(root);
        while (queue.size() > 0) {
            RightSiblingTree.BinaryTree current = queue.pollFirst();
            if (current.left == null) {
                current.left = new RightSiblingTree.BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
                current.right = new RightSiblingTree.BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.right);
        }
        insert(root, values, i + 1);
    }
}
