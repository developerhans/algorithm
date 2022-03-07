package com.hans.string;

import java.util.*;

/**
 * 문제 : 그룹 아나그램
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * 생각할것
 * - 아래 코드는 해당 아이템들을 정렬하는게 포인트, 하지만 정렬없이 알파벳 테이블등을 활용하여 정렬을 회피할 수 있음.
 */
public class Ex11 {

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        Solution t = new Solution();
        List<List<String>> result = t.groupAnagrams(strs);

        for (List<String> item:result) {
            System.out.println("item = " + item);
        }

        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> list = new ArrayList<>();
            HashMap<String , ArrayList<String>> map = new HashMap<>();
            for(String s : strs){
                char[] ch = s.toCharArray();
                //sorted strings with same chars, will be the same
                Arrays.sort(ch);
                String sorted_string = new String(ch);
                if(map.containsKey(sorted_string)){
                    ArrayList<String> currlist = map.get(sorted_string);
                    currlist.add(s);
                    map.put(sorted_string,currlist);
                }
                else{
                    ArrayList<String> li = new ArrayList();
                    li.add(s);
                    map.put(sorted_string,li);
                }
            }


            for(String s : map.keySet()){
                list.add(new ArrayList(map.get(s)));
            }

            return list;
        }

        /*public List<List<String>> groupAnagrams(String[] strs) {
            Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
            for (String word: strs){
                //Create freq table
                Map<Character, Integer> freq = new HashMap<>();
                for (char c : word.toCharArray())
                    freq.put(c, freq.getOrDefault(c, 0) + 1);

                List<String> anagrams = map.get(freq);
                if (anagrams == null) anagrams = new ArrayList<>();
                anagrams.add(word);
                map.put(freq, anagrams);

            }

            List<List<String>> sol = new ArrayList<>();

            for (Map<Character, Integer> freq: map.keySet()) sol.add(map.get(freq));

            return sol;
        }*/
    }


}


