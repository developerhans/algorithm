package com.hans.programmers.lv2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12945
 *
 * 피보나치 수
 * 문제 설명
 * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
 *
 * 예를들어
 *
 * F(2) = F(0) + F(1) = 0 + 1 = 1
 * F(3) = F(1) + F(2) = 1 + 1 = 2
 * F(4) = F(2) + F(3) = 1 + 2 = 3
 * F(5) = F(3) + F(4) = 2 + 3 = 5
 * 와 같이 이어집니다.
 *
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * n은 2 이상 100,000 이하인 자연수입니다.
 *
 * 입출력 예
 * ------------------------------------------------------
 * n	| return
 * ------------------------------------------------------
 * 3	| 2
 * 5	| 5
 * ------------------------------------------------------
 *
 * 입출력 예 설명
 * 피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
 *
 * result = 테스트 7 ~ 14번 통과못함, 테스트 케이스를 알 수 없어.. 이유를 모르겠음.
 *
 * 테스트 7 ~ 14번 통과 못한 이유 모듈러 연산에서 나온 숫자가 int 자료형 범위를 넘어가서 통과 할 수 없었음.
 * 피보나치 배열에 값을 담는게 아닌, 모듈러 연산 결과를 담아야함.
 *
 */public class FibonacciNumbers {
    static class Solution {

        public int solution(int n) {
            if(n >= 100000) return 0;
            int answer = 0;

            if(n == 0) return 0;
            if(n == 1) return 1;

            int[] fib_array = new int[n + 1];
            fib_array[0] = 0;
            fib_array[1] = 1;

            for (int i = 2; i < n + 1; i++) {
                int num = fib_array[i-1]+fib_array[i-2];
                fib_array[i] = num;
            }

            answer = fib_array[n] % 1234567;
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 35;
        Solution solution = new Solution();
        int result = solution.solution(n);

        System.out.println(result);
    }
}
