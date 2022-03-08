package com.hans.array;

/**
 * Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * 생각할것
 *  버블스왑등을 고려 할 수 있는데 문제에 따라서, 선택공간은 스왑하던가, 아니면 이동 후 나머지를 체우는 방법으로 진행
 */
public class Ex12 {

    public static void main(String[] args) {
        Ex12 s = new Ex12();

        int[] ex = {0,1,0,3,12};
        s.moveZeroes(ex);

        for (int i:ex) {
            System.out.print(i + ", ");
        }

    }

    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}