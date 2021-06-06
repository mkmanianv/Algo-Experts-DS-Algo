package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    int min;
    Node top;
    static class Node {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }
    public void MinStack(){
        this.top=null;
    }

    public void push(int x) {
        Node temp = new Node(x);
        if (top == null)
            this.min = x;
        else
            this.min = Math.min(min, x);
        if(top==null) {
            top = temp;
        }else {
            Node tempPush;
            tempPush = top;
            top = temp;
            top.next = tempPush;
        }
    }

    public void pop() {
        if(top != null) {
            Node tempPop = top;
            top = top.next;
            if(tempPop.data == min)
                setMin(top);
        }else {
            System.out.println("No more values to pop");
        }
    }

    public int top() {
        if (top != null)
            return this.top.data;
        else
            System.out.println("Empty stack, nothing at top");
        return -1;
    }

    public int getMin() {
        return this.min;
    }
    public void setMin(Node tempTop) {
        if (tempTop==null) {
            this.min = Integer.MIN_VALUE;
            return;
        }
        Node tempMin = tempTop;
        int min = tempTop.data;
        while(tempMin!=null) {
            min = Math.min(min, tempMin.data);
            tempMin= tempMin.next;
        }
        this.min = min;
    }
}
