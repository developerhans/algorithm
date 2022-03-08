package com.hans.array;

/**
 * Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 생각할것
 * - 회전 공식이 있는데 생각보다 어려움.. https://youtu.be/m340QHYvFXI
 */
public class Ex16 {

    public static void main(String[] args) {
        Ex16 s = new Ex16();

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        s.rotate(matrix);

        for (int[] i : matrix) {
            for (int z : i) {
                System.out.print(z + ", ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i <= m / 2; i++) {
            for (int j = 0; j < m - 2 * i - 1; j++) {
                int tmp                 = matrix[i][i+j];
                matrix[i][i+j]          = matrix[m-1-i-j][i];
                matrix[m-1-i-j][i]      = matrix[m-1-i][m-1-i-j];
                matrix[m-1-i][m-1-i-j]  = matrix[i+j][m-1-i];
                matrix[i+j][m-1-i]      = tmp;


            }
        }
    }
}