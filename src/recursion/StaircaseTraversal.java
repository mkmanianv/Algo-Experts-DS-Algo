package recursion;

public class StaircaseTraversal {

    public static void main(String[] args) {
        System.out.println(new StaircaseTraversal().staircaseTraversal(4, 2));
    }

    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        return numberofWaysToTravelToTop(height, maxSteps);
    }

    public int numberofWaysToTravelToTop(int height, int maxSteps) {
        if (height <= 1) {
            return 1;
        }
        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberofWaysToTravelToTop(height - step, maxSteps);
        }
        return numberOfWays;

    }
}
