package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem9 {

    public static void main(String[] args) {
        BinaryTreeNode sampleBT = InsertInBinaryTreeLevelOrder.getSampleBT();
        LevelOrderTraversalInReverse(sampleBT);
    }

    private static void LevelOrderTraversalInReverse(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        Stack<BinaryTreeNode> stack=new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTreeNode tmp = queue.poll();
            if(tmp.getLeft()!=null){
                queue.offer(tmp.getLeft());
            }
            if(tmp.getRight()!=null){
                queue.offer(tmp.getRight());
            }
            stack.push(tmp);
        }
        while(!stack.isEmpty())
            System.out.println(stack.pop().getData());
    }
}
