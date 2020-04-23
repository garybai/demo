package com.example.structurealgorithmdemo.stack;

import java.util.Stack;

/**
 * 基于数组的栈测试
 *
 * @author Gary
 * @date 2019/12/9 15:43
 * @since jdk1.8
 **/
public class MyArrayStackTest {

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(3);
        stack.push(1);
        System.out.println(stack.peek());
        stack.push("abc");
        System.out.println(stack.peek());
        stack.push(2);
        stack.push("d");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        // 用栈实现字符串的逆序
        MyArrayStack stack1 = new MyArrayStack();
        String s = "Hello, hao are you!";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stack1.push(c);
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop());
        }
        System.out.println();

        // jdk 自带栈
        Stack<Character> stack3 = new Stack<>();
        for (char c : chars) {
            stack3.push(c);
        }
        while (!stack3.isEmpty()) {
            System.out.print(stack3.pop());
        }
        System.out.println();

//        String s1 = "Hello, hao are you!";
//        char[] chars1 = s.toCharArray();
//        for (int i = chars.length - 1; i >= 0; i--) {
//            System.out.print(chars1[i]);
//        }

        MyArrayStack stack2 = new MyArrayStack();
        String str = "12<a[b{c}]}";
        char[] chr = str.toCharArray();
        for (char c : chr) {
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack2.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if (!stack2.isEmpty()) {
                        char ch = (char) stack2.pop();
                        boolean b1 = c == '}' && ch != '{';
                        boolean b2 = c == ']' && ch != '[';
                        boolean b3 = c == '>' && ch != '<';
                        if (b1 || b2 || b3) {
                            System.out.println("Error:" + ch + "---" + c);
                        }
                    } else {
                        System.out.println("Error:空" + "---" + c);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
