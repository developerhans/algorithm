package com.hans.array;

/**
 * 문제 : 연속 부분수열
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 *
 * 생각할것, 규칙
 * -
 */
public class Ex08 {

    public int solution(int m, int[] arr){
        int answer=0, sum=0, lt=0;
        for(int rt=0; rt< arr.length; rt++){
            sum+=arr[rt];
            if(sum==m) answer++;
            while(sum>=m){
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[] ex1 = {1, 2, 1, 3, 1, 1, 1, 2};
        int target = 6;
        Ex08 t = new Ex08();
        int result = t.solution(target, ex1);
        System.out.print(result);
    }
}
