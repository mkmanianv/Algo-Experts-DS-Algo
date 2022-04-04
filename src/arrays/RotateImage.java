package arrays;

public class RotateImage {

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }

        }
    }

    private void reverseRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = matrix.length - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }


    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
