package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) /2;
            for (int currentIdx= firstParentIdx; currentIdx >= 0; currentIdx--){
                siftDown(currentIdx, array.size()-1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {

                int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;

                int idxToSwap;

                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;

                } else {

                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private void swap(int i, int j, List<Integer> heap) {
            int temp = heap.get(i);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
        }

        public int peek() {
            // Write your code here.
            return -1;
        }

        public int remove() {
            // Write your code here.
            return -1;
        }

        public void insert(int value) {
            // Write your code here.
        }
    }

    public static void main(String[] args) {
        MinHeapConstruction.MinHeap minHeap =
                new MinHeapConstruction.MinHeap(
                        new ArrayList<>(
                                Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        minHeap.insert(76);
        assert (isMinHeapPropertySatisfied(minHeap.heap));
        assert(minHeap.peek() == -5);
        assert(minHeap.remove() == -5);
        assert(isMinHeapPropertySatisfied(minHeap.heap));
        assert(minHeap.peek() == 2);
        assert(minHeap.remove() == 2);
        assert(isMinHeapPropertySatisfied(minHeap.heap));
        assert(minHeap.peek() == 6);
        minHeap.insert(87);
        assert(isMinHeapPropertySatisfied(minHeap.heap));
    }

    static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }

        return true;
    }
}
