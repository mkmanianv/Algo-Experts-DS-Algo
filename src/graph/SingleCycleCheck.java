package graph;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int numOfElementesVisited = 0;
        int currentIdx = 0;
        while (numOfElementesVisited < array.length) {
            if (numOfElementesVisited > 0 && currentIdx == 0) {
                return false;
            }
            numOfElementesVisited++;
            currentIdx = getNextIdx(array, currentIdx);
        }
        return currentIdx == 0;
    }

    private static int getNextIdx(int[] array, int currentIdx) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        if (nextIdx >= 0) {
            return nextIdx;
        } else {
            return nextIdx + array.length;
        }
    }

    public static void main(String[] args) {
        System.out.println(SingleCycleCheck.hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2}));
    }
}
