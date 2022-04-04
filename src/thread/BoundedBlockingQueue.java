package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private Node head;
    private Node last;
    private int size = 0;
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size == capacity) {
                full.await();
            }
            if (head == null) {
                head = new Node(element);
                last = head;
            } else {
                last.next = new Node(element);
                last = last.next;
            }
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (head == null) {
                empty.await();
            }
            var result = head.val;
            head = head.next;
            size--;
            full.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return size;
    }

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }
}
