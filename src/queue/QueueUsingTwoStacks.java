package queue;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noElements = in.nextInt();

        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();

        int command;

        for (int i = 0 ; i < noElements ; i++) {
            command = in.nextInt();

            if (command == 1)
            {
                one.push(in.nextInt());
            }
            else if (command == 2)
            {
                if(two.isEmpty())
                {
                    while(!one.isEmpty())
                    {
                        two.push(one.pop());
                    }
                }

                if (!two.isEmpty()){
                    two.pop();
                }

            }
            else if (command == 3)
            {
                if(two.isEmpty())
                {
                    while(!one.isEmpty())
                    {
                        two.push(one.pop());
                    }
                    System.out.println(two.peek());
                }
                else
                {
                    System.out.println(two.peek());
                }
            }
        }
    }

}
