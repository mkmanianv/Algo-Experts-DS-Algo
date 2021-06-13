package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> sums = new ArrayList<>();
        branchSums(root, sums,0);
        return sums;
    }

    public static void branchSums(BinaryTree root,List<Integer> result, int sum) {
        sum+=root.value;
        if(root.left==null && root.right==null){
            result.add(sum);
        }
        if(root.left!=null){
            branchSums(root.left, result, sum);
        }
        if(root.right!=null){
            branchSums(root.right, result, sum);
        }
    }

    public static class TestBinaryTree extends BranchSums.BinaryTree {
        TestBinaryTree(int value) {
            super(value);
        }

        TestBinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }

        TestBinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
            queue.add(this);
            while (queue.size() > 0) {
                TestBinaryTree current = queue.get(0);
                queue.remove(0);
                if (current.left == null) {
                    current.left = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.left);
                if (current.right == null) {
                    current.right = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }

    public static void main(String[] args) {

        TestBinaryTree tree = new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
        List<Integer> integers = BranchSums.branchSums(tree);
        System.out.println(integers);
    }
}
