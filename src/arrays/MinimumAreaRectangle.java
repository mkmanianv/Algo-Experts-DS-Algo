package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

    public int minimumAreaRectangle1(int[][] points) {
        if (points.length < 4) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        // If x point is same then sort based on y or else sort on x.
        Arrays.sort(points, (a,b) -> (a[0] == b[0]) ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int area = Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1]));
                if (area >= min || area == 0) {
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) { // find other two points
                    min = area;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minimumAreaRectangle(int[][] points) {
        HashMap<Integer, int[]> columns = intializeColumns(points);
        int minAreaFound = Integer.MAX_VALUE;
        HashMap<String, Integer> edgesParallelToYAxis = new HashMap<String, Integer>();

        ArrayList<Integer> sortedColumns = new ArrayList<Integer>(columns.keySet());
        Collections.sort(sortedColumns);

        for(Integer x : sortedColumns){
            int[] yVluesInCurrentColumn = columns.get(x);
            Arrays.sort(yVluesInCurrentColumn);

            for(int currentIdx = 0; currentIdx < yVluesInCurrentColumn.length; currentIdx++){
                int y2 = yVluesInCurrentColumn[currentIdx];
                for(int previousIdx = 0 ; previousIdx < currentIdx; previousIdx++){
                    int y1 = yVluesInCurrentColumn[previousIdx];
                    String pointString = String.valueOf(y1)+":"+String.valueOf(y2);

                    if(edgesParallelToYAxis.containsKey(pointString)){
                        int currentArea = (x - edgesParallelToYAxis.get(pointString)) * (y2 - y1);
                        minAreaFound = Math.min(minAreaFound, currentArea);
                    }

                    edgesParallelToYAxis.put(pointString, x);
                }
            }
        }
        // Write your code here.
        return (minAreaFound != Integer.MAX_VALUE)? minAreaFound : 0;
    }

    public HashMap<Integer, int[]> intializeColumns(int[][] points){
        HashMap<Integer, int[]> columns = new HashMap<>();

        for(int[] point:points){
            int x = point[0];
            int y = point[1];

            if(!columns.containsKey(x)){
                columns.put(x, new int[]{});
            }

            int[] column = columns.get(x);
            int[] newColumn = new int[column.length + 1];
            for(int i=0; i <column.length; i++){
                newColumn[i] = column[i];
            }

            newColumn[column.length] = y;
            columns.put(x, newColumn);
        }
        return columns;
    }

    public static void main(String[] args) {
        int[][] input =
                new int[][] {
                        {1, 5},
                        {5, 1},
                        {4, 2},
                        {2, 4},
                        {2, 2},
                        {1, 2},
                        {4, 5},
                        {2, 5},
                        {-1, -2}
                };
        System.out.println(new MinimumAreaRectangle().minimumAreaRectangle1(input));
    }
}
