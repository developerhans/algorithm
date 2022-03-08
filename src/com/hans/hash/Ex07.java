package com.hans.hash;

import java.util.*;

/**
 * Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class Ex07 {

    public static void main(String[] args) {
        Ex07 solution = new Ex07();

        int [] nums = {1,1,1,2,2,3};
        int k = 2;

        List<Integer> result = solution.topKFrequent(nums, k);

        result.forEach(System.out::println);
    }

    class Node implements Comparable<Node> {
        int val;
        int freq;
        public Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
        public int compareTo(Node o) {
            return o.freq - freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Node> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new Node(key, map.get(key)));
        }
        Collections.sort(list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).val);
        }
        return res;
    }

}