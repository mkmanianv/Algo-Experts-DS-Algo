package Trees;

public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);
    }

    public static int nodeDepths(BinaryTree root, int layer){
        if(root==null){
            return 0;
        }
        return layer+nodeDepths(root.left,layer+1)+nodeDepths(root.right,layer+1);
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
        var root = new NodeDepths.BinaryTree(1);
        root.left = new NodeDepths.BinaryTree(2);
        root.left.left = new NodeDepths.BinaryTree(4);
        root.left.left.left = new NodeDepths.BinaryTree(8);
        root.left.left.right = new NodeDepths.BinaryTree(9);
        root.left.right = new NodeDepths.BinaryTree(5);
        root.right = new NodeDepths.BinaryTree(3);
        root.right.left = new NodeDepths.BinaryTree(6);
        root.right.right = new NodeDepths.BinaryTree(7);
        System.out.println(NodeDepths.nodeDepths(root));
    }
}
