package com.hans.bit;

/**
 * 문제 : Hamming Distance
 * - https://leetcode.com/problems/hamming-distance/
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 *
 * Example 1:
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 *
 * Example 2:
 * Input: x = 3, y = 1
 * Output: 1
 *
 * a = 3 -> 11
 * b = 2 -> 10
 *
 * a & b = 10
 * a | b = 11
 * a ^ b = 01 ; 두 비트가 다르면 1, 아니면 0
 *
 * a >> 1 = 01; a의 모든 비트를 오른쪽으로 1만큼 밀고, 맨 왼쪽을 0으로 채움
 * a << 1 = 10; a의 모든 비트를 왼쪽으로 1만큼 밀고, 맨 오른을 0으로 채움
 *
 */
public class Ex01 {
    static class Solution {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int cnt = 0;

            for(int i = 0; i < 32; i++) {
                cnt += (xor >> i) & 1;
            }

            //Integer.bitCount(xor);
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        int x = 1;
        int y = 4;
        int result = t.hammingDistance(x, y);

        System.out.println("result = " + result);
    }
}
