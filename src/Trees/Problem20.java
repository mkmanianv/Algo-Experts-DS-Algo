package Trees;

public class Problem20 {

    public static void main(String[] args) {
        BinaryTreeNode sampleBT = InsertInBinaryTreeLevelOrder.getSampleBT();
        System.out.println( diameterOfTree(sampleBT));
    }

    private static int diameterOfTree(BinaryTreeNode root) {
        int left,right,diameter=0;
        if(root==null){
            return 0;
        }

        left=diameterOfTree(root.getLeft());
        right=diameterOfTree(root.getRight());
        if(left+right>diameter){
            diameter=left+right;
        }
        return Math.max(left,right)+1;
    }
}
