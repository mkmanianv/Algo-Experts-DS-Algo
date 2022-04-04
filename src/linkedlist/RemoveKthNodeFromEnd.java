package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveKthNodeFromEnd {

    // two pointer concept
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList first=head;
        LinkedList second=head;
        int counter=1;
        // move second pointer kth node from start
        while(counter<=k){
            second=second.next;
            counter++;
        }

        if(second==null){
            head.value=head.next.value; // value should be copied first and then the address
            head.next=head.next.next;
            return;
        }

        // move both first and second pointer until second pointer reaches the end.
        while(second.next!=null){
            second=second.next;
            first=first.next;
        }
        // first pointer will be one step back to the reach the destination node.
        first.next=first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        RemoveKthNodeFromEnd.removeKthNodeFromEnd(test, 10);
        System.out.println(compare(test.getNodesInArray(), expected));
    }

    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    static class TestLinkedList extends RemoveKthNodeFromEnd.LinkedList {

        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            RemoveKthNodeFromEnd.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new RemoveKthNodeFromEnd.LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            RemoveKthNodeFromEnd.LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
