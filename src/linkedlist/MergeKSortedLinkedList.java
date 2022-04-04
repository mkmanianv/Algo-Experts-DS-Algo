package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    // This is an input class. Do not edit.
    static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeKLists(LinkedList[] lists) {

        PriorityQueue<LinkedList> q = new PriorityQueue<>((a, b) -> (a.value - b.value));

        for(LinkedList node : lists) {
            if(node != null) q.offer(node);
        }

        LinkedList dummy = new LinkedList(-1);
        LinkedList pre = dummy;

        while(!q.isEmpty()) {
            LinkedList cur = q.poll();
            pre.next = cur;

            cur = cur.next;
            pre = pre.next;

            if(cur != null) q.offer(cur);
        }

        return dummy.next;

    }

    public static MergeKSortedLinkedList.LinkedList addMany(MergeKSortedLinkedList.LinkedList ll, List<Integer> values) {
        MergeKSortedLinkedList.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new MergeKSortedLinkedList.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public static void main(String[] args) {
        MergeKSortedLinkedList.LinkedList list1 = new MergeKSortedLinkedList.LinkedList(1);
        addMany(list1, new ArrayList<Integer>(Arrays.asList(4, 5)));
        MergeKSortedLinkedList.LinkedList list2 = new MergeKSortedLinkedList.LinkedList(1);
        addMany(list2, new ArrayList<Integer>(Arrays.asList(3, 4)));
        MergeKSortedLinkedList.LinkedList list3 = new MergeKSortedLinkedList.LinkedList(2);
        addMany(list2, new ArrayList<Integer>(Arrays.asList(6)));
        LinkedList[] input=new LinkedList[3];
        input[0]=list1;
        input[1]=list2;
        input[2]=list3;
        MergeKSortedLinkedList.LinkedList output = MergeKSortedLinkedList.mergeKLists(input);
    }
}
