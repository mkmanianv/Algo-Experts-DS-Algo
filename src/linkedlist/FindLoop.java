package linkedlist;

public class FindLoop {
    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head.next;
        LinkedList second= head.next.next;

        while(first!= second){
            first = first.next;
            second = second.next.next;
        }
        first = head;

        while(first!=second){
            first= first.next;
            second= second.next;
        }
        return first;
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
        test.getNthNode(10).next = test.getNthNode(5);
        FindLoop.findLoop(test);
    }

    static class TestLinkedList extends FindLoop.LinkedList {
        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            FindLoop.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new FindLoop.LinkedList(value);
                current = current.next;
            }
        }

        public FindLoop.LinkedList getNthNode(int n) {
            int counter = 1;
            FindLoop.LinkedList current = this;
            while (counter < n) {
                current = current.next;
                counter++;
            }
            return current;
        }
    }

}
