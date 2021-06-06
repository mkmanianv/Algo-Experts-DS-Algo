package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateRemoval {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        if(linkedList==null){
            return null;
        }
        int previousValue=linkedList.value;
        LinkedList res = new LinkedList(previousValue);
        LinkedList current = res;
        while (linkedList.next!=null){
            if (previousValue != linkedList.value) {
                previousValue = linkedList.value;
                current.next = new LinkedList(linkedList.value);
                current = current.next;
            }
            linkedList=linkedList.next;
        }
        if(previousValue!=linkedList.value) {
            current.next = new LinkedList(linkedList.value);
        }
        return res;
    }

    public static DuplicateRemoval.LinkedList addMany(DuplicateRemoval.LinkedList ll, List<Integer> values) {
        DuplicateRemoval.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new DuplicateRemoval.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public static List<Integer> getNodesInArray(DuplicateRemoval.LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        DuplicateRemoval.LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }


    public static void main(String[] args) {
        DuplicateRemoval.LinkedList input = new DuplicateRemoval.LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(9, 11, 15, 15, 16, 17)));
        DuplicateRemoval.LinkedList output = new DuplicateRemoval().removeDuplicatesFromLinkedList(input);
        System.out.println(getNodesInArray(output));
    }
}
