public class ContainerWithMostWater {


    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while (i <= j) {
            int min = Math.min(height[i], height[j]);
            int currentMaxArea = min * (j - i);
            if (min == height[i]) {
                i++;
            } else {
                j--;
            }

            if (currentMaxArea > maxArea) {
                maxArea = currentMaxArea;
            }

        }

        return maxArea;
    }
}
