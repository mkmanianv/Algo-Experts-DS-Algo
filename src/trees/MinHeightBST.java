package trees;

import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {
        return minHeightBST(array, null,0, array.size());
    }

    public static BST minHeightBST(List<Integer> array, BST tree,int min, int max) {
        if(max<min)return null;
        int pivot = (max + min) / 2;
        if(tree==null){
         tree = new BST(array.get(pivot));   
        }
        else{
            tree.insert(array.get(pivot));
        }
        minHeightBST(array,tree, min, pivot-1);
        minHeightBST(array,tree, pivot+1, max);
        return tree;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);

        System.out.println(minHeightBst(array));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
