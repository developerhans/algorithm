package com.hans.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 문제 : Path SumII
 */



public class Ex06 {

    static class Solution {
        private List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        public void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
            path.push(root.val);
            if(root.left == null && root.right == null) {
                if(sum == root.val) resultList.add(new ArrayList<Integer>(path));
            }

            if(root.left!=null)
                pathSumInner(root.left, sum-root.val, path);

            if(root.right!=null)
                pathSumInner(root.right, sum-root.val, path);
            path.pop();
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if(root==null) return resultList;
            Stack<Integer> path = new Stack<Integer>();
            pathSumInner(root, sum, path);
            return resultList;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target = 22;
        Solution t = new Solution();
        List<List<Integer>> result = t.pathSum(root, target);



    }
}
