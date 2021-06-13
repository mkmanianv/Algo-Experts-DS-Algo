package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {

    public static void main(String[] args) {
        BinaryTreeNode sampleBT = InsertInBinaryTreeLevelOrder.getSampleBT();
        System.out.println(searchBTWihtoutRec(sampleBT, 3));


    }

    public static boolean searchBTWihtoutRec(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = queue.poll();
            if (tmp.getData() == data) {
                return true;
            }
            if (tmp.getLeft() != null) {
                queue.offer(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.offer(tmp.getRight());
            }
        }
        return false;
    }
}
