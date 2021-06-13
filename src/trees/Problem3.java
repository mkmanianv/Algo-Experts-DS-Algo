package Trees;

public class Problem3 {

    public static void main(String[] args) {
        BinaryTreeNode sampleBT = InsertInBinaryTreeLevelOrder.getSampleBT();
        System.out.println(searchInBT(sampleBT, 7));
    }

    private static boolean searchInBT(BinaryTreeNode root, int data) {
        return root != null && (root.data == data || searchInBT(root.left, data) || searchInBT(root.right, data));
    }
}
