package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm:
 * Create and initialize variables k – starting row index, m – ending row index, l – starting column index, n – ending column index
 * Run a loop until all the squares of loops are printed.
 * In each outer loop traversal print the elements of a square in a clockwise manner.
 * Print the top row, i.e. Print the elements of the kth row from column index l to n, and increase the count of k.
 * Print the right column, i.e. Print the last column or n-1th column from row index k to m and decrease the count of n.
 * Print the bottom row, i.e. if k < m, then print the elements of m-1th row from column n-1 to l and decrease the count of m
 * Print the left column, i.e. if l < n, then print the elements of lth column from m-1th row to k and increase the count of l.
 */


public class SpiralTraversal {


    static void spiralPrint(int re, int ce, int a[][])
    {
        int i, rs = 0, cs = 0;

        /*  rs - starting row index
        re - ending row index
        cs - starting column index
        ce - ending column index
        i - iterator
        */

        while (rs < re && cs < ce) {
            // Print the first row from the remaining rows -- left --> right
            for (i = cs; i < ce; ++i) {
                System.out.print(a[rs][i] + " ");
            }
            rs++;

            // Print the last column from the remaining -- right top to right bottom
            // columns
            for (i = rs; i < re; ++i) {
                System.out.print(a[i][ce - 1] + " ");
            }
            ce--;

            // Print the last row from the remaining rows  --
            if (rs < re) { // at the end we have only values in vertical line
                for (i = ce - 1; i >= cs; --i) {
                    System.out.print(a[re - 1][i] + " ");
                }
                re--;
            }

            // Print the first column from the remaining
            // columns */
            if (cs < ce) { // at the end we have only values in horizontal line
                for (i = re - 1; i >= rs; --i) {
                    System.out.print(a[i][cs] + " ");
                }
                cs++;
            }
        }
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int startColumn = 0;
        int endRow = array.length - 1;
        int endColumn = array[0].length - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            for (int i = startColumn; i <= endColumn; i++) {
                result.add(array[startRow][i]);
            }
            for (int j = startRow + 1; j <= endRow; j++) {
                result.add(array[j][endColumn]);
            }
            for (int i = endColumn - 1; i >= startColumn; i--) {
                if(startRow==endRow) break;
                result.add(array[endRow][i]);
            }

            for (int j = endRow - 1; j > startRow; j--) {
                if(startColumn==endColumn) break;
                result.add(array[j][startColumn]);
            }
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input =
                new int[][]{
                        {1, 2, 3, 4},
                        {10, 11, 12, 5},
                        {9, 8, 7, 6}
                };
        System.out.println(spiralTraverse(input));

        int R = 3;
        int C = 6;
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };

        // Function Call
        spiralPrint(R, C, a);
    }
}
