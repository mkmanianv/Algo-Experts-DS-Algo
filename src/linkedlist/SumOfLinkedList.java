package linkedlist;

import java.util.ArrayList;

public class SumOfLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList sumOfLinkedLists=new LinkedList(0);
        LinkedList currentNode=sumOfLinkedLists;
        int carry=0;
        while(linkedListOne!=null || linkedListTwo!=null || carry !=0){
            int one=(linkedListOne == null)? 0:linkedListOne.value;
            int two=(linkedListTwo == null)? 0:linkedListTwo.value;
            int sum=one+two+carry;
            carry=sum/10;
            LinkedList newNode=new LinkedList(sum%10);
            currentNode.next=newNode;
            currentNode=newNode;
            linkedListOne=(linkedListOne == null)? null:linkedListOne.next;
            linkedListTwo=(linkedListTwo == null)? null:linkedListTwo.next;
        }
        return sumOfLinkedLists.next;
    }

    public static void main(String[] args) {
        SumOfLinkedList.LinkedList ll1 = addMany(new SumOfLinkedList.LinkedList(2), new int[] {4, 7, 1});
        SumOfLinkedList.LinkedList ll2 = addMany(new SumOfLinkedList.LinkedList(9), new int[] {4, 5});
        SumOfLinkedList.LinkedList expected = addMany(new SumOfLinkedList.LinkedList(1), new int[] {9, 2, 2});
        var actual = new SumOfLinkedList().sumOfLinkedLists(ll1, ll2);
        System.out.println(getNodesInArray(expected).equals(getNodesInArray(actual)));
    }

    public static SumOfLinkedList.LinkedList addMany(SumOfLinkedList.LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new SumOfLinkedList.LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public static ArrayList<Integer> getNodesInArray(SumOfLinkedList.LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        SumOfLinkedList.LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }
}
