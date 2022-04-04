package trees;

public class AllKindsOfNodeDepths {

    public static int allKindsOfNodeDepths(BinaryTree root) {

        return allKindsOfNodeDepthsHelper(root, 0);
    }

    public static int allKindsOfNodeDepthsHelper(BinaryTree node, int depth){
        if(node == null) return 0;
        int depthSum = (depth * (depth + 1)) / 2;
        return depthSum + allKindsOfNodeDepthsHelper(node.left, depth + 1) + allKindsOfNodeDepthsHelper(node.right, depth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        var root = new AllKindsOfNodeDepths.BinaryTree(1);
        root.left = new AllKindsOfNodeDepths.BinaryTree(2);
        root.left.left = new AllKindsOfNodeDepths.BinaryTree(4);
        root.left.left.left = new AllKindsOfNodeDepths.BinaryTree(8);
        root.left.left.right = new AllKindsOfNodeDepths.BinaryTree(9);
        root.left.right = new AllKindsOfNodeDepths.BinaryTree(5);
        root.right = new AllKindsOfNodeDepths.BinaryTree(3);
        root.right.left = new AllKindsOfNodeDepths.BinaryTree(6);
        root.right.right = new AllKindsOfNodeDepths.BinaryTree(7);
        int actual = AllKindsOfNodeDepths.allKindsOfNodeDepths(root);
        System.out.println(actual);
    }
}
