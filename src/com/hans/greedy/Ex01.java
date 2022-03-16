package com.hans.greedy;

/**
 * 문제 : Remove All Adjacent Duplicates In String
 *
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the character i in s.
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
 *
 * Example 1:
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 *
 * Example 2:
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 *
 * Example 3:
 * Input: s = "aabaa", cost = [1,2,3,4,1]
 * Output: 2
 * Explanation: Delete the first and the last character, getting the string ("aba").
 */
public class Ex01 {

    static class Solution {

        public int minCost(String s, int[] cost) {
            int answer = 0;
            int pre = 0;

            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) != s.charAt(pre)) {
                    pre = i;
                } else {
                    answer += Math.min(cost[pre], cost[i]);
                    if(cost[pre] < cost[i]) {
                        pre = i;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        String ex1 = "abaac";
        int[] cost = {1,2,3,4,5};
        Solution t = new Solution();
        int result = t.minCost(ex1, cost);
        System.out.print(result);
    }
}
