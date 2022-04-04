package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ShiftLinkedList {
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int listLength = 1;
        LinkedList tail = head;
        while (tail.next != null) {
            tail = tail.next;
            listLength++;
        }

        int offset = listLength - k;
        LinkedList newTail = head;
        for (int i = 1; i < offset; i++) {
            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        var head = new ShiftLinkedList.LinkedList(0);
        head.next = new ShiftLinkedList.LinkedList(1);
        head.next.next = new ShiftLinkedList.LinkedList(2);
        head.next.next.next = new ShiftLinkedList.LinkedList(3);
        head.next.next.next.next = new ShiftLinkedList.LinkedList(4);
        head.next.next.next.next.next = new ShiftLinkedList.LinkedList(5);
        var result = ShiftLinkedList.shiftLinkedList(head, 2);
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }


}
