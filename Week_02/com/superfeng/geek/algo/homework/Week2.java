package com.superfeng.geek.algo.homework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Week2
 * 第二周作业题
 *
 * @author fc
 * @version 1.0
 * @date 2020/12/7 22:15
 */
public class Week2 {

    public static void practiceStack() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack中的内容：" + stack.toString());
        stack.pop();
        stack.pop();
        int num = stack.search(3);
        System.out.println("元素3是否存在：" + (num == -1));
        Integer stackNum = stack.peek();
        System.out.println("pop两个操作后栈顶的元素：" + stackNum);
        System.out.println("stack剩余元素：" + stack.toString());
    }

    public static void practiceQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.add("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println("队列中的内容：" + queue.toString());

        String s = queue.peek();
        System.out.println("队头元素：" + s);
        System.out.println("输出队头元素one: " + queue.poll());
        //System.out.println("输出队头元素two: " + queue.remove());

    }

    public static void practiceDequeue() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addLast("5");
        deque.add("3");
        System.out.println("双端队列头：" + deque.getFirst());
        System.out.println("双端队列尾：" + deque.getLast());
        System.out.println("双端队列：" + deque.toString());
        System.out.println("pop出双端队列" + deque.pop());
        System.out.println("双端队列：" + deque.toString());
        System.out.println(deque.offer("6"));
        System.out.println(deque.toString());
        deque.clear();
        System.out.println(deque.poll());
        System.out.println(deque.remove());

    }

    public static void main(String[] args) {
        //practiceStack();
        //practiceQueue();
        practiceDequeue();
    }
}

