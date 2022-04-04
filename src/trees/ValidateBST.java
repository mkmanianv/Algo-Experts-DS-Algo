package trees;

public class ValidateBST {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateBst(BST tree) {
        return validateBST(tree, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean validateBST(BST tree, int minValue, int maxValue){
        if(tree.value < minValue || tree.value >= maxValue){
            return false;
        }
        if(tree.left!=null && !validateBST(tree.left, minValue, tree.value)){
            return false;
        } if(tree.right!=null && !validateBST(tree.right, tree.value, maxValue)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var root = new ValidateBST.BST(10);
        root.left = new ValidateBST.BST(5);
        root.left.left = new ValidateBST.BST(2);
        root.left.left.left = new ValidateBST.BST(1);
        root.left.right = new ValidateBST.BST(5);
        root.right = new ValidateBST.BST(15);
        root.right.left = new ValidateBST.BST(13);
        root.right.left.right = new ValidateBST.BST(14);
        root.right.right = new ValidateBST.BST(22);

        System.out.println(ValidateBST.validateBst(root));

    }
}
