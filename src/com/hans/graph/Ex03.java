package com.hans.graph;

/**
 * Number of Islands
 * - https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class Ex03 {
    static class Solution {

        private int n;
        private int m;

        public int numIslands(char[][] grid) {
            int count = 0;
            n = grid.length;
            if (n == 0) return 0;
            m = grid[0].length;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++)
                    if (grid[i][j] == '1') {
                        DFSMarking(grid, i, j);
                        ++count;
                    }
            }

            for (char[] a: grid) {
                for (char b:a) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }

            return count;
        }

        private void DFSMarking(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
            grid[i][j] = '0';
            DFSMarking(grid, i + 1, j);
            DFSMarking(grid, i - 1, j);
            DFSMarking(grid, i, j + 1);
            DFSMarking(grid, i, j - 1);

            //System.out.println(grid);
        }
    }

    public static void main(String[] args) {
        char[][] temp = {
                          {'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}
                        };

        Solution t = new Solution();

        System.out.println(t.numIslands(temp));

    }
}