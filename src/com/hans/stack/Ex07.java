package com.hans.stack;

import java.util.Stack;

/**
 * 문제 : Remove All Adjacent Duplicates In String
 *
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 */
public class Ex07 {

    static class Solution {
        public String removeDuplicates(String S) {
            Stack<Character> stack = new Stack();
            for(char ch: S.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String ex1 = "abbaca";
        Solution t = new Solution();
        String result = t.removeDuplicates(ex1);
        System.out.print(result);
    }
}
