package trees;

public class HeightBalancedBinaryTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.

        return getTreeInfo(tree).isBalanced;
    }

    public TreeInfo getTreeInfo(BinaryTree tree){
        if(tree==null){
            return new TreeInfo(-1,true);
        }

        TreeInfo leftTreeInfo=getTreeInfo(tree.left);
        TreeInfo rightTreeInfo=getTreeInfo(tree.right);

        boolean isBalanced=leftTreeInfo.isBalanced && rightTreeInfo.isBalanced &&
                Math.abs(leftTreeInfo.height-rightTreeInfo.height)<=1;

        int height=Math.max(leftTreeInfo.height,rightTreeInfo.height)+1;

        return new TreeInfo(height,isBalanced);

    }
    class TreeInfo{
        public int height;
        public boolean isBalanced;

        TreeInfo(int height,boolean isBalanced){
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }

    public static void main(String[] args) {
        HeightBalancedBinaryTree.BinaryTree root = new HeightBalancedBinaryTree.BinaryTree(1);
        root = new HeightBalancedBinaryTree.BinaryTree(1);
        root.left = new HeightBalancedBinaryTree.BinaryTree(2);
        root.right = new HeightBalancedBinaryTree.BinaryTree(3);
        root.left.left = new HeightBalancedBinaryTree.BinaryTree(4);
        root.left.right = new HeightBalancedBinaryTree.BinaryTree(5);
        root.right.right = new HeightBalancedBinaryTree.BinaryTree(6);
        root.left.right.left = new HeightBalancedBinaryTree.BinaryTree(7);
        root.left.right.right = new HeightBalancedBinaryTree.BinaryTree(8);
        boolean expected = true;
        var actual = new HeightBalancedBinaryTree().heightBalancedBinaryTree(root);
        System.out.println(actual);
    }


}
