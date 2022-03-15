package com.hans.dp;

/**
 * Coin Change - https://leetcode.com/problems/coin-change/
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class Ex01 {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0)
                return -1;

            if (amount <= 0)
                return 0;

            int dp[] = new int[amount + 1]; // 0~amount 까지 모든 필요 동전을 구함.
            for (int i = 1; i < dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
            }

            for (int am = 1; am < dp.length; am++) {
                for (int i = 0; i < coins.length; i++) {
                    if (coins[i] <= am) {
                        int sub = dp[am - coins[i]];
                        if (sub != Integer.MAX_VALUE)
                            dp[am] = Math.min(sub + 1, dp[am]);
                    }
                }
            }
            //       0원 1원 2원 3원....
            // dp = [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]; 가 만들어짐
            return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        Solution ex = new Solution();
        int result = ex.coinChange(coins, amount);
        System.out.println(result);

    }
}
