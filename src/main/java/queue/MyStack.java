package main.java.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈 leetcode 225
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        dumpQueue();
        return queue.remove();
    }

    public int top() {
        dumpQueue();
        Integer remove = queue.remove();
        queue.add(remove);
        return remove;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void dumpQueue() {
        int size = queue.size();
        while (size - 1 != 0) {
            queue.add(queue.poll());
            size--;
        }
    }
}
