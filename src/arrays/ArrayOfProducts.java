import java.util.Arrays;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {
        int j = 0;
        int i = 0;
        int arrayLength = array.length;

        int[] result = new int[arrayLength];
        while (j < arrayLength) {
            i = j + 1;
            int prod = 1;
            while (i != j) {
                if (i == arrayLength) {
                    i = 0;
                    continue;
                }
                prod *= array[i];
                i++;
            }
            result[j] = prod;
            j++;
        }

        return result;
    }

    public static int[] arrayOfProducts1(int[] array) {
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length-1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }

    public static void main(String[] args) {

        int[] input = new int[]{5, 1, 4, 2};
        System.out.println(Arrays.toString(arrayOfProducts(input)));
        System.out.println(Arrays.toString(arrayOfProducts1(input)));
    }
}
