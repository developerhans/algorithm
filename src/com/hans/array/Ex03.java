package com.hans.array;

/**
 * 문제 : 숫자 뒤집기
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * 생각할것
 */
public class Ex03 {


    public static void main(String[] args) {
        int ex = 123;
        Solution t = new Solution();
        int result = t.reverse(ex);
        System.out.print(result);
    }
}

class Solution {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        long reverse = 0;
        while (x != 0) {
            int last_digit = x % 10;
            reverse = reverse * 10 + last_digit;
            x = x / 10;
        }

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        } else
            // System.out.println((int)reverse);
            return (int) reverse;


    }
}
