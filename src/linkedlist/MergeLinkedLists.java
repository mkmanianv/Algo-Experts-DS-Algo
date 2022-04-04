package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeLinkedLists {

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList p1 = headOne;
        LinkedList prev = null;
        LinkedList p2 = headTwo;
        while(p1 != null && p2 != null){
            if(p1.value < p2.value){
                prev = p1;
                p1=p1.next;
            }else{
                if(prev != null){
                    prev.next = p2;
                }
                prev =p2;
                p2 = p2.next;
                prev.next = p1;
            }
        }
        if(p1 == null){
            prev.next = p2;
        }
        return headOne.value < headTwo. value? headOne: headTwo;
    }

    public static MergeLinkedLists.LinkedList addMany(MergeLinkedLists.LinkedList ll, List<Integer> values) {
        MergeLinkedLists.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new MergeLinkedLists.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public static List<Integer> getNodesInArray(MergeLinkedLists.LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        MergeLinkedLists.LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    public static void main(String[] args) {
       
        
            MergeLinkedLists.LinkedList list1 = new MergeLinkedLists.LinkedList(2);
            addMany(list1, new ArrayList<Integer>(Arrays.asList(6, 7, 8)));
            MergeLinkedLists.LinkedList list2 = new MergeLinkedLists.LinkedList(1);
            addMany(list2, new ArrayList<Integer>(Arrays.asList(3, 4, 5, 9, 10)));
            MergeLinkedLists.LinkedList output = MergeLinkedLists.mergeLinkedLists(list1, list2);
            List<Integer> expectedNodes =
                    new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(getNodesInArray(output).equals(expectedNodes));
    }
}
