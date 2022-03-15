package com.hans.graph;

/**
 * Flood Fill
 * - https://leetcode.com/problems/flood-fill/
 *
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * Return the modified image after performing the flood fill.
 *
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 *
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 *
 *
 * Number of Islands 와 동일한 문제 인접
접*/
public class Ex04 {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int color = image[sr][sc];
            if(color != newColor)
                dfschange(image, sr, sc, newColor, color);
            return image;
        }
        public void dfschange(int[][] image, int sr, int sc, int newColor, int orignal){
            if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != orignal)
                return;
            image[sr][sc] = newColor;
            dfschange(image, sr + 1, sc, newColor, orignal);
            dfschange(image, sr - 1, sc, newColor, orignal);
            dfschange(image, sr, sc + 1, newColor, orignal);
            dfschange(image, sr, sc - 1, newColor, orignal);
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},{1,1,0},{1,0,1}
        };
        int sr = 1, sc = 1, newColor = 2;

        Ex04.Solution t = new Ex04.Solution();

        int[][] result = t.floodFill(image, sr, sc, newColor);
        for (int[] a: result) {
            for (int b:a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }
}
