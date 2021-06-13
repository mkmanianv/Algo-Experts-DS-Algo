package Trees;

public class Problem1 {

    public static void main(String[] args) {

        BinaryTreeNode sampleBT = InsertInBinaryTreeLevelOrder.getSampleBT();
        System.out.println(maxInBinaryTree(sampleBT));

    }

    private static int maxInBinaryTree(BinaryTreeNode root){
        int maxValue=Integer.MIN_VALUE;
        if(root!=null){
            int leftMax=maxInBinaryTree(root.left);
            int rightMax=maxInBinaryTree(root.right);
            if(leftMax>rightMax){
                maxValue=leftMax;
            }else {
                maxValue=rightMax;
            }
            if(root.data>maxValue){
                maxValue=root.data;
            }
        }
        return maxValue;
    }
}
