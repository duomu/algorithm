package main.java.com.yll.array;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        while (!queue.isEmpty()) {
            Integer val = queue.poll();
            System.out.println(val);

        }
    }
}
