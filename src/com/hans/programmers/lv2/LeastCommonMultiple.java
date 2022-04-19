package com.hans.programmers.lv2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 *
 * N개의 최소공배수
 *
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 유클리드 호제법이란?
 * 이와 같이 두수가 있으면 처음에 그 중 한 수(여기서는 b)로 나누고 나머지를 임시 변수(r)에 저장하고 나누어진수(a)는 나눈수(b)가 되고 나눈수(b)는 임시변수(r)이 된다.
 * 그리고 b가 0이 아닐때 까지 반복하다 0이 되면 a를 return 하게 되는데 a가 a,b의 최대공약수가 된다.
 *
 * 최소공배수란?
 * 공배수란, 이름에서 알 수 있듯이 두 수, 혹은 그 이상의 수들의 공통인 배수라는 뜻이다. 최소공배수는 당연히 공배수 중에서 가장 작은 것.
 * 두 수 a,b의 최소공배수를 기호로 lcm(a,b)로 표기하며, 더욱 줄이면 [a,b]로 표기하기도 한다.
 *
 * 최소공배수 구하는법
 * 간단하다 , 이것 또한 알고리즘 문제에서 가장 많이 쓰이는 식인데
 * 최소공배수 = 두수의 곱 / 두수의 최대공약수
 *
 */

public class LeastCommonMultiple {
    static class Solution {
        int gcd(int a, int b) {
            while(b!=0) {
                int r=a%b;
                a=b;
                b=r;
            }
            return a;
        }

        int lcm(int a,int b) {
            return a*b/gcd(a,b);
        }

        public int solution(int[] arr) {
            int answer = 0;
            int lcm1 = arr[0];
            for(int i=0;i<arr.length;i++) {
                lcm1 =lcm(lcm1,arr[i]);
            }
            return lcm1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        Solution solution = new Solution();
        int result = solution.solution(arr);
        System.out.println(result);
    }
}