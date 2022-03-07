package com.hans.string;

import java.util.*;

/**
 * 문제 : 그룹 아나그램
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 생각할것
 * - 슬라이딩 윈도우를 활용한 방법 적용을 하려고 했는데, 해당 코드는 맵을 통하여 포인터가 아닌 맵으로 해결함.
 */
public class Ex12 {

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        String strs = "abcabcbb";
        Solution t = new Solution();
        int result = t.lengthOfLongestSubstring(strs);

        System.out.println("result = " + result);
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max_len = 0;
            int start = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))){
                    start = map.get(s.charAt(i)) + 1;
                } else{
                    max_len = Math.max(max_len, i-start+1);
                }
                map.put(s.charAt(i), i);
            }
            return max_len;
        }
    }


}


