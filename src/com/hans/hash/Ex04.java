package com.hans.hash;

import java.util.HashMap;

/**
 * Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * 생각할것
 * - 회전 공식이 있는데 생각보다 어려움.. https://youtu.be/m340QHYvFXI
 */
public class Ex04 {

    public static void main(String[] args) {
        Ex04 solution = new Ex04();

        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);

        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.put(ch, map.get(ch) - 1);
        }

        for (int c : map.values()) {
            if (c != 0) return false;
        }
        return true;
    }
}