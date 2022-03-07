package com.hans.array;

/**
 * 문제 : 격자판 최대수 구하기
 */
public class Ex04 {

    public int solution(int n, int[][] arr){
        int answer=-2147000000;
        int sum1=0, sum2=0;
        for(int i=0; i< n; i++){
            sum1=sum2=0;
            for(int j=0; j< n; j++){
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            answer=Math.max(answer, sum1);
            answer=Math.max(answer, sum2);
        }
        sum1=sum2=0;
        for(int i=0; i<n; i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
        }
        answer=Math.max(answer, sum1);
        answer=Math.max(answer, sum2);
        return answer;
    }

    public static void main(String[] args){
        int[][] ex = {{10, 13, 10, 12, 15}, {12, 39, 30, 23, 11}, {11, 25, 50, 53, 15}, {19, 27, 29, 37, 27}, {19, 13, 30, 13, 19}};
        Ex04 t = new Ex04();
        int result = t.solution(5, ex);
        System.out.print(result);
    }
}
