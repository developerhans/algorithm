package com.hans.array;

/**
 * Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * 생각할것
 *  버블스왑등을 고려 할 수 있는데 문제에 따라서, 선택공간은 스왑하던가, 아니면 이동 후 나머지를 체우는 방법으로 진행
 */
public class Ex13 {

    public static void main(String[] args) {
        Ex13 s = new Ex13();

        int[] ex = {1,7,3,6,5,6};
        int result = s.pivotIndex(ex);

        System.out.print(result);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }

        return -1;
    }
}