package com.hans.array;

/**
 * Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * 생각할것
 * positive integers
 */
public class Ex14 {

    public static void main(String[] args) {
        Ex14 s = new Ex14();

        int[] ex = {2,3,1,2,4,3};
        int target = 7;
        int result = s.minSubArrayLen(target, ex);

        System.out.print(result);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= s) {
                min = Math.min(min, i - start + 1);
                while (sum - nums[start] >= s) {
                    sum -= nums[start];
                    start++;
                    min = Math.min(min, i - start + 1);
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}