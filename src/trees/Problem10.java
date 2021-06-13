package Trees;

public class Problem10 {

    public static void main(String[] args) {
        BinaryTreeNode sampleBT = InsertInBinaryTreeLevelOrder.getSampleBT();
        System.out.println(maxDepthRecursive(sampleBT));
    }

    private static int maxDepthRecursive(BinaryTreeNode root) {
        if(root==null)
            return 0;
        int maxLeft=maxDepthRecursive(root.left);
        int maxRight=maxDepthRecursive(root.right);

        return (maxLeft>maxRight)?maxLeft+1:maxRight+1;
    }
}
