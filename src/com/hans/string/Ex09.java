package com.hans.string;

/**
 * 문제 : 문자열 찾기
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 * 습득해야할것
 * - 스트링 매칭은 O(n)으로 해결 할 수 있다.
 * - KMP, rabin karp(rolling-hash)알고리즘을 이용할 수 있다.
 *
 * 최종적으로 “COOL"로 해석됩니다.
 * - 스스로 생각
 *      - 선택한 슬라이드의 해쉬를 찾는 문자열 해쉬와 비교후 종료하는것이 아니라, 케릭터를 정상적으로 비교한다.(해쉬충돌)
 *      - TODO : KMP알고리즘으로 풀어보기.
 */
public class Ex09 {

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        String haystack = "hello";
        String needle = "ll";
        Solution t = new Solution();
        int result = t.strStr(haystack, needle);
        System.out.println("result = " + result);
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
    }

}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (needle.hashCode() == haystack.substring(i, i + needle.length()).hashCode()) {
                boolean equal = true;
                for (int j = i, k = 0; k < needle.length(); j++, k++) { // 해쉬충돌 가능성이 존재하기 떄문에 케릭터를 정상적으로 비교한다.
                    if (haystack.charAt(j) != needle.charAt(k)) {
                        equal = false;
                        break;
                    }
                }
                if (equal)
                    return i;
            }

        }
        return -1;
    }
}
