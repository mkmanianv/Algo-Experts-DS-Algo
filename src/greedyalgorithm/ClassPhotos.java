package greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {
    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        boolean expected = true;
        boolean actual = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(expected);
        System.out.println(actual);
    }

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        String colorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE";
        for (int i = 0, redShirtHeightsSize = redShirtHeights.size(); i < redShirtHeightsSize; i++) {
            Integer redShirtHeight = redShirtHeights.get(i);
            Integer blueShirtHeight = blueShirtHeights.get(i);
            if (colorInFirstRow.equals("RED")) {
                if (blueShirtHeight <= redShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }

        }
        return true;
    }
}
