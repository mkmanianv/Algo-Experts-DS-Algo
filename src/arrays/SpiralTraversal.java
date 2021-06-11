import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

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
    }
}
