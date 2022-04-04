package arrays;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int size = matrix.length;
        int low = matrix[0][0];
        int high = matrix[size - 1][size -1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            // scan from top right (take the benefit of row and col sorted matrix)
            for (int i = 0; i < matrix.length; i++) {
                while (j>=0 && matrix[i][j] > mid) {
                    j-=1;
                }
                count += (j + 1);
            }
            // scan end

            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        new KthSmallest().kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8 );
    }
}

