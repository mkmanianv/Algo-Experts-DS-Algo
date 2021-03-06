package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BSTConstruction {

    public static void main(String[] args) {
        var root = new BSTConstruction.BST(10);
        root.left = new BSTConstruction.BST(5);
        root.left.left = new BSTConstruction.BST(2);
        root.left.left.left = new BSTConstruction.BST(1);
        root.left.right = new BSTConstruction.BST(5);
        root.right = new BSTConstruction.BST(15);
        root.right.left = new BSTConstruction.BST(13);
        root.right.left.right = new BSTConstruction.BST(14);
        root.right.right = new BSTConstruction.BST(22);

        root.insert(12);
        System.out.println((root.right.left.left.value == 12));
        System.out.println(root.contains(12));

        root.remove(10);
        System.out.println(root.contains(10) == false);
        System.out.println (root.value == 12);

        System.out.println (root.contains(15));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (value < this.value) {
                if (left == null) {
                    BST newBst = new BST(value);
                    left = newBst;
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    BST newBst = new BST(value);
                    right = newBst;
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }

            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }

            } else {
                return true;
            }
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {

                    }

                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }

        }

        private int getMinValue() {

            if (left == null) {
                return this.value;
            } else {
                return left.getMinValue();
            }
        }


    }
}
