package com.hans.string;

/**
 * 문제 : 문자열 찾기
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * 생각할것
 * - answer.insert(0, sum % 10); 을하는데, 이것은 배열의 앞쪽에 데이터를 넣는 행위로 배열에서는 비용이 많으 들어가는 방법이다.
 * - 차라리 134를 431로 앞쪽부터 저장 후 리버스 하는게 좋을 수 있다.
 */
public class Ex10 {

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        String num1 = "11";
        String num2 = "123";
        Solution t = new Solution();
        String result = t.addStrings(num1, num2);
        System.out.println("result = " + result);
        System.out.println("run time = " + (System.currentTimeMillis() - st) + "ms");
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            if (num1 == null || num1.isEmpty()) {
                return num2;
            }
            if (num2 == null || num2.isEmpty()) {
                return num1;
            }

            int len1 = num1.length();
            int len2 = num2.length();
            int carry = 0;
            int c1;
            int c2;
            StringBuilder answer = new StringBuilder();
            while (len1 > 0 || len2 > 0 || carry > 0) {
                c1 = len1-- > 0 ? num1.charAt(len1) - '0' : 0;
                c2 = len2-- > 0 ? num2.charAt(len2) - '0' : 0;
                int sum = carry + c1 + c2;
                carry = sum / 10;
                answer.insert(0, sum % 10);
            }

            return answer.toString();

        }
    }

}


