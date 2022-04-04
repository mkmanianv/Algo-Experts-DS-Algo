package stacks;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> buildingWithSunsetViews = new ArrayList<Integer>();
        int startIdx= buildings.length-1;
        int step=-1;

        if(direction.equals("WEST")){
            startIdx=0;
            step=1;
        }
        int idx=startIdx;
        int runningMaxHeight=0;

        while(idx>=0 && idx < buildings.length){
            int buildingHeight = buildings[idx];

            if(buildingHeight > runningMaxHeight){
                buildingWithSunsetViews.add(idx);
            }

            runningMaxHeight = Math.max(runningMaxHeight, buildingHeight);
            idx +=step;
        }
        if(direction.equals("EAST")){
            Collections.reverse(buildingWithSunsetViews);
        }
        // Write your code here.
        return buildingWithSunsetViews;
    }

    public static void main(String[] args) {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        System.out.println(new SunsetViews().sunsetViews(buildings, direction));
    }
}
