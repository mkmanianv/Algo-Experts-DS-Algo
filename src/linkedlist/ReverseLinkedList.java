package linkedlist;

import java.util.List;

public class ReverseLinkedList {
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prevNode = null;
        LinkedList curNode = head;
        while(curNode != null){
            LinkedList nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        ReverseLinkedList.LinkedList test = newLinkedList(new int[] {0, 1, 2, 3, 4, 5});
        ReverseLinkedList.reverseLinkedList(test);
    }

    public static ReverseLinkedList.LinkedList newLinkedList(int[] values) {
        ReverseLinkedList.LinkedList ll = new ReverseLinkedList.LinkedList(values[0]);
        ReverseLinkedList.LinkedList current = ll;
        for (int i = 1; i < values.length; i++) {
            current.next = new ReverseLinkedList.LinkedList(values[i]);
            current = current.next;
        }
        return ll;
    }
}
