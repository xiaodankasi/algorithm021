package com.superfeng.geek.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Week2
 * 第二周练习题
 *
 * @author fc
 * @version 1.0
 * @date 2020/12/7 22:15
 */
public class Week2 {
    /**
     * <a href="https://leetcode-cn.com/problems/3sum/">15.三数之和</a>
     *
     * @param nums 入参数组
     * @return 结果集
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //  排序
        Arrays.sort(nums);
        //  创建返参
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            // 重复的数字只找一次
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) {
                        continue;
                    }
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) {
                        continue;
                    }
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) {
                        continue;
                    }
                    while (i < j && nums[j] == nums[--j]) {
                        continue;
                    }
                }
            }
        }
        return result;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206.反转指针</a>
     *
     * @param head 待反转指针
     * @return 返参
     */
    public static ListNode reverseList(ListNode head) {
        /*ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;*/
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        // 链表的下一个结点的指针指向该结点，即做了反转
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/valid-parentheses/description/">
     * <strong>
     * 20.有效的括号
     * </strong>
     * </a>
     *
     * @param s 字符串
     * @return 是否有效的括号串
     */
    public static boolean isValid(String s) {
        // 判断是否为空串
        if (s.isEmpty()) {
            return true;
        }
        // 方法1 O(n) n = s.length
        /*LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();*/
        // 方法1 O(n) n = s.length
        /*LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> dic = new HashMap<>(3);
        dic.put('(', ')');
        dic.put('[', ']');
        dic.put('{', '}');
        for (char c : s.toCharArray()) {
            if (dic.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || dic.get(stack.pop()) != c) {
                return false;
            }
        }

        return stack.isEmpty();*/
        // 方法3 暴力破解 O(n^2)
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (length != s.length());

        return s.length() == 0;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/min-stack/">
     * <strong>
     * 155.最小栈
     * </strong>
     * </a>
     */
    class MinStack {
        class Node {
            private int value;
            private int min;
            private Node next;

            public Node(int value, int min) {
                this.value = value;
                this.min = min;
                this.next = null;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        // 栈顶元素
        Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            // 栈为空
            if (null == head) {
                head = new Node(x, x);
            } else {
                Node tempNode = new Node(x, Math.min(x, head.getMin()));
                tempNode.setNext(head);
                head = tempNode;
            }
        }

        public void pop() {
            if (null != head) {
                head = head.getNext();
            }
        }

        public int top() {
            if (null != head) {
                return head.getValue();
            }
            return -1;
        }

        public int getMin() {
            if (null != head) {
                return head.getMin();
            }
            return -1;
        }
    }

    public static class MinStack_2 {
        // 存取出入栈元素
        Stack<Integer> stack;
        // 存取最小元素
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack_2() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                if (x <= minStack.peek()) {
                    minStack.push(x);
                }
            }
            stack.push(x);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                if (stack.pop().equals(minStack.peek())) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        //"MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
		//	[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
        MinStack_2 minStack = new MinStack_2();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

        //System.out.println(isValid(""));
        //System.out.println(isValid("]"));
        //System.out.println(isValid("("));
        //System.out.println(isValid("()[]{}"));

        //System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        // 1->2->3->4->5->NULL
        //ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = null;
        //
        //System.out.println("输出原始入参");
        //ListNode input = head;
        //ListNode input2 = head;
        //while (head != null) {
        //    System.out.print(head.val + "->");
        //    head = head.next;
        //}
        //System.out.println();
        //ListNode result = reverseList(input);
        //System.out.println("输出反转结果");
        ///*while (result != null) {
        //    System.out.print(result.val + "->");
        //    result = result.next;
        //}*/
        //ListNode result1 = swapPairs(result);
        //System.out.println("\n" + "swapPairs:");
        //while (result1 != null) {
        //    System.out.print(result1.val + "->");
        //    result1 = result1.next;
        //}
        //System.out.println();

    }
}
