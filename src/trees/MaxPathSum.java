package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSum {
    public static int maxPathSum(BinaryTree tree) {
        Result result=new Result();
        result.val= Integer.MIN_VALUE;
        findMaxPath(tree, result);
        return result.val;
    }

    public static int findMaxPath(BinaryTree tree, Result result){
        if(tree == null){
            return 0;
        }
        int left=findMaxPath(tree.left, result);
        int right=findMaxPath(tree.right, result);
        //Max path through Left Child + Node
        //Max path through Right Child + Node
        int maxSingle=Math.max(Math.max(left, right)+ tree.value, tree.value);

        // Max path through Left Child + Node + Max path through Right Child
        int maxTop= Math.max(maxSingle, left + right + tree.value);

        result.val=Math.max(maxTop, result.val);
        return maxSingle;
    }

    static class Result {
        public int val;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MaxPathSum.TestBinaryTree tree = new MaxPathSum.TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7));
        System.out.println(MaxPathSum.maxPathSum(tree));
    }

    public static class TestBinaryTree extends MaxPathSum.BinaryTree {
        TestBinaryTree(int value) {
            super(value);
        }

        MaxPathSum.TestBinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }

        MaxPathSum.TestBinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<MaxPathSum.TestBinaryTree> queue = new ArrayList<MaxPathSum.TestBinaryTree>();
            queue.add(this);
            while (queue.size() > 0) {
                MaxPathSum.TestBinaryTree current = queue.get(0);
                queue.remove(0);
                if (current.left == null) {
                    current.left = new MaxPathSum.TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((MaxPathSum.TestBinaryTree) current.left);
                if (current.right == null) {
                    current.right = new MaxPathSum.TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((MaxPathSum.TestBinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }
}
