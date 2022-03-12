package com.hans.search;

/**
 * 문제 : Path SumII
 */

public class Ex07 {

    static class Solution {
        private int maxDiameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null) return 0;
            maxDepth(root);
            return this.maxDiameter;
        }
        public int maxDepth(TreeNode root) {
            int leftDepth = root.left==null ? 0 : maxDepth(root.left)+1;
            int rightDepth = root.right==null ? 0 : maxDepth(root.right)+1;
            this.maxDiameter = Math.max(this.maxDiameter, leftDepth+rightDepth);
            return Math.max(leftDepth,rightDepth);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);

        Solution t = new Solution();
        int result = t.diameterOfBinaryTree(root);

        System.out.println(result);


    }
}
