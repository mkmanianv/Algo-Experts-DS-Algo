package trees;

import java.util.ArrayList;

public class ReconstructBST {

    public static void main(String[] args) {

    }

    class TreeInfo{
        int index;
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        
        return reconstructBst(preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE, new TreeInfo());
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues, int minRange, int maxRange, TreeInfo treeInfo) {
        if(treeInfo.index==preOrderTraversalValues.size()){
            return null;

        }
        int currentNode=preOrderTraversalValues.get(treeInfo.index);
        if(currentNode<minRange || currentNode >= maxRange){
            return null;
        }
        treeInfo.index++;
        BST leftSubTree=reconstructBst(preOrderTraversalValues, minRange, currentNode, treeInfo);
        BST rightSubTree=reconstructBst(preOrderTraversalValues, currentNode, maxRange, treeInfo);
        BST bst=new BST(currentNode);
        bst.left=leftSubTree;
        bst.right=rightSubTree;
        return bst;
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
