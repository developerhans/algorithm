package com.hans.array;

/**
 * Binary Search
 * https://leetcode.com/problems/binary-search/
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * 생각할것
 *  mid 공식
 *      int mid = left + (right - left) / 2;
 */
public class Ex11 {

    public static void main(String[] args) {
        Ex11 s = new Ex11();

        int[] ex = {-1,0,3,5,9,12};
        int target = 9;
        int result = s.search(ex, target);

        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}