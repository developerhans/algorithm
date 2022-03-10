package com.hans.stack;

import java.util.Stack;

/**
 * 문제 : Remove All Adjacent Duplicates in String II
 *
 * 설명
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * We repeatedly make k duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 *
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 *
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
public class Ex06 {

    public String removeDuplicates(String s, int k) {

        Stack<Character> charSt=new Stack<>();
        Stack<Integer> countSt=new Stack<>();

        for(char ch:s.toCharArray()){
            if(charSt.size()>0 && charSt.peek()==ch) countSt.push(countSt.peek()+1);
            else countSt.push(1);

            charSt.push(ch);
            if(countSt.peek()==k){
                for(int i=0;i<k;i++){
                    charSt.pop();
                    countSt.pop();
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        while(charSt.size()>0) sb.append(charSt.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String ex1 = "deeedbbcccbdaa";
        int target = 3;

        Ex06 t = new Ex06();
        String result = t.removeDuplicates(ex1, target);
        System.out.print(result);
    }
}
