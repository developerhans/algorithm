package com.hans.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 */
public class Ex05 {

    public static void main(String[] args) {
        Ex05 solution = new Ex05();

        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = solution.wordPattern(pattern, s);

        System.out.println(result);
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        int i = 0;
        while (i < Math.min(pattern.length(), words.length)) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) return false;
                map.put(pattern.charAt(i), words[i]);
            }

            i++;
        }

        return i == pattern.length() && i == words.length;
    }
}