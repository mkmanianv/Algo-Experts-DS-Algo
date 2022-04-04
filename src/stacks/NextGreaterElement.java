package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] input = new int[]{2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement(input)));
    }

    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * array.length - 1; i >= 0; i--) {

            int cirIdx = i % array.length;

            while (stack.size() > 0) {
                if (stack.peek() <= array[cirIdx]) {
                    stack.pop();
                } else {
                    result[cirIdx] = stack.peek();
                    break;
                }
            }

            stack.push(array[cirIdx]);


        }
        return result;
    }

}
